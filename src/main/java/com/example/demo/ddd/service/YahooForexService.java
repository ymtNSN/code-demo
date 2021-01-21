package com.example.demo.ddd.service;

import java.math.BigDecimal;

/**
 * Created by @author ymtNSN on 2021/1/20
 */
public interface YahooForexService {

    BigDecimal getExchangeRate(Object value, Object value1);
}
