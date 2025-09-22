package com.ingenieria.tfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/juegos")
public class GamesController {

    @Autowired
    private CookieManager cookieManager;

    @RequestMapping("/coordinate")
    public String coordinate(HttpServletRequest request, Model model) {
        model.addAttribute("u", cookieManager.getUsuario(request));
        return "coordinate";
    }

    @RequestMapping("/headingconflicts")
    public String headingconflicts(HttpServletRequest request, Model model) {
        model.addAttribute("u", cookieManager.getUsuario(request));
        return "headingconflicts";
    }

    @RequestMapping("/radarcontrol")
    public String radarcontrol(HttpServletRequest request, Model model) {
        model.addAttribute("u", cookieManager.getUsuario(request));
        return "radarcontrol";
    }

    @RequestMapping("/multitask")
    public String multitask(HttpServletRequest request, Model model) {
        model.addAttribute("u", cookieManager.getUsuario(request));
        return "multitask";
    }

    @RequestMapping("/figures")
    public String figures(HttpServletRequest request, Model model) {
        model.addAttribute("u", cookieManager.getUsuario(request));
        return "figures";
    }

    @RequestMapping("/instruccionesCoord")
    public String instruccionesCoord(HttpServletRequest request, Model model) {
        model.addAttribute("u", cookieManager.getUsuario(request));
        return "instruccionesCoord";
    }

    @RequestMapping("/instruccionesHC")
    public String instruccionesHC(HttpServletRequest request, Model model) {
        model.addAttribute("u", cookieManager.getUsuario(request));
        return "instruccionesHC";
    }

    @RequestMapping("/instruccionesRC")
    public String instruccionesRC(HttpServletRequest request, Model model) {
        model.addAttribute("u", cookieManager.getUsuario(request));
        return "instruccionesRC";
    }

    @RequestMapping("/instruccionesMT")
    public String instruccionesMT(HttpServletRequest request, Model model) {
        model.addAttribute("u", cookieManager.getUsuario(request));
        return "instruccionesMT";
    }

    @RequestMapping("/instruccionesF")
    public String instruccionesF(HttpServletRequest request, Model model) {
        model.addAttribute("u", cookieManager.getUsuario(request));
        return "instruccionesF";
    }
}