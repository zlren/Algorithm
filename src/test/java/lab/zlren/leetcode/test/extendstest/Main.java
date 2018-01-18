package lab.zlren.leetcode.test.extendstest;

/**
 * @author zlren
 * @date 2018-01-08
 */
public class Main {

    public static void main(String[] args) {
        // B b = new B(1);

        // Integer a = 1000, b = 1000;
        // System.out.println(a == b);//1
        // Integer c = 100, d = 100;
        // System.out.println(c == d);//2

        Person person = new Person("zlren", 88);
        fuc(person);
        System.out.println(person.getName());


    }

    public static void fuc(Person person) {
        person.setName("haha");
    }

}
