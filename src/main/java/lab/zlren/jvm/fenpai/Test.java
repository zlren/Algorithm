package lab.zlren.jvm.fenpai;

/**
 * @author zlren
 * @date 2018-02-27
 */
public class Test {

    public static void main(String[] args) {
        Father father = new Father();
        Father child = new Child();
        father.doSomething(new Eat());
        child.doSomething(new Drink());
    }
}
