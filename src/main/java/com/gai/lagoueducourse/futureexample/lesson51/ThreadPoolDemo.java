package com.gai.lagoueducourse.futureexample.lesson51;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        System.out.println(threadPoolDemo.getPrices());
        threadPoolDemo.executorService.shutdown();
    }


    private Set<Integer> getPrices() throws InterruptedException {
        Set<Integer> integers = Collections.synchronizedSet(new HashSet<Integer>());
        executorService.submit(new PriceTask(123, integers));
        executorService.submit(new PriceTask(456, integers));
        executorService.submit(new PriceTask(789, integers));
//        总的等待时间3秒
        Thread.sleep(3000);
        return integers;
    }


    private class PriceTask implements Runnable{

        Integer priceId;
        Set<Integer> prices;

        public PriceTask(Integer priceId, Set<Integer> prices) {
            this.priceId = priceId;
            this.prices = prices;
        }

        @Override
        public void run() {
            int price = 0;
            try {
                Thread.sleep((long)(Math.random() * 4000) );
                price = (int)(Math.random() * 4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prices.add(price);
        }
    }
}
