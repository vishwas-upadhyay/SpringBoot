package com.vishwas.springbootdependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Component will inform spring container to create object when application context initialization.
@Scope(value="prototype")
// when you hit context.getbean() then your object will be created not at application context initialization time.
// As many time you call context.getbean() that many object will be created.
// By default scope value is singleton

public class Laptop {
    @Autowired
    Screen screen;

    @Autowired
    HardDisk hard;

    @Autowired
    @Qualifier("hard1")
    HardDisk hardDisk;

    public Laptop() {
        System.out.println("Laptop Object created");
    }

    public void printAll(){
        System.out.println("laptop is availble with screen "+screen.getName()
               + " Hard disk is "+hardDisk.getName());
    }

}
