package lab.zlren.multithreading.waitandnotify;

/**
 * @author zlren
 * @date 2018-03-11
 */
public class Main {

    public static void main(String[] args) {
        Tmall tmall = new Tmall(5);
        PushTask pushTask = new PushTask(tmall);
        TakeTask takeTask = new TakeTask(tmall);

        for (int i = 0; i < 5; i++) {
            new Thread(pushTask).start();
        }

        for (int i = 0; i < 7; i++) {
            new Thread(takeTask).start();
        }

    }
}
