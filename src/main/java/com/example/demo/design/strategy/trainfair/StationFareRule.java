package com.example.demo.design.strategy.trainfair;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by @author ymtNSN on 2020/7/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StationFareRule extends IFareRule {

    public int stationsCounts;

    public float incrementalPrice;

    public float stationDistance;

}
