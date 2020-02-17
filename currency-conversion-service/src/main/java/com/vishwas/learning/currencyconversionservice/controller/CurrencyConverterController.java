package com.vishwas.learning.currencyconversionservice.controller;

import com.vishwas.learning.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConverterController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion currencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        Map<String ,String> objectMap = new HashMap<>();
        objectMap.put("from",from);
        objectMap.put("to",to);
//        RestTemplate class has been used for spring microservices interactions
//        getForEntity will convert response in designated class object
        ResponseEntity<CurrencyConversion> responseEntity
                = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}"
                                                                ,CurrencyConversion.class,objectMap);

        CurrencyConversion currencyConversion =responseEntity.getBody();
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiplier()));

        return currencyConversion;



    }
}
