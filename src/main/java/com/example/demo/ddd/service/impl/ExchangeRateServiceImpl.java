package com.example.demo.ddd.service.impl;

import com.example.demo.ddd.DP.Currency;
import com.example.demo.ddd.DP.ExchangeRate;
import com.example.demo.ddd.service.ExchangeRateService;
import com.example.demo.ddd.service.YahooForexService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private YahooForexService yahooForexService;

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        if (source.equals(target)) {
            return new ExchangeRate(BigDecimal.ONE, source, target);
        }
        BigDecimal forex = yahooForexService.getExchangeRate(source.getValue(), target.getValue());
        return new ExchangeRate(forex, source, target);
    }

}