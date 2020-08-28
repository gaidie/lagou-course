package com.gai.lagoueducourse.futureexample.lesson50;

import java.util.ArrayList;
import java.util.concurrent.*;

public class FutureDemo1 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ArrayList<Future> futureArrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Future<String> future = null;
            if ( i < 2){
                future = service.submit(new SlowTask());
            }else {
                future  = service.submit(new FastTask());
            }
            futureArrayList.add(future);
        }

        for (int i = 0; i < futureArrayList.size(); i++) {
            Future<String> future = futureArrayList.get(i);
            try {
                String result = future.get();
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }

    static class SlowTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "执行慢任务。。。";
        }
    }

    static class FastTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "执行快任务。。。";
        }
    }
}
