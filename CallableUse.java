
/*
* 练习，使用callable，平时用的线程，只是执行，但不返回执行结果。
* callable会返回执行结果。
* */

import java.util.TreeMap;
import java.util.concurrent.*;

public class CallableUse {

    public static void main(String [] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();//创建线程池
        Future<Integer> result = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("subthread is running");
                int sum = 0;
                for (int i = 0;i < 10;++i){
                    sum += i;
                }
                return sum;
            }
        });
        //
        //executorService.invokeAll();
        //关闭线程池
        //Thread.sleep(1000);
        System.out.println("main thread is running");
        System.out.println("result = "+result.get());
        System.out.println("over");
        executorService.shutdown();

    }


}
