package com.forezp.servicefeign.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceHiHystric implements IServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry" + name;
    }
}
