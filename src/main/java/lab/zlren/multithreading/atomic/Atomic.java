package lab.zlren.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zlren
 * @date 2018-03-10
 */
public class Atomic {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement());
    }
}
