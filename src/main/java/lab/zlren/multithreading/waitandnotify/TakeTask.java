package lab.zlren.multithreading.waitandnotify;

/**
 * 消费者
 *
 * @author zlren
 * @date 2018-03-11
 */
public class TakeTask implements Runnable {

    private Tmall tmall;

    public TakeTask(Tmall tmall) {
        this.tmall = tmall;
    }

    @Override
    public void run() {
        while (true) {
            tmall.take();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
