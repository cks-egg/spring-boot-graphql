package com.example.shop.repository;

import com.example.shop.model.Order;
import com.example.shop.model.OrderInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
