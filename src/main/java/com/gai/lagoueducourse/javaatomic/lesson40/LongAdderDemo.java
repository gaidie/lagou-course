package com.gai.lagoueducourse.javaatomic.lesson40;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo {

    public static void main(String[] args) throws InterruptedException {
        LongAdder counter = new LongAdder();
        ExecutorService service = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 100; i++) {
            service.submit(new LongAdderDemoTask(counter));
        }
        System.out.println("查看具体结果："+counter.longValue());
        Thread.sleep(2000);
        System.out.println("查看具体结果A："+counter.sum());
    }

    static class LongAdderDemoTask implements Runnable{
        LongAdder counter;

        public LongAdderDemoTask(LongAdder counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }

}
