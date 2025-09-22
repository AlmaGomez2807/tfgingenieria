package com.ingenieria.tfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ingenieria.tfg.entity.User;
import com.ingenieria.tfg.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class GreetingController {
    @Autowired
    private UserService userService;

    @Autowired
    private CookieManager cookieManager;

    @RequestMapping("/")
    public String greeting() {
        return "principal";
    }

    @RequestMapping("/intermedia")
    public String intermedia(@RequestParam("username") String username, HttpServletResponse response) {
        // Creamos la cookie con el nombre de usuario
        Cookie cookie = new Cookie("username", username);
        cookie.setPath("/");
        cookie.setMaxAge(7 * 24 * 60 * 60); 
        response.addCookie(cookie);
        // Si el usuario no existe en la BBDD, lo guardamos
        if (userService.findByUsername(username) == null)
            userService.save(username);
        if(username.equals("admin"))
            return "redirect:/admin";
        return "redirect:/principalJuegos";
    }
    
    @RequestMapping("/principalJuegos")
    public String principalJuegos(HttpServletRequest request, Model model) {
        // Leer cookies
        User u = cookieManager.getUsuario(request);
        if (u == null) {
            return "redirect:/principal";
        }
        if (u.getUsername().equals("admin"))
            return "redirect:/admin";
        model.addAttribute("u", u);
        return "principalJuegos";
    }
}
