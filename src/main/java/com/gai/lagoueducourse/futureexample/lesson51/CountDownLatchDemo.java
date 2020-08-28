package com.gai.lagoueducourse.futureexample.lesson51;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    ExecutorService executorService = Executors.newFixedThreadPool(16);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        System.out.println(countDownLatchDemo.getPrices());
        countDownLatchDemo.executorService.shutdown();
    }

    private Set<Integer> getPrices() throws InterruptedException {
        Set<Integer> integers = Collections.synchronizedSet(new HashSet<Integer>());
        CountDownLatch countDownLatch = new CountDownLatch(3);
        executorService.submit(new PriceTask(123, integers, countDownLatch));
        executorService.submit(new PriceTask(456, integers, countDownLatch));
        executorService.submit(new PriceTask(780, integers, countDownLatch));
        countDownLatch.await(3, TimeUnit.SECONDS);
        return integers;
    }


    private class PriceTask implements Runnable{

        Integer priceId;
        Set<Integer> prices;
        CountDownLatch countDownLatch;
        public PriceTask(Integer priceId, Set<Integer> prices, CountDownLatch countDownLatch) {
            this.priceId = priceId;
            this.prices = prices;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            int price = 0;
            try {
                Thread.sleep((long)(Math.random() * 4000));
                price = (int)(Math.random() * 4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            prices.add(price);

        }
    }




}
