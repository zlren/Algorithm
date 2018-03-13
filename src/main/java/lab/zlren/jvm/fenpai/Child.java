package lab.zlren.jvm.fenpai;

/**
 * @author zlren
 * @date 2018-02-27
 */
public class Child extends Father {
    @Override
    public void doSomething(Eat arg) {
        System.out.println("儿子在吃饭");
    }

    @Override
    public void doSomething(Drink arg) {
        System.out.println("儿子在喝水");
    }
}
