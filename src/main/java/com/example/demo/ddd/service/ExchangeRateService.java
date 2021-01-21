package com.example.demo.ddd.service;

import com.example.demo.ddd.DP.Currency;
import com.example.demo.ddd.DP.ExchangeRate;

public interface ExchangeRateService {

    ExchangeRate getExchangeRate(Currency source, Currency target);
}