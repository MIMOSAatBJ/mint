package com.gto.api.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {


    @RequestMapping("/ping")
    public Object pong() {
        System.out.println("pong");
        return "pong";
    }
}
