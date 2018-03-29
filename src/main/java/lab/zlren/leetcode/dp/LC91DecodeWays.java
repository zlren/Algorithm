package lab.zlren.leetcode.dp;

/**
 * @author zlren
 * @date 2018-03-28
 */
public class LC91DecodeWays {

    public int numDecodings(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) - '0' > 0 ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {

            int a = s.charAt(i - 1) - '0';
            int b = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';

            dp[i] = (a > 0 ? dp[i - 1] : 0) + (b >= 10 && b <= 26 ? dp[i - 2] : 0);
        }

        return dp[s.length()];
    }
}
