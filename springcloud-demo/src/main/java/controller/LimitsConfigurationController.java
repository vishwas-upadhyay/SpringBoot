package controller;

import bean.LimitConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @GetMapping("/limits")
    public LimitConfiguration getLimitFromConfiguration (){
        System.out.println("inside limits");
        return new LimitConfiguration(9,99);

    }

    @GetMapping("/hi")
    public void sayHi(){
        System.out.println("Hello");
    }


}
