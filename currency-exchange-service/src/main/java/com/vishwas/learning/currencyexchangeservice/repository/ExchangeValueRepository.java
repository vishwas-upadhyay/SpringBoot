package com.vishwas.learning.currencyexchangeservice.repository;

import com.vishwas.learning.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends CrudRepository <ExchangeValue,Integer> {

//    query method
    public ExchangeValue findByFromAndTo(String from, String to);
}
