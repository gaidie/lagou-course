package com.gai.lagoueducourse.javaatomic.lesson42;

import java.util.concurrent.atomic.AtomicLong;

public class Lesson42AtomicDemo implements Runnable {

    static AtomicLong value = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {
        Lesson42AtomicDemo lesson42AtomicDemo = new Lesson42AtomicDemo();
        Thread thread1 = new Thread(lesson42AtomicDemo);
        Thread thread2 = new Thread(lesson42AtomicDemo);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("result + ====》"+value.get());

    }


    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            value.incrementAndGet();
        }
    }
}
