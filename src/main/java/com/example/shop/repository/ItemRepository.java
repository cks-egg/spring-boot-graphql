package com.example.shop.repository;

import com.example.shop.model.Item;
import com.example.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.Optional;

@GraphQlRepository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
