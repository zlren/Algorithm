package lab.zlren.leetcode.sort;

import lab.zlren.leetcode.helper.ArrayHelper;

/**
 * @author zlren
 * @date 17/10/17
 */
public class SelectionSort {

    /**
     * 选择排序
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
        int[] nums = ArrayHelper.generateRandomArray(10, 10);
        ArrayHelper.printArray(nums);
        sort(nums);
        ArrayHelper.printArray(nums);
    }

}
