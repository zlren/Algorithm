package lab.zlren.leetcode.array;

import java.util.Arrays;

/**
 * 一个整数，只允许交换两个数字的位置，返回最大的可能
 *
 * @author zlren
 * @date 2018-05-02
 */
public class LC670MaximumSwap {

    /**
     * 想法就是最大的数字换到最前面（高优先级），小的数字换到最后面（低优先级）
     * 比如第一个数字是1而后面有好几个9的时候，应该和最后一个9交换，这启发我们应该保存每个数字出现的最后位置
     *
     * @param num
     * @return
     */
    public int maximumSwap(int num) {

        char[] chars = String.valueOf(num).toCharArray();

        if (chars.length <= 1) {
            return num;
        }

        // 每一位的值为0-9，nums记录了每个数字最后一次出现的位置
        int[] nums = new int[10];
        Arrays.fill(nums, -1);
        for (int i = 0; i < chars.length; i++) {
            nums[chars[i] - '0'] = i;
        }

        // 从左往右遍历，如果右侧出现了比自己更大的数字，交换即可
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i] - '0';
            for (int j = 9; j > c; j--) {
                if (nums[j] > i) {
                    char t = chars[nums[j]];
                    chars[nums[j]] = chars[i];
                    chars[i] = t;
                    return Integer.valueOf(String.valueOf(chars));
                }
            }
        }

        return num;
    }

}
