package com.example.newcoder.service;


import java.util.Map;

public interface LoginService {
    public Map<String, Object> login(String username, String password, int expiredSeconds);
    public void logout(String ticket);
}
