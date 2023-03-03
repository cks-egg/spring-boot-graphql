package com.example.shop.controller;

import com.example.shop.model.User;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @QueryMapping
    public User getUser(@Argument String id) {
        return userService.getUser(id);
    }

    @QueryMapping
    public List<User> userList(@Argument List<String> idList){
        return userService.getUsers(idList);
    }

    @MutationMapping
    public User saveUser(@Argument String id, @Argument String name, @Argument String email, @Argument int age){
        return userService.save(id, name, email, age);
    }

    @MutationMapping
    public User deleteUser(@Argument String id){
        return userService.delete(id);
    }
}
