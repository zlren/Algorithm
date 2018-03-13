package lab.zlren.multithreading.waitandnotify;

/**
 * @author zlren
 * @date 2018-03-11
 */
public class Tmall {

    private int count;

    private final int MAX_COUNT = 10;

    public Tmall(int n) {
        this.count = n;
    }

    public synchronized void push() {
        while (count >= MAX_COUNT) {
            try {
                System.out.println("数量达到上限，生产者停止生产");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println("生产者生产，当前库存" + count);
        notifyAll();
    }

    public synchronized void take() {
        while (count <= 0) {
            try {
                System.out.println("库存为0，消费者等待");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println("消费者消费");
        notifyAll();
    }
}
