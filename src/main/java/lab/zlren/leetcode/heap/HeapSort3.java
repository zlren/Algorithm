package lab.zlren.leetcode.heap;

import lab.zlren.leetcode.helper.ArrayHelper;

/**
 * 原地堆排序，辅助空间是o1
 * 注意原地堆排序的话，索引从0开始
 *
 * @author zlren
 * @date 17/10/26
 */
public class HeapSort3 {

    public static void sort(int[] nums) {

        heapify(nums);

        for (int i = nums.length - 1; i > 0; i--) {
            ArrayHelper.swap(nums, 0, i);
            shiftDown(nums, 0, i);
        }
    }

    /**
     * 构建最大堆
     *
     * @param nums
     */
    public static void heapify(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            shiftDown(nums, i, nums.length);
        }
    }

    /**
     * shiftdown操作
     *
     * @param nums 待操作数组
     * @param k    将第k个位置进行shiftdown
     * @param n    总共有多少个元素
     */
    public static void shiftDown(int[] nums, int k, int n) {
        int value = nums[k];

        int indexN = k;
        int indexLeftChild = indexN * 2 + 1;

        // 有左孩子就证明有孩子
        while (indexLeftChild < n) {

            // 比较左右两个孩子谁大跟谁换
            int indexMaxChild = indexLeftChild;

            if (indexLeftChild + 1 < n) {
                if (nums[indexLeftChild + 1] > nums[indexLeftChild]) {
                    indexMaxChild = indexLeftChild + 1;
                }
            }

            if (nums[indexMaxChild] < value) {
                break;
            }

            nums[indexN] = nums[indexMaxChild];

            indexN = indexMaxChild;
            indexLeftChild = indexN * 2 + 1;
        }

        nums[indexN] = value;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] nums = ArrayHelper.generateRandomArray(100, 100);
            sort(nums);
            if (!ArrayHelper.isSorted(nums)) {
                System.out.println("有问题");
            }
        }
    }
}
