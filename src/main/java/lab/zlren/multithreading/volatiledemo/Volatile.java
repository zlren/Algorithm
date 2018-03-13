package lab.zlren.multithreading.volatiledemo;

/**
 * @author zlren
 * @date 2018-03-10
 */
public class Volatile {

    public volatile boolean run = false;

    public static void main(String[] args) {
        Volatile v = new Volatile();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("执行了第" + i + "次");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            v.run = true;
        }).start();

        new Thread(() -> {
            while (!v.run) {
                // 一直等待
            }

            System.out.println("我开始执行");
        }).start();

    }
}
