package lab.zlren.multithreading.spring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author zlren
 * @date 2018-03-09
 */
@Component
public class DemoService {

    @Async
    public void a() {
        while (true) {
            System.out.println("aaa");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Async
    public void b() {
        while (true) {
            System.out.println("bbb");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
