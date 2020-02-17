package com.vishwas.learning.currencyexchangeservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ExchangeValue {

    @Id
    Integer id ;

    @Column(name = "currency_from")
    String from;

    @Column(name = "currency_to")
    String to;

    BigDecimal conversionMultiplier;

    int port;

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }



    public ExchangeValue() {
    }

    public ExchangeValue(String from, String to, BigDecimal conversionMultiplier, int port) {
        this.from = from;
        this.to = to;
        this.conversionMultiplier = conversionMultiplier;
        this.port=port;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiplier() {
        return conversionMultiplier;
    }

    public void setConversionMultiplier(BigDecimal conversionMultiplier) {
        this.conversionMultiplier = conversionMultiplier;
    }

}
