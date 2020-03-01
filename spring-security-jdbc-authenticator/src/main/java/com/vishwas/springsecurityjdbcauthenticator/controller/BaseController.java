package com.vishwas.springsecurityjdbcauthenticator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/spring-security")
public class BaseController {

    @GetMapping("/")
    public String test() {
        return ("<h1> Welcome </h1>");

    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1> Welcome  Admin</h1>");

    }

    @GetMapping("/user")
    public String user() {
        return ("<h1> Welcome User</h1>");

    }
}
