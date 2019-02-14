package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class FristController {

    @RequestMapping("/getString")
    public String getString(){
        return "zxl success";
    }
}
