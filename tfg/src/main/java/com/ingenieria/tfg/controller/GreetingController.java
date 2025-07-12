package com.ingenieria.tfg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

    @RequestMapping("/")
    public String greeting() {
        return "principal";
    }

    @RequestMapping("/principalJuegos")
    public String greeting2() {
        return "principalJuegos";
    }

    @RequestMapping("/coordinate")
    public String greeting3() {
        return "coordinate";
    }

    @RequestMapping("/headingconflicts")
    public String greeting4() {
        return "headingconflicts";
    }

    @RequestMapping("/radarcontrol")
    public String greeting5() {
        return "radarcontrol";
    }

    @RequestMapping("/multitask")
    public String greeting6() {
        return "multitask";
    }

    @RequestMapping("/figures")
    public String greeting7() {
        return "figures";
    }
}
