package lab.zlren.multithreading.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zlren
 * @date 2018-03-09
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        DemoService bean = context.getBean(DemoService.class);
        bean.a();
        bean.b();
    }
}
