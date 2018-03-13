package lab.zlren.others;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zlren
 * @date 2018-03-07
 */
public class CallableAndFuture {

    public static void main(String[] args) {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() {
                return new Random().nextInt(100);
            }
        };

        FutureTask<Integer> future = new FutureTask<>(callable);
        new Thread(future).start();

        try {
            Thread.sleep(5000);
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
