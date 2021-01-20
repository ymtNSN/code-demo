package com.example.demo.design.strategy.trainfair.farecal;

import com.example.demo.design.strategy.trainfair.IFareRule;
import com.example.demo.design.strategy.trainfair.StationFareRule;

/**
 * Created by @author ymtNSN on 2020/7/2
 */
public class StationRuleFareCal implements IFareStrategy {

    @Override
    public float getFare(IFareRule ruleValues, float basicFare) {
        StationFareRule rule = (StationFareRule) ruleValues;
        if (rule == null || rule.stationDistance <= 0) {
            return 0;
        }
        if (rule.stationDistance < 6) {
            return basicFare;
        }
        return 0;
    }
}
