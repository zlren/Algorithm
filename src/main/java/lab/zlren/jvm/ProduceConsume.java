package lab.zlren.jvm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zlren
 * @date 2018-03-31
 */
public class ProduceConsume {

    private int max = 16;
    private Queue<Object> queue = new LinkedList<>();

    public void produce(int size) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() + size > max) {
                queue.wait();
            }
            for (int i = 0; i < size; i++) {
                queue.offer(new Object());
            }
            queue.notifyAll();
        }
    }

    public void consume(int size) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() - size < 0) {
                queue.wait();
            }
            for (int i = 0; i < size; i++) {
                queue.poll();
            }
            queue.notifyAll();
        }
    }
}
