package com.gai.lagoueducourse.threadlocalexample.lesson44;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo5 {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

    public static ExecutorService service = Executors.newFixedThreadPool(16);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            final int finalI = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    String s = new ThreadLocalDemo5().showDate(finalI);
                    System.out.println(s);
                }
            });
            Thread.sleep(100);
        }
        service.shutdown();
        Thread.currentThread();
    }

    public String showDate(int seconds){
        Date date = new Date(1000 * seconds);
        return simpleDateFormat.format(date);
    }

}
