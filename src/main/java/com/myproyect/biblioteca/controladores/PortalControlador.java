/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproyect.biblioteca.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sower
 */
//@RestController
//@RequestMapping("/")
//public class PortalControlador {
//    
//    @GetMapping("/home")
//    public String index(){
//        return "sss";
//    }
//}

@Controller
public class PortalControlador {

    @GetMapping("/")
    public String home() {
        return "holaMundo";
    }
}
