package com.ingenieria.tfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingenieria.tfg.entity.User;
import com.ingenieria.tfg.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class CookieManager {

    @Autowired
    private UserService userService;

    public User getUsuario(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    return userService.findByUsername(cookie.getValue());
                }
            }
        }
        return null;
    }
}
