package com.example.demo.design.strategy.trainfair.farecal;

import com.example.demo.design.strategy.trainfair.IFareRule;

/**
 * Created by @author ymtNSN on 2020/7/2
 */
public interface IFareStrategy {
    float getFare(IFareRule ruleValues, float basicFare);
}
