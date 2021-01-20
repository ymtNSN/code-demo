package com.example.demo.design.factory;

/**
 * Created by @author ymtNSN on 2020/7/1
 */
public abstract class AbstractTradeFactory {

    public abstract Trader createAppTrader();

    public abstract Trader createStoreTrader();

    public abstract Trader createWishTrader();
}
