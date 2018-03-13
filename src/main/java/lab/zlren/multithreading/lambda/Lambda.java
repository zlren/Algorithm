package lab.zlren.multithreading.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author zlren
 * @date 2018-03-09
 */
public class Lambda {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println(list.parallelStream().mapToInt(a -> a).sum());
    }

}
