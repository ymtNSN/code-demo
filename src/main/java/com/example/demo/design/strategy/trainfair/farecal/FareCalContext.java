package com.example.demo.design.strategy.trainfair.farecal;

import com.example.demo.design.strategy.trainfair.IFareRule;

/**
 * Created by @author ymtNSN on 2020/7/2
 */
public class FareCalContext {

    private IFareStrategy fareStrategy;

    public FareCalContext(IFareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public float getFareDetails(IFareRule ruleValues, float basicFare) {
        return fareStrategy.getFare(ruleValues, basicFare);
    }
}
