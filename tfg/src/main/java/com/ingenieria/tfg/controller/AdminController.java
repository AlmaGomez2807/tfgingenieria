package com.ingenieria.tfg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ingenieria.tfg.entity.Coordinate;
import com.ingenieria.tfg.entity.Figures;
import com.ingenieria.tfg.entity.HConflicts;
import com.ingenieria.tfg.entity.Multitask;
import com.ingenieria.tfg.entity.RControl;
import com.ingenieria.tfg.entity.User;
import com.ingenieria.tfg.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    /*
     * Este controlador se usará para todas las funciones del administrador
     */
    @Autowired
    private UserService userService;

    @Autowired
    private CookieManager cookieManager;

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request, Model model) {
        User u = cookieManager.getUsuario(request);
        if(!u.getUsername().equals("admin"))
            return "redirect:/principalJuegos";
        model.addAttribute("listaUsuarios", userService.findAllUsers());
        model.addAttribute("u", u);
        return "admin";
    }

    @RequestMapping("/progresion/{usuario}")
    public String progresion(@PathVariable String usuario, Model model) throws JsonProcessingException {
        User u = userService.findByUsername(usuario);
        model.addAttribute("u", u);
        List<Integer> listaCoordinate = new ArrayList<>();
        List<Integer> listaAciertosCoordinate = new ArrayList<>();
        List<Integer> listaFallosCoordinate = new ArrayList<>();

        List<Integer> listaFigures = new ArrayList<>();
        List<Integer> listaAciertosFigures = new ArrayList<>();
        List<Integer> listaFallosFigures = new ArrayList<>();

        List<Integer> listaHConflicts = new ArrayList<>();
        List<Integer> listaAciertosHConflicts = new ArrayList<>();
        List<Integer> listaFallosHConflicts = new ArrayList<>();

        List<Integer> listaMultitask = new ArrayList<>();
        List<Integer> listaAciertosMultitask = new ArrayList<>();
        List<Integer> listaFallosMultitask = new ArrayList<>();

        List<Integer> listaRControl = new ArrayList<>();
        List<Integer> listaAciertosRControl = new ArrayList<>();
        List<Integer> listaFallosRControl = new ArrayList<>();

        for(Coordinate i: u.getCoordinate()){
            listaCoordinate.add(i.getPuntuacion());
            listaAciertosCoordinate.add(i.getAciertos());
            listaFallosCoordinate.add(i.getFallos());
        }

        for(Figures i: u.getFigures()){
            listaFigures.add(i.getPuntuacion());
            listaAciertosFigures.add(i.getAciertos());
            listaFallosFigures.add(i.getFallos());
        }
        for(HConflicts i: u.getHConflicts()){
            listaHConflicts.add(i.getPuntuacion());
            listaAciertosHConflicts.add(i.getAciertos());
            listaFallosHConflicts.add(i.getFallos());
        }
        for(Multitask i: u.getMultitask()){
            listaMultitask.add(i.getPuntuacion());
            listaAciertosMultitask.add(i.getAciertos());
            listaFallosMultitask.add(i.getFallos());
        }
        for(RControl i: u.getRControl()){
            listaRControl.add(i.getPuntuacion());
            listaAciertosRControl.add(i.getAciertos());
            listaFallosRControl.add(i.getFallos());
        }
        model.addAttribute("listaCoordinate", new ObjectMapper().writeValueAsString(listaCoordinate));
        model.addAttribute("listaAciertosCoordinate", new ObjectMapper().writeValueAsString(listaAciertosCoordinate));
        model.addAttribute("listaFallosCoordinate", new ObjectMapper().writeValueAsString(listaFallosCoordinate));

        model.addAttribute("listaFigures", new ObjectMapper().writeValueAsString(listaFigures));
        model.addAttribute("listaAciertosFigures", new ObjectMapper().writeValueAsString(listaAciertosFigures));
        model.addAttribute("listaFallosFigures", new ObjectMapper().writeValueAsString(listaFallosFigures));

        model.addAttribute("listaHConflicts", new ObjectMapper().writeValueAsString(listaHConflicts));
        model.addAttribute("listaAciertosHConflicts", new ObjectMapper().writeValueAsString(listaAciertosHConflicts));
        model.addAttribute("listaFallosHConflicts", new ObjectMapper().writeValueAsString(listaFallosHConflicts));

        model.addAttribute("listaMultitask", new ObjectMapper().writeValueAsString(listaMultitask));
        model.addAttribute("listaAciertosMultitask", new ObjectMapper().writeValueAsString(listaAciertosMultitask));
        model.addAttribute("listaFallosMultitask", new ObjectMapper().writeValueAsString(listaFallosMultitask));

        model.addAttribute("listaRControl", new ObjectMapper().writeValueAsString(listaRControl));
        model.addAttribute("listaAciertosRControl", new ObjectMapper().writeValueAsString(listaAciertosRControl));
        model.addAttribute("listaFallosRControl", new ObjectMapper().writeValueAsString(listaFallosRControl));

        return "progresion";
    }
}
