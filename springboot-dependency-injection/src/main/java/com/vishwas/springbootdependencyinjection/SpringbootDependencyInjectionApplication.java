package com.vishwas.springbootdependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootDependencyInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(
				SpringbootDependencyInjectionApplication.class, args);

		Laptop laptop =context.getBean(Laptop.class); // prototype scope
		Laptop laptop1 =context.getBean(Laptop.class);
		HardDisk hardDisk = context.getBean(HardDisk.class); // singleton scope
		//Laptop laptop =new Laptop ();
		/*Dont try above line if you create object like this it will not be managed by spring bean container and
		* you will get NPE for dependent objects like Screen and HardDisk*/
		laptop.printAll();

		/*
		  Below is example of setter based dependency injection.
		* */

		RAMMemory ramMemory = context.getBean(RAMMemory.class);
		ramMemory.getMemory();

		//Constructor based dependency injection
		// which injection is best? Industry guideline suggest constructor injection is best
		// as it gives immutability (object once created than it can't change) to your object.
		// other injection has room for not initializing object fully or change it later.
		// more info : https://www.javacodegeeks.com/2019/02/field-setter-constructor-injection.html

		ROMMemory romMemory = context.getBean(ROMMemory.class);
		romMemory.getMemory();


	}

}
