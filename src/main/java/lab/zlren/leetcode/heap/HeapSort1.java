package lab.zlren.leetcode.heap;

import lab.zlren.leetcode.helper.ArrayHelper;

/**
 * 第一个版本的堆排序，将待排数组一个一个的插入到堆中，再顺序取出
 *
 * @author zlren
 * @date 17/10/26
 */
public class HeapSort1 {

    public static void sort(int[] nums) {
        MaxHeap maxHeap = new MaxHeap(nums.length);

        for (int i = 0; i < nums.length; i++) {
            maxHeap.insert(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = maxHeap.extractMax();
        }
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
