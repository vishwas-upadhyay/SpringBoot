package com.vishwas.springbootdependencyinjection;

import org.springframework.stereotype.Component;

@Component ("hard1") // By default bean will be created with name as hardDisk and Autowired by Type match.
// If you want you can also give name to bean then we have to use @Qualifier with Autowired.
// But still by type is also working fine though we use name of bean and @Qualifier.

//TODO: How we will create beans with constructor paramerter ?
// Ans : by setter getter dependency injection
public class HardDisk {
    private  String name="HDDR";

    public HardDisk() {
        System.out.println("HardDisk obj created");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }




}
