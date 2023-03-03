package com.example.shop.service;

import com.example.shop.model.Item;
import com.example.shop.model.Order;
import com.example.shop.model.OrderInput;
import com.example.shop.model.User;
import com.example.shop.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public Order save(OrderInput input) {
        User user = new User();
        user.setId(input.getUserId());
        Item item = new Item();
        item.setId(input.getItemId());
        return orderRepository.save(new Order(input.getId(), user, item, input.getAmount()));
    }

    public Order delete(Long id){
        Order order = getOrder(id);
        orderRepository.delete(order);
        return order;
    }

    public Order getOrder(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getOrders(List<Long> idList){
        if (idList == null || idList.isEmpty()){
            return orderRepository.findAll();
        }
        return orderRepository.findAllById(idList);
    }
}
