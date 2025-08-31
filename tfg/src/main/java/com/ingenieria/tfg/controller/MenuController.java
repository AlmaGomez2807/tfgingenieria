package com.ingenieria.tfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ingenieria.tfg.entity.User;
import com.ingenieria.tfg.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MenuController {
    @Autowired
    private UserService userService;

    @Autowired
    private CookieManager cookieManager;
    
    @RequestMapping("/perfil")
    public String perfil(HttpServletRequest request, Model model) {
        User u = cookieManager.getUsuario(request);
        model.addAttribute("u", u);
        model.addAttribute("coordinate", u.getMaxCoordinate());
        model.addAttribute("hconflicts", u.getMaxHConflicts());
        model.addAttribute("rcontrol", u.getMaxRControl());
        model.addAttribute("multitask", u.getMaxMultitask());
        model.addAttribute("figures", u.getMaxFigures());
        return "perfil";
    }

    @RequestMapping("/ranking")
    public String ranking(HttpServletRequest request, Model model) {
        User u = cookieManager.getUsuario(request);
        model.addAttribute("u", u);
        model.addAttribute("listaUsuarios", userService.findAllUsers());
        return "ranking";
    }
}
