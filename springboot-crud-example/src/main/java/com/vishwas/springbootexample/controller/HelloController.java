package com.vishwas.springbootexample.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping ("/hi")
	public String sayHello() {

		return "Hi from Spring Boot";
	}

	@GetMapping("/hilocal")
	public String sayHiLocalLang (@RequestHeader(value = "Accept-Language",required = false) Locale locale){
		System.out.println("Locale "+ locale.getDisplayName());
		 return messageSource.getMessage("good.morning.message", null,locale );
	}
}
