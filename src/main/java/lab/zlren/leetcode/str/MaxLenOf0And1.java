package lab.zlren.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包含0和1的字符串，求最长的子串，使得其中包含的0和1的个数相等
 *
 * @author zlren
 * @date 2018-03-31
 */
public class MaxLenOf0And1 {

    public static void main(String[] args) {
        System.out.println(new MaxLenOf0And1().solution("1000010111000001"));
    }

    /**
     * 普通n方解法，使用一个变量，遇到1加，遇到0减
     *
     * @param str
     * @return
     */
    private int solution(String str) {
        int max = -1, value;
        for (int i = 0; i < str.length(); i++) {
            value = 0;
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    value--;
                } else {
                    value++;
                }
                if (value == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    /**
     * On解法
     *
     * @param str
     * @return
     */
    private int solution2(String str) {

        int len = str.length();

        // 将str转成数组，1还是1，0转为-1
        int[] strs = new int[len];
        for (int i = 0; i < len; i++) {
            strs[i] = str.charAt(i) == '1' ? 1 : -1;
        }

        // 求前缀和
        // 问题的模型转换为找到i和j，满足preSum[i]与preSum[j]相等，且|i-j|最大
        int[] preSum = new int[len];
        preSum[0] = strs[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i - 1] + strs[i];
        }

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            if (map.containsKey(preSum[i])) {
                max = Math.max(max, i - map.get(preSum[i]));
            } else {
                map.put(preSum[i], i);
            }
        }

        return max;
    }
}
