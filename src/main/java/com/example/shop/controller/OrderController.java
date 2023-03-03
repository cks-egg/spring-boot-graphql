package com.example.shop.controller;

import com.example.shop.model.Item;
import com.example.shop.model.Order;
import com.example.shop.model.OrderInput;
import com.example.shop.model.User;
import com.example.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class OrderController {
    private final OrderService orderService;

    @QueryMapping
    public Order getOrder(@Argument Long id) {
        return orderService.getOrder(id);
    }

    @QueryMapping
    public List<Order> getOrders(@Argument List<Long> idList){
        return orderService.getOrders(idList);
    }

    @MutationMapping
    public Order save(@Argument OrderInput input){
        return orderService.save(input);
    }

    @MutationMapping
    public Order delete(@Argument Long id){
        return orderService.delete(id);
    }
}
