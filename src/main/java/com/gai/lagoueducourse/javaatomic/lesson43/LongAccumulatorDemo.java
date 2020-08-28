package com.gai.lagoueducourse.javaatomic.lesson43;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

public class LongAccumulatorDemo {

    public static void main(String[] args) throws InterruptedException {
        LongAccumulator longAccumulator = new LongAccumulator((x,y) -> {return x + y;}, 0);
        ExecutorService service = Executors.newFixedThreadPool(8);
        IntStream.range(1,10).forEach(i -> service.submit(
                () -> {longAccumulator.accumulate(i);}
        ));
        Thread.sleep(2000);
        System.out.println("使用LongAccumulator示例结果===>"+longAccumulator.get());
    }

}
