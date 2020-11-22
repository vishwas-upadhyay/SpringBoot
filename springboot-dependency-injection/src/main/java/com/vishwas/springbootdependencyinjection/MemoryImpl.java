package com.vishwas.springbootdependencyinjection;

import org.springframework.stereotype.Component;

@Component(value="memory")
public class MemoryImpl implements  Memory {


    @Override
    public void getMemoryDetails() {
        System.out.println("Available memory is 200 GB" );
    }
}
