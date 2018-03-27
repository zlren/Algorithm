package lab.zlren.leetcode.str;

/**
 * 最长公共子串
 *
 * @author zlren
 * @date 2018-03-16
 */
public class LCS {

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("1357", "12345678"));
    }

    private static int longestCommonSubstring(String s1, String s2) {

        int len1 = s1.length(), len2 = s2.length();
        int[][] nums = new int[len1 + 1][len2 + 1];

        // maxLen是最长公共子串的大小，subEndIndex是这个子串在s1字符串中结束的位置
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {

                if (i == 0 || j == 0) {
                    nums[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    nums[i][j] = nums[i - 1][j - 1] + 1;
                } else {
                    nums[i][j] = 0;
                }

                if (nums[i][j] > maxLen) {
                    maxLen = nums[i][j];
                }
            }
        }

        return maxLen;
    }

    private static int longestCommonSubseq(String s1, String s2) {

        int len1 = s1.length(), len2 = s2.length();
        // 都初始化为0
        int[][] nums = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    nums[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    nums[i][j] = nums[i - 1][j - 1] + 1;
                } else {
                    nums[i][j] = Math.max(nums[i - 1][j], nums[i][j - 1]);
                }
            }
        }

        return nums[len1][len2];
    }
}
