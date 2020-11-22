package com.vishwas.springbootdependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;

@Component
public class ROMMemory {

    //@Autowired
   // @Qualifier("secondLevelCacheMemory")
    Memory memory;

    @Autowired
   // @Qualifier("secondLevelCacheMemory")
    //Constructor injection do not support qualifier annotation on constructor method
    //as constructor has multiple parameter therefore give @qualifier on each parameter
    public ROMMemory(@Qualifier("secondLevelCacheMemory") Memory memory) {
        this.memory = memory;
    }

    public void getMemory() {
         memory.getMemoryDetails();
    }
}
