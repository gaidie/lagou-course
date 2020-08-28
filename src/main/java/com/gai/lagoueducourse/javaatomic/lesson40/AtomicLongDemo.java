package com.gai.lagoueducourse.javaatomic.lesson40;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicLong counter = new AtomicLong(0);
        ExecutorService service = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 100; i++) {
            service.submit(new DemoTask(counter));
        }
        Thread.sleep(2000);
        System.out.println(counter.get());
    }

    static class DemoTask implements Runnable{
        private AtomicLong counter;

        public DemoTask(AtomicLong counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.incrementAndGet();
        }
    }



}
