package lab.zlren.others;

/**
 * @author zlren
 * @date 2018-03-05
 */
public class Singleton {

    private static class Instance {
        private static Singleton instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return Instance.instance;
    }
}
