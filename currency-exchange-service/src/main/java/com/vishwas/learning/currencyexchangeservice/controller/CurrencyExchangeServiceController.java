package com.vishwas.learning.currencyexchangeservice.controller;

import com.vishwas.learning.currencyexchangeservice.model.ExchangeValue;
import com.vishwas.learning.currencyexchangeservice.repository.ExchangeValueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.function.Consumer;

@RestController
public class CurrencyExchangeServiceController {

    @Autowired
    ExchangeValueRepository exchangeValueRepository;

    @Autowired
    Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue exchangeValue (@PathVariable String from , @PathVariable String to){

        ExchangeValue exchangeValue= exchangeValueRepository.findByFromAndTo(from,to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;

    }
}
