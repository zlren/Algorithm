package lab.zlren.leetcode.test.extendstest.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zlren
 * @date 2018-02-07
 */
public class Main {

    public static void main(String[] args) {
        Parent p = new Children();
        Children c = new Children();
        p.exec(1, 2);
        c.exec(1, 2);
        List<Integer> integers = Arrays.asList(1, 2, 3);
    }
}
