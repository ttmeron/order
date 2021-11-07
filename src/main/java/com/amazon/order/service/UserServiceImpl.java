package com.amazon.order.service;

import com.amazon.order.entity.User;
import com.amazon.order.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.amazon.order.entity.UserRole.CUSTOMER;
import static java.util.Objects.nonNull;
import java.util.Optional;

@Service
public class  UserServiceImpl implements UserService {
//
//    @Autowired
//    UserRepo userRepo;
////    @Autowired(required = false)
////    User user;
//
////    @Override
////    public Optional<User> findUserByEmail(String email) {
////        return Optional.empty();
////    }
//
//    @Override
//    public User findOrCreateUser(String name, String surname, String phone, String email, String address) {
//
//
//        User oldUser = userRepo.findUserByEmail(email);
//        if (nonNull(oldUser)){
//            return oldUser;
//    }
//    User user = new User();
//    user.setRole(CUSTOMER.name());
//    user.setAddress(address);
//    user.setName(name);
//    user.setSurname(surname);
//    user.setPhone(phone);
//    user.setEmail(email);
//    return userRepo.save(user);
//
//
//}

    @Autowired
    UserRepo userRepo;

    @Override
    public User findOrCreateUser(String name, String surname, String phone, String email, String address) {

        User oldUser = userRepo.findUserByEmail(email);
        if(nonNull(oldUser)){
            return oldUser;
        }
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setRole(CUSTOMER.name());
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        return userRepo.save(user);

    }
}
