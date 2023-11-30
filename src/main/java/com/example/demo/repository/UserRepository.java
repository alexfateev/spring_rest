package com.example.demo.repository;

import com.example.demo.Authorities;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserRepository {
    private ConcurrentHashMap<String, String> userList = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<Authorities>> userAuthoritiesList =
            new ConcurrentHashMap<>();

    public UserRepository() {
        userList.put("user1", "123");
        userAuthoritiesList.put("user1", Arrays.asList(Authorities.READ, Authorities.WRITE));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (userList.contains(user)) {
            if (userList.get(user).equals(password)) {
                return userAuthoritiesList.getOrDefault(user, null);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
