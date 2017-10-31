package lab.zlren.leetcode.union;

import java.util.Random;

/**
 * @author zlren
 * @date 17/10/31
 */
public class UFTest {
    public static void main(String[] args) {

        int n = 100000;

        UnionFind2 unionFind = new UnionFind2(n);

        long startTime = System.currentTimeMillis();

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            unionFind.unionElements(a, b);
        }

        for (int i = 0; i < n; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            unionFind.isConnected(a, b);
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

}
