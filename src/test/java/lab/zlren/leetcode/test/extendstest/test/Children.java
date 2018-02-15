package lab.zlren.leetcode.test.extendstest.test;

/**
 * @author zlren
 * @date 2018-02-07
 */
public class Children extends Parent {

    @Override
    public int exec(int a, int b) {
        System.out.println("children");
        return a + b;
    }
}
