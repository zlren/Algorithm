package lab.zlren.leetcode.sort;

import lab.zlren.leetcode.helper.ArrayHelper;

/**
 * 自底向上的归并排序
 *
 * @author zlren
 * @date 17/10/19
 */
public class MergeSortBottomUp {

    public static void sort(int[] nums) {

        // 分组的时候，每个组的大小
        for (int sz = 1; sz <= nums.length; sz += sz) {

            // 什么是归并？是合起来两个有序子序列
            // 每次归并的时候需要归并第1和第2个序列，第3和第4个序列，第5和..
            // i是每两个相邻序列的前一个序列的首字符下表，i+sz是第二个序列的首字符下表
            // i+sz*2-1是第二个序列的尾标
            for (int i = 0; i + sz <= nums.length - 1; i += (sz * 2)) {
                // 优化1
                if (nums[i + sz - 1] > nums[i + sz]) {
                    if (Math.min(i + sz * 2 - 1, nums.length - 1) - i <= 15) {
                        // 优化2
                        InsertionSort.insertionSort2WithIndex(nums, i, Math.min(i + sz * 2 - 1, nums.length - 1));
                    } else {
                        MergeSort.merge(nums, i, i + sz - 1, Math.min(i + sz * 2 - 1, nums.length - 1));
                    }
                }
            }
        }

        // 同时优化的操作有
        // 1 如果要归并的两个数组已经有序就可以不用归并了
        // 2 对于小数组可以直接插入排序
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            int[] nums = ArrayHelper.generateNearlyOrderedArray(1000);
            sort(nums);
            if (!ArrayHelper.isSorted(nums)) {
                System.out.println("有问题");
            }
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }
}
