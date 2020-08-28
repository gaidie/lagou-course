package com.gai.lagoueducourse.threadlocalexample.lesson44;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDemo1 {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            String date1 = new ThreadLocalDemo1().showDate(1);
            System.out.println(date1);
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            String date2 = new ThreadLocalDemo1().showDate(2);
            System.out.println(date2);
        }).start();
    }

    public String showDate(int seconds){
        Date date = new Date(seconds * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        return sdf.format(date);
    }

}
