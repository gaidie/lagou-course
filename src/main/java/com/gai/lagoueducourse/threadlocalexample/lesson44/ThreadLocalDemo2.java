package com.gai.lagoueducourse.threadlocalexample.lesson44;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDemo2 {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            final int finli = i;
            new Thread(
                    () -> {
                        String showDate = new ThreadLocalDemo2().showDate(finli);
                        System.out.println(showDate);
                    }
            ).start();
            Thread.sleep(100);
        }
    }



    /**
     * 将秒格式化为时间输出
     * @param seconds
     * @return
     */
    public String showDate(int seconds){
        Date date = new Date(seconds * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        return simpleDateFormat.format(date);
    }

}
