package com.vishwas.springbootwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("hi")
    String sayHi(@RequestParam ("name") String nameStr, HttpSession session){
        System.out.println("Say hi method called");
        session.setAttribute("name", nameStr);
        return "home.jsp";
        /*Spring boot doesn't support the JSP because its mainly evolved for micro services
         * therefor to rander JSP page we need to user tomcat jasper dependency here.
         * this will convert jsp page to servlet.
         * Also spring boot consider src/java/main/webapp folder for all view pages
         * if you want configure any additional property that can be configured in application.properties file
         * */


    }

    @RequestMapping("hello")
    ModelAndView sayHello(@RequestParam ("name") String nameStr, HttpSession session){
        System.out.println("Say hello method called");
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",nameStr);
        mv.setViewName("home.jsp");
        return mv;
        /*Spring boot doesn't support the JSP because its mainly evolved for micro services
         * therefor to rander JSP page we need to user tomcat jasper dependency here.
         * this will convert jsp page to servlet.
         * Also spring boot consider src/java/main/webapp folder for all view pages
         * if you want configure any additional property that can be configured in application.properties file
         * */


    }
}
