package lab.zlren.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 *
 * @author zlren
 * @date 2018-03-09
 */
public class ExecutorDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(() -> System.out.println("哈哈"));
        service.shutdown();
    }
}
