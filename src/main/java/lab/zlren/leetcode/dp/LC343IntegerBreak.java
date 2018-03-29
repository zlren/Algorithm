package lab.zlren.leetcode.dp;

/**
 * @author zlren
 * @date 2018-03-28
 */
public class LC343IntegerBreak {

    public static void main(String[] args) {
        System.out.println(new LC343IntegerBreak().integerBreak(10));
    }

    public int integerBreak(int n) {
        // f(n)的值为所有下面的可能中最大的那个
        // f(n-1) * 1
        // f(n-2) * 2
        // f(n-k) * k
        // 其实不是这样的，f(n)表示把n拆分成了至少两份，所以当拆出来一个k的时候，考虑f(n-k)的同时还要考虑n-k本身，因为已经拆出k来了

        int[] dp = new int[n + 1];

        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(Math.max(dp[i], j * dp[i - j]), j * (i - j));
            }
        }
        return dp[n];
    }
}
