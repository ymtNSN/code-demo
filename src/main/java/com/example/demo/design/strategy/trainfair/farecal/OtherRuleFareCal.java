package com.example.demo.design.strategy.trainfair.farecal;

import com.example.demo.design.strategy.trainfair.IFareRule;
import com.example.demo.design.strategy.trainfair.OtherFareRule;

/**
 * Created by @author ymtNSN on 2020/7/2
 */
public class OtherRuleFareCal implements IFareStrategy {

    @Override
    public float getFare(IFareRule ruleValues, float basicFare) {
        OtherFareRule rule = (OtherFareRule) ruleValues;
        if (rule == null) {
            return basicFare;
        }

        return basicFare + rule.getAdditionalFare();
    }
}
