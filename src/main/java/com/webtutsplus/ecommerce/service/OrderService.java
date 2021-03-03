package com.webtutsplus.ecommerce.service;

import com.webtutsplus.ecommerce.dto.ProductDTOs.CartDto;
import com.webtutsplus.ecommerce.dto.ProductDTOs.OrderDto;
import com.webtutsplus.ecommerce.dto.ProductDTOs.PlaceOrderDto;
import com.webtutsplus.ecommerce.model.*;
import com.webtutsplus.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public int createAnOrder(PlaceOrderDto orderDto, int userId, String sessionID){
        Order order = getOrderFromDto(orderDto,userId,sessionID);
        return orderRepository.save(order).getId();
    }

    private Order getOrderFromDto(PlaceOrderDto orderDto, int userId,String sessionID) {
        Order order = new Order(orderDto,userId,sessionID);
        return order;
    }


    /*public List<OrderDto> listOrders(int user_id) {
        List<Order> orderList = orderRepository.findAllByUserIdOrderByCreatedDateDesc(user_id);
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order:orderList){
            OrderDto orderDto = getDtoFromOrder(order);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }*/

    public List<Order> listOrders(int user_id) {
        List<Order> orderList = orderRepository.findAllByUserIdOrderByCreatedDateDesc(user_id);
        /*List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order:orderList){
            OrderDto orderDto = getDtoFromOrder(order);
            orderDtoList.add(orderDto);
        }*/
        return orderList;
    }


    public static OrderDto getDtoFromOrder(Order order) {
        OrderDto orderDto = new OrderDto(order);
        return orderDto;
    }

}


