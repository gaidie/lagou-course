package com.gai.lagoueducourse.futureexample.lesson51;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureDemo {

    private final CompletableFuture<Void> completableFuture = new CompletableFuture<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
        System.out.println(completableFutureDemo.getPrices());
    }

    private Set<Integer> getPrices() {
        Set<Integer> integers = Collections.synchronizedSet(new HashSet<Integer>());
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new PriceTask(123, integers));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new PriceTask(456, integers));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new PriceTask(789, integers));

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(task1, task2, task3);
        try {
            voidCompletableFuture.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return integers;
    }

    private class PriceTask implements Runnable{

        Integer priceId;
        Set<Integer> integers;

        public PriceTask(Integer priceId, Set<Integer> integers) {
            this.priceId = priceId;
            this.integers = integers;
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
            integers.add(price);
        }
    }

}
