package com.custom.eaii.training.intellegenceInformation.IntelInfo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/informant")
public class InfoControler {

    @GetMapping
    public String info(){
        return "hello from informant";
    }
}
