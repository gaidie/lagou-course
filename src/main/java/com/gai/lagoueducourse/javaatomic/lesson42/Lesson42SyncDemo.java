package com.gai.lagoueducourse.javaatomic.lesson42;

public class Lesson42SyncDemo implements Runnable {

    static int value = 0;

    public static void main(String[] args) throws InterruptedException {
        Lesson42SyncDemo lesson42SyncDemo = new Lesson42SyncDemo();
        Thread thread1 = new Thread(lesson42SyncDemo);
        Thread thread2 = new Thread(lesson42SyncDemo);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("使用sync的结果：===》"+value);
    }


    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            synchronized (this){
                value++;
            }
        }
    }
}
