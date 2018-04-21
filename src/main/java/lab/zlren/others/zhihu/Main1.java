package lab.zlren.others.zhihu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zlren
 * @date 2018-04-10
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int x = Math.min(a, b);
        int y = Math.max(a, b);

        boolean[] flag = new boolean[106];
        Arrays.fill(flag, true);
        for (int i = 2; i <= y; i++) {
            for (int j = 2; i * j <= y; j++) {
                flag[i * j] = false;
            }
        }

        int count = 0;
        for (int i = x; i <= y; i++) {
            if (flag[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

}
