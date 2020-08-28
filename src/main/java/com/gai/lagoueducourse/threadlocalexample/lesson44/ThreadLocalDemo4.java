package com.gai.lagoueducourse.threadlocalexample.lesson44;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo4 {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

    public static ExecutorService service = Executors.newFixedThreadPool(16);

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 1000; i++) {
//            final int finalI = i;
//            service.submit(new Thread( ()-> {
//                String showDate = new ThreadLocalDemo4().showDate(finalI);
//                System.out.println(showDate);
//            }));
//            Thread.sleep(100);
//        }
        for (int i = 0; i < 10000; i++) {
            final int finalI = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    String showDate = new ThreadLocalDemo4().showDate(finalI);
                    System.out.println(showDate);
                }
            });
            Thread.sleep(100);
        }
        service.shutdown();
    }

    public String showDate(int seconds) {
        Date date = new Date(seconds * 1000);
        return simpleDateFormat.format(date);
    }

}
