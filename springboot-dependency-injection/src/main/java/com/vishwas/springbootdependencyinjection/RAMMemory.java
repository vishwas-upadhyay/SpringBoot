package com.vishwas.springbootdependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RAMMemory {

    Memory memory;

    @Autowired
    @Qualifier("memory")
    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void getMemory(){
         memory.getMemoryDetails();
    }
}
