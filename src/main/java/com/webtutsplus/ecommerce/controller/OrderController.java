package com.webtutsplus.ecommerce.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.dto.ProductDTOs.AddToCartDto;
import com.webtutsplus.ecommerce.dto.ProductDTOs.OrderDto;
import com.webtutsplus.ecommerce.dto.ProductDTOs.PlaceOrderDto;
import com.webtutsplus.ecommerce.exceptions.AuthenticationFailException;
import com.webtutsplus.ecommerce.exceptions.ProductNotExistException;
import com.webtutsplus.ecommerce.model.CartCost;
import com.webtutsplus.ecommerce.model.CheckoutBody;
import com.webtutsplus.ecommerce.model.StripeResponse;
import com.webtutsplus.ecommerce.service.AuthenticationService;
import com.webtutsplus.ecommerce.service.CartService;
import com.webtutsplus.ecommerce.service.OrderService;
import com.webtutsplus.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addOrder(@RequestBody PlaceOrderDto orderDto, @RequestParam("token") String token) throws AuthenticationFailException, ProductNotExistException {
        authenticationService.authenticate(token);
        int userId = authenticationService.getUser(token).getId();
        orderService.createAnOrder(orderDto,userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<List<OrderDto>> getAllOrders(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        int userId = authenticationService.getUser(token).getId();
        List<OrderDto> orderDtoList = orderService.listOrders(userId);
        return new ResponseEntity<List<OrderDto>>(orderDtoList,HttpStatus.OK);
    }
    @PostMapping("/create-checkout-session")
    public ResponseEntity<StripeResponse> checkout(@RequestBody CheckoutBody checkoutBody) throws StripeException {

        Stripe.apiKey = "sk_test_51Hr18ILR0wfBoBqmdYfX2snbVHPvMxGsUOUs0bZnOgJ28gGgGzOhvadzEjR0LDRS6naI0RMADLywiSiWD8pkhkEW00xnzbVoVE";

        long quantity = checkoutBody.getQuantity();
        long price = checkoutBody.getPrice()*100;
        String productName = checkoutBody.getProductName();

        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:8081/order")
                .setCancelUrl("http://localhost:8081/")
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setQuantity(quantity)
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency("inr")
                                                .setUnitAmount(price)
                                                .setProductData(
                                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                .setName(productName)
                                                                .build())
                                                .build())
                                .build())
                .build();
        Session session = Session.create(params);
        HashMap<String, String> responseData = new HashMap<String, String>();
        responseData.put("id", session.getId());

        System.out.println(session.getId());

        StripeResponse stripeResponse = new StripeResponse(session.getId());

        return new ResponseEntity<StripeResponse>(stripeResponse,HttpStatus.OK);

    }

}
