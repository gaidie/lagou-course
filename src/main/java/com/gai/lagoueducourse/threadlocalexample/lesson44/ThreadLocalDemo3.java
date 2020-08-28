package com.gai.lagoueducourse.threadlocalexample.lesson44;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo3 {

    static final ExecutorService executorService = Executors.newFixedThreadPool(16);


    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 1000; i++) {
//            final int finalI = i;
//            executorService.submit(
//                    new Thread(() ->{
//                        String s = new ThreadLocalDemo3().showDate(finalI);
//                        System.out.println(s);
//                    })
//            );
//            Thread.sleep(100);
//        }
        for (int i = 0; i < 1000; i++) {
            final int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String showDate = new ThreadLocalDemo3().showDate(finalI);
                    System.out.println(showDate);
                }
            });
            Thread.sleep(100);
        }

        executorService.shutdown();
    }


    public String showDate(int seconds){
        Date date = new Date(seconds * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        return simpleDateFormat.format(date);
    }

}
