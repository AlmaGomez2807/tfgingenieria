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

    @RequestMapping("/instruccionesCoord")
    public String greeting8() {
        return "instruccionesCoord";
    }

    @RequestMapping("/instruccionesHC")
    public String greeting9() {
        return "instruccionesHC";
    }

    @RequestMapping("/instruccionesRC")
    public String greeting10() {
        return "instruccionesRC";
    }

    @RequestMapping("/instruccionesMT")
    public String greeting11() {
        return "instruccionesMT";
    }

    @RequestMapping("/instruccionesF")
    public String greeting12() {
        return "instruccionesF";
    }
}
