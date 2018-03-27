package lab.zlren.leetcode.the8character;

/**
 * 全排列，包含可重复的元素
 *
 * @author zlren
 * @date 2018-03-27
 */
public class LC47PermutationsII {

    public static void main(String[] args) {
        System.out.println(new LC47PermutationsII().numDecodings("12"));
    }

    public int numDecodings(String s) {
        // write your code here
        // dp[n + 1]  s.length == n

        if (s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int a1 = Integer.parseInt(s.charAt(i - 2) + "" + s.charAt(i - 1));
            int a2 = Integer.parseInt(s.charAt(i - 1) + "");
            dp[i] = (a1 >= 1 && a1 <= 26 ? dp[i - 2] : 0) + (a2 >= 1 ? dp[i - 1] : 0);
        }
        return dp[dp.length - 1];
    }
}
