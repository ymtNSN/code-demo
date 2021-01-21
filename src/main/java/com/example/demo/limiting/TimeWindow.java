package com.example.demo.limiting;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.IntStream;

/**
 * 滑动窗口
 * Created by @author ymtNSN on 2021/1/21
 */
public class TimeWindow {

    private ConcurrentLinkedQueue<Long> queue = new ConcurrentLinkedQueue<>();
    /**
     * 间隔秒速
     */
    private int seconds;
    /**
     * 最大限流
     */
    private int max;

    public TimeWindow(int seconds, int max) {
        this.seconds = seconds;
        this.max = max;

        /**
         * 永续线程执行清理queue 任务
         */
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(seconds * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clean();
            }
        }).start();
    }

    public static void main(String[] args) {
        final TimeWindow timeWindow = new TimeWindow(1, 10);

        IntStream.range(0, 3).forEach((i) -> {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(new Random().nextInt(20) * 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    timeWindow.take();
                }
            }).start();
        });
    }

    /**
     * 获取令牌，并且添加时间
     */
    private void take() {
        long start = System.currentTimeMillis();

        int size = sizeOfValid();
        if (size > max) {
            System.out.println("超限");
        }
        synchronized (queue) {
            if (sizeOfValid() > max) {
                System.out.println("超限");
                System.out.println("queue中有 " + queue.size() + " 最大数量 " + max);
            }
            this.queue.offer(System.currentTimeMillis());
        }
        System.out.println("queue中有 " + queue.size() + " 最大数量 " + max);
    }

    private int sizeOfValid() {
        Iterator<Long> iterator = queue.iterator();
        long ms = System.currentTimeMillis() - seconds;
        int count = 0;
        while (iterator.hasNext()) {
            long t = iterator.next();
            if (t > ms) {
                count++;
            }
        }
        return count;
    }

    private void clean() {
        long c = System.currentTimeMillis() - seconds;

        Long tl;
        while ((tl = queue.peek()) != null && tl < c) {
            System.out.println("清理数据");
            queue.poll();
        }
    }


}
