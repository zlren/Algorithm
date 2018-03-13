package lab.zlren.multithreading.syn;

/**
 * @author zlren
 * @date 2018-03-10
 */
public class Syn {

    public static void main(String[] args) {
        Syn syn = new Syn();
        syn.a();
    }

    public synchronized void a() {
        System.out.println("aaa");
        b();
    }

    public synchronized void b() {
        System.out.println("bbb");
    }
}
