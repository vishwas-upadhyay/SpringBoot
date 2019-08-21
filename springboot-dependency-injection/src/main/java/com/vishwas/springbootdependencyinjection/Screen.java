package com.vishwas.springbootdependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class Screen {

    private String name = "Samsung";

    public Screen() {
        System.out.println("Screen object created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
