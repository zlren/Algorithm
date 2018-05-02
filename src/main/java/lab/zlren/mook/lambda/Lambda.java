package lab.zlren.mook.lambda;

import java.util.OptionalInt;
import java.util.Random;

/**
 * @author zlren
 * @date 2018-04-24
 */
public class Lambda {

    public static void main(String[] args) {
        OptionalInt first = new Random().ints().findFirst();
        System.out.println(first.orElse(-1));
    }

}
