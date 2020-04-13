package com.forezp.servicefeign.controller;

import com.forezp.servicefeign.service.IServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    private IServiceHi serviceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name){
        return serviceHi.sayHiFromClientOne(name);
    }
}
