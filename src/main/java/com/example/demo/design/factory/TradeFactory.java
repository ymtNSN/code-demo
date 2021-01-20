package com.example.demo.design.factory;

/**
 * Created by @author ymtNSN on 2020/7/1
 */
public class TradeFactory extends AbstractTradeFactory {

    @Override
    public Trader createAppTrader() {
        return new AppTrader();
    }

    @Override
    public Trader createStoreTrader() {
        return new StoreTrader();
    }

    @Override
    public Trader createWishTrader() {
        return new WishTrader();
    }
}
