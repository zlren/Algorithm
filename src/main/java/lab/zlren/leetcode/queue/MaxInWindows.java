package lab.zlren.leetcode.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zlren
 * @date 2018-01-19
 */
public class MaxInWindows {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(Arrays.toString(new MaxInWindows().maxInWindows(nums, 3).toArray()));
    }

    /**
     * 滑动窗口的最大值
     *
     * @param nums 数组
     * @param size 窗口大小
     * @return 最大值列表
     */
    ArrayList<Integer> maxInWindows(int[] nums, int size) {
        ArrayList<Integer> result = new ArrayList<>();

        // 双向队列，用于存储有可能成为当前窗口最大值的数字的下标，其中队首是最大值的下标
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 首先找到第一个窗口的最大值
        for (int i = 0; i < size; i++) {

        }
        result.add(nums[deque.peekFirst()]);

        for (int i = size; i <= nums.length - 1; i++) {
            if (i - deque.getFirst() == size) {
                // 过期
                deque.pollFirst();
            }

            // 把不可能的全删掉
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            result.add(nums[deque.peekFirst()]);
        }

        return result;
    }
}
