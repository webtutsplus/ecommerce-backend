package com.webtutsplus.ecommerce.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.webtutsplus.ecommerce.dto.cart.CartDto;
import com.webtutsplus.ecommerce.dto.cart.CartItemDto;
import com.webtutsplus.ecommerce.dto.checkout.CheckoutItemDto;
import com.webtutsplus.ecommerce.dto.order.OrderDto;
import com.webtutsplus.ecommerce.dto.order.PlaceOrderDto;
import com.webtutsplus.ecommerce.model.*;
import com.webtutsplus.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    OrderItemsService orderItemsService;


    public int saveOrder(PlaceOrderDto orderDto, int userId, String sessionID){
        Order order = getOrderFromDto(orderDto,userId,sessionID);
        return orderRepository.save(order).getId();
    }

    private Order getOrderFromDto(PlaceOrderDto orderDto, int userId,String sessionID) {
        Order order = new Order(orderDto,userId,sessionID);
        return order;
    }

    public List<Order> listOrders(int user_id) {
        List<Order> orderList = orderRepository.findAllByUserIdOrderByCreatedDateDesc(user_id);
        return orderList;
    }


    public static OrderDto getDtoFromOrder(Order order) {
        OrderDto orderDto = new OrderDto(order);
        return orderDto;
    }


    public void placeOrder(int userId, String sessionId) {
        CartDto cartDto = cartService.listCartItems(userId);

        PlaceOrderDto placeOrderDto = new PlaceOrderDto();
        placeOrderDto.setUserId(userId);
        placeOrderDto.setTotalPrice(cartDto.getTotalCost());

        int orderId = saveOrder(placeOrderDto, userId, sessionId);
        List<CartItemDto> cartItemDtoList = cartDto.getcartItems();
        for (CartItemDto cartItemDto : cartItemDtoList) {
            OrderItem orderItem = new OrderItem(
                    orderId,
                    cartItemDto.getProduct().getId(),
                    cartItemDto.getQuantity(),
                    cartItemDto.getProduct().getPrice());
            orderItemsService.addOrderedProducts(orderItem);
        }
        cartService.deleteCartItems(userId);
    }

    SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDto checkoutItemDto) {
        return SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency("usd")
                .setUnitAmount( ((long) checkoutItemDto.getPrice()) * 100)
                .setProductData(
                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                .setName(checkoutItemDto.getProductName())
                                .build())
                .build();
    }

    SessionCreateParams.LineItem createSessionLineItem(CheckoutItemDto checkoutItemDto) {
        return SessionCreateParams.LineItem.builder()
                .setPriceData(createPriceData(checkoutItemDto))
                .setQuantity(Long.parseLong(String.valueOf(checkoutItemDto.getQuantity())))
                .build();
    }

    public Session createSession(List<CheckoutItemDto> checkoutItemDtoList) throws StripeException {
        //TODO get it from application properties
        Stripe.apiKey = "sk_test_51Hr18ILR0wfBoBqmdYfX2snbVHPvMxGsUOUs0bZnOgJ28gGgGzOhvadzEjR0LDRS6naI0RMADLywiSiWD8pkhkEW00xnzbVoVE";
        long totalPrice = 0;
        for (CheckoutItemDto checkoutItemDto : checkoutItemDtoList) {
            totalPrice += checkoutItemDto.getPrice()*checkoutItemDto.getQuantity();
        }

        System.out.println("totalPrice cart : " + totalPrice);

        List<SessionCreateParams.LineItem> sessionItemsList = new ArrayList<SessionCreateParams.LineItem>();
        for (CheckoutItemDto checkoutItemDto : checkoutItemDtoList) {
            sessionItemsList.add(createSessionLineItem(checkoutItemDto));
        }

        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                //TODO make a baseurl: FRRONT_END_BASE_URL in config and remove hardcode localhost
                .setCancelUrl("http://localhost:8081/payment/failed")
                .addAllLineItem(sessionItemsList)
                .setSuccessUrl("http://localhost:8081/payment/success")
                .build();
        return Session.create(params);
    }
}


