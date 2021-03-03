package com.webtutsplus.ecommerce.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.SubscriptionCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.dto.ProductDTOs.AddToCartDto;
import com.webtutsplus.ecommerce.dto.ProductDTOs.CartDto;
import com.webtutsplus.ecommerce.dto.ProductDTOs.OrderDto;
import com.webtutsplus.ecommerce.dto.ProductDTOs.PlaceOrderDto;
import com.webtutsplus.ecommerce.exceptions.AuthenticationFailException;
import com.webtutsplus.ecommerce.exceptions.ProductNotExistException;
import com.webtutsplus.ecommerce.model.*;
import com.webtutsplus.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    OrderItemsService orderItemsService;

    private String sessionId;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addOrder(@RequestParam("token") String token,@RequestParam("sessionId") String sessionId) throws ProductNotExistException {
        System.out.println("Id we got = >" + sessionId);
        try {
            authenticationService.authenticate(token);
        }catch (AuthenticationFailException e){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid token"), HttpStatus.FORBIDDEN);
        }
        int userId = authenticationService.getUser(token).getId();
        CartCost cartCost = cartService.listCartItems(userId);
        PlaceOrderDto placeOrderDto = new PlaceOrderDto();
        placeOrderDto.setUserId(userId);
        placeOrderDto.setTotalPrice(cartCost.getTotalCost());
        Order order = new Order(placeOrderDto,userId,sessionId);
        int orderId = orderService.createAnOrder(placeOrderDto,userId,sessionId);
        List<CartDto>allProducts = cartCost.getcartItems();
        for (CartDto allProduct : allProducts) {
            OrderItems orderItem = new OrderItems(orderId, allProduct.getProduct().getId(), allProduct.getQuantity(),
                    allProduct.getProduct().getPrice());
            orderItemsService.addOrderedProducts(orderItem);
        }
        cartService.deleteCartItems(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        int userId = authenticationService.getUser(token).getId();
        List<Order> orderDtoList = orderService.listOrders(userId);
        return new ResponseEntity<List<Order>>(orderDtoList,HttpStatus.OK);
    }

    @PostMapping("/create-checkout-session")
    public ResponseEntity<StripeResponse> checkout(@RequestBody List<CheckoutBody> checkoutBody) throws StripeException {

        Stripe.apiKey = "sk_test_51Hr18ILR0wfBoBqmdYfX2snbVHPvMxGsUOUs0bZnOgJ28gGgGzOhvadzEjR0LDRS6naI0RMADLywiSiWD8pkhkEW00xnzbVoVE";
        long price = 0;
        long quantity=1;
        for (CheckoutBody body : checkoutBody) {
            price += body.getPrice()*body.getQuantity();
            quantity+=body.getQuantity();
        }

        System.out.println("price cart : " + price);

        List<SessionCreateParams.LineItem> items = new ArrayList<SessionCreateParams.LineItem>();
        for (CheckoutBody checkoutBody1 : checkoutBody) {
            items.add(SessionCreateParams.LineItem.builder()
                    .setPriceData(
                            SessionCreateParams.LineItem.PriceData.builder()
                                    .setCurrency("usd")
                                    .setUnitAmount( ((long)checkoutBody1.getPrice()) * 100)
                                    .setProductData(
                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                    .setName(checkoutBody1.getProductName())
                                                    .build())
                                    .build())
                    .setQuantity(Long.parseLong(String.valueOf(checkoutBody1.getQuantity())))
                    .build());
        }

        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setCancelUrl("http://localhost:8081/payment/failed")
                .addAllLineItem(items)
                .setSuccessUrl("http://localhost:8081/payment/success")
                        /*List<SessionCreateParams.LineItem>allproducts=new List<SessionCreateParams.LineItem>() {

                        }
                        SessionCreateParams.LineItem.builder()
                                .setQuantity(quantity)
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency("usd")
                                                .setUnitAmount(price*100)
                                                .setProductData(
                                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                .setName("Dummy Product")
                                                                .build())
                                                .build())
                                .build())*/

                .build();
        Session session = Session.create(params);
        HashMap<String, String> responseData = new HashMap<String, String>();
        responseData.put("id", session.getId());

        System.out.println(session.getId());

        sessionId = session.getId();

        StripeResponse stripeResponse = new StripeResponse(session.getId());

        return new ResponseEntity<StripeResponse>(stripeResponse,HttpStatus.OK);

    }

}
