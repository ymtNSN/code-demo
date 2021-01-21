package com.example.demo.limiting;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限流-计数器
 * <p>
 * 劣势:
 * 假设在 00:01 时发生一个请求,在 00:01-00:58 之间不在发送请求,在 00:59 时发送剩下的所有请求 n-1 (n 为限流请求数量),在下一分钟的 00:01 发送 n 个请求,这样在 2 秒钟内请求到达了 2n - 1 个.
 * 设每分钟请求数量为 60 个,每秒可以处理 1 个请求,用户在 00:59 发送 60 个请求,在 01:00 发送 60 个请求 此时 2 秒钟有 120 个请求(每秒 60 个请求),远远大于了每秒钟处理数量的阈值
 * Created by @author ymtNSN on 2021/1/21
 */
public class Counter {
    /**
     * 最大访问数量
     */
    private final int limit = 10;
    /**
     * 访问时间差
     */
    private final long timeout = 1000;
    /**
     * 请求时间
     */
    private long time;
    /**
     * 当前计数器
     */
    private AtomicInteger reqCount = new AtomicInteger(0);

    public boolean limit() {
        long now = System.currentTimeMillis();
        if (now < time + timeout) {
            reqCount.addAndGet(1);
            return reqCount.get() <= limit;
        } else {
            time = now;
            reqCount = new AtomicInteger(0);
            return true;
        }
    }
}
