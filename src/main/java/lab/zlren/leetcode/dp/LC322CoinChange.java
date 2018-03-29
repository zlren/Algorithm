package lab.zlren.leetcode.dp;

import java.util.Arrays;

/**
 * 从所给面额硬币中选出最少的个数凑成指定值
 * 每个面额的硬币可以无限使用
 *
 * @author zlren
 * @date 2018-03-29
 */
public class LC322CoinChange {

    public static void main(String[] args) {
        System.out.println(new LC322CoinChange().coinChange(new int[]{2}, 3));
    }

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }

        // dp[i]表示，当需要凑的钱数为i时，所需要的最少的金币的数目
        int[] dp = new int[amount + 1];
        // dp[i]的最大值是用面额为1的硬币来凑，需要使用i个，当i为amount的时候需要amount个，所以我们初始值比这个大1就可以了
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j <= coins.length - 1; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return (dp[amount] > amount ? -1 : dp[amount]);
    }
}
