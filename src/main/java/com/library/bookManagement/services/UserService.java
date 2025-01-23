package com.library.bookManagement.services;

import com.library.bookManagement.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.library.bookManagement.config.DataConfig.usersList;

@Service
public class UserService {
    public User getUserById(String userId){
        return usersList.stream().filter(user -> user.getId().equals(userId)).toList().getFirst();
    }

    public User createUser(String userId, String userName){
        User user = new User(userId, userName, new ArrayList<>());
        usersList.add(user);
        return user;
    }
}
