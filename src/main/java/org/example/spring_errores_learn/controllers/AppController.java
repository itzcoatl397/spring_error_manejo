package org.example.spring_errores_learn.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    public  String index() {

        int  value = 100/0;
        return "index";
    }
}
