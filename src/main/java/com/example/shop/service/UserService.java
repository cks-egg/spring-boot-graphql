package com.example.shop.service;

import com.example.shop.model.User;
import com.example.shop.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public User save(String id, String name, String email, int age) {
        return userRepository.save(new User(id, name, email, age, null));
    }

    public User delete(String id){
        User user = getUser(id);
        userRepository.delete(user);
        return user;
    }

    public User getUser(String id){

        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers(List<String> idList){
        if (idList == null || idList.isEmpty()){
            return userRepository.findAll();
        }
        return userRepository.findAllById(idList);
    }
}
