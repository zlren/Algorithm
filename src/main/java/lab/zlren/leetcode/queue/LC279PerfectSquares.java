package lab.zlren.leetcode.queue;

import java.util.Arrays;

/**
 * @author zlren
 * @date 2017-11-27
 */
public class LC279PerfectSquares {

    /**
     * 如果一个数 x 可以表示为一个任意数 a 加上一个平方数 bｘb，也就是 x = a + bｘb，
     * 那么能组成这个数 x 最少的平方数个数，就是能组成 a 最少的平方数个数加上 1（因为 b*b 已经是平方数了）。
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        // 将所有非平方数的结果置最大，保证之后比较的时候不被选中
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 将所有平方数的结果置1
        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        // 从小到大找任意数a
        for (int a = 0; a <= n; a++) {
            // 从小到大找平方数bｘb
            for (int b = 0; a + b * b <= n; b++) {
                // 因为a+b*b可能本身就是平方数，所以我们要取两个中较小的
                dp[a + b * b] = Math.min(dp[a] + 1, dp[a + b * b]);
            }
        }

        return dp[n];
    }
}
