package com.vishwas.learning.limitsservice.controller;

import com.vishwas.learning.limitsservice.beans.LimitConfiguration;
import com.vishwas.learning.limitsservice.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    @Value("${limits-service-lower-limit}")
    String lowerLimit;

    @Value("${limits-service-upper-limit}")
    String upperLimit;

    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration getLimit(){
       // return new LimitConfiguration(Integer.parseInt(lowerLimit),Integer.parseInt(upperLimit));
        return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }

    @GetMapping("/hi")
    public String sayHi(){
        return "Hello";
    }
}
