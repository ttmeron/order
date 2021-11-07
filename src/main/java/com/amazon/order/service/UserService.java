package com.amazon.order.service;

import com.amazon.order.entity.User;

import java.util.Optional;

public interface UserService {
//    public Optional<User> findUserByEmail(String email);
    public  User findOrCreateUser(String name, String surname,String phone, String email,String address);
}
