package lab.zlren.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zlren
 * @date 2018-03-09
 */
public class Demo implements Callable<Integer> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo demo = new Demo();
        FutureTask<Integer> futureTask = new FutureTask<>(demo);
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("主线程先做点别的");
        System.out.println("执行结果：" + futureTask.get());

    }

    @Override
    public Integer call() throws Exception {
        System.out.println("正在计算..");
        Thread.sleep(1000);
        return 1;
    }
}
