package com.vishwas.springbootdependencyinjection;

import org.springframework.stereotype.Component;

/*
As long as there is only a single implementation of the interface
and that implementation is annotated with @Component with Spring's
component scan enabled, Spring framework can find out the (interface,
implementation) pair. If component scan is not enabled, then you have
to define the bean explicitly in your application-config.xml
(or equivalent spring configuration file).


Once you have more than one implementation,
then you need to qualify each of them and during auto-wiring,
you would need to use the @Qualifier annotation to inject the
right implementation, along with @Autowired annotation.

*/

@Component(value = "secondLevelCacheMemory")
public class SecondLevelCacheMemoryImpl implements Memory {
    @Override
    public void getMemoryDetails() {
        System.out.println("Available second level cache is 300 MB");
    }
}
