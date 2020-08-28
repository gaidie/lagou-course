package com.gai.lagoueducourse.threadlocalexample.lesson44;

import java.text.SimpleDateFormat;

public class ThreadSafeFormat {

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("mm:ss");
        }
    };

}
