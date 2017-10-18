package lab.zlren.leetcode.sort;

import lab.zlren.leetcode.helper.ArrayHelper;

/**
 * 冒泡排序
 *
 * @author zlren
 * @date 17/10/18
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {

        for (int i = nums.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                // 左边的大就交换
                if (nums[j] > nums[j + 1]) {
                    ArrayHelper.swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 第一种优化方式是设置一个标记位来标记是否发生了交换，如果没有发生交换就提前结束
     * 第二种优化方式是记录最后发生交换的位置，作为下一趟比较结束的位置
     *
     * @param nums
     */
    public static void sort2(int[] nums) {

        boolean swap;
        int lastSwapIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 1; ) {
            swap = false;
            for (int j = 0; j < i; j++) {
                // 左边的大就交换
                if (nums[j] > nums[j + 1]) {
                    swap = true;
                    ArrayHelper.swap(nums, j, j + 1);
                    lastSwapIndex = j;
                }
            }

            if (!swap) {
                return;
            }

            i = lastSwapIndex;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] nums = ArrayHelper.generateRandomArray(100, 100);
            sort2(nums);
            if (!ArrayHelper.isSorted(nums)) {
                System.out.println("有问题");
            }
        }
    }
}
