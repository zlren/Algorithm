package lab.zlren.multithreading.waitandnotify;

/**
 * 生产者
 *
 * @author zlren
 * @date 2018-03-11
 */
public class PushTask implements Runnable {

    private Tmall tmall;

    public PushTask(Tmall tmall) {
        this.tmall = tmall;
    }

    @Override
    public void run() {
        while (true) {
            tmall.push();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
