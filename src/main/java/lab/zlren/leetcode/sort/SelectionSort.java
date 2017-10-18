package lab.zlren.leetcode.sort;

import lab.zlren.leetcode.helper.ArrayHelper;

/**
 * @author zlren
 * @date 17/10/17
 */
public class SelectionSort {

    /**
     * 选择排序
     * 复杂度n方，不稳定的算法
     *
     * @param nums
     */

    public static void sort(int[] nums) {

        if (nums == null || nums.length < 2) {
            return;
        }

        int curMinIndex;
        for (int i = 0; i <= nums.length - 2; i++) {
            curMinIndex = i;
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[j] < nums[curMinIndex]) {
                    curMinIndex = j;
                }
            }
            ArrayHelper.swap(nums, i, curMinIndex);
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayHelper.generateRandomArray(1000000, 10);
        long startTime = System.currentTimeMillis();
        sort(nums);
        long endTime = System.currentTimeMillis();
        assert ArrayHelper.isSorted(nums);
        System.out.println("共用时：" + (float) ((endTime - startTime) / 1000) + "s");
    }

}
