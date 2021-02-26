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

    public void createAnOrder(PlaceOrderDto orderDto, int userId){
        Order order = getOrderFromDto(orderDto,userId);
        orderRepository.save(order);

    }

    private Order getOrderFromDto(PlaceOrderDto orderDto, int userId) {
        Order order = new Order(orderDto,userId);
        return order;
    }


    public List<OrderDto> listOrders(int user_id) {
        List<Order> orderList = orderRepository.findAllByUserIdOrderByCreatedDateDesc(user_id);
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order:orderList){
            OrderDto orderDto = getDtoFromOrder(order);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }


    public static OrderDto getDtoFromOrder(Order order) {
        OrderDto orderDto = new OrderDto(order);
        return orderDto;
    }

}


