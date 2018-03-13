package lab.zlren.others;

/**
 * @author zlren
 * @date 2018-03-05
 */
public class VolatileTest extends Thread {

    private volatile boolean running = true;
    private int i = 0;

    @Override
    public void run() {
        while (running) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.start();
        Thread.sleep(1000);
        System.out.println(volatileTest.i);

        volatileTest.running = false;
        Thread.sleep(1000);
        System.out.println(volatileTest.i);
    }
}
