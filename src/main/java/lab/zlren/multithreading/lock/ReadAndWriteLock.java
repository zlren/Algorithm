package lab.zlren.multithreading.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zlren
 * @date 2018-03-10
 */
public class ReadAndWriteLock {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        readWriteLock.readLock().lock();
        readWriteLock.writeLock().lock();

    }
}
