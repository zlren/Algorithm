package lab.zlren.leetcode.heap;

import lab.zlren.leetcode.helper.ArrayHelper;

/**
 * 第二个版本的堆排序，首先将待排数组赋值到堆中然后在堆内进行调整
 *
 * @author zlren
 * @date 17/10/26
 */
public class HeapSort2 {

    public static void sort(int[] nums) {

        // 这样就构建好了一个堆，具体见构造函数
        MaxHeap maxHeap = new MaxHeap(nums);

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
