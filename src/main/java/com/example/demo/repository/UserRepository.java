package com.example.demo.repository;

import com.example.demo.Authorities;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private ConcurrentHashMap<String, String> userList = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<Authorities>> userAuthoritiesList =
            new ConcurrentHashMap<>();

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
