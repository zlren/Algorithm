package lab.zlren.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @author zlren
 * @date 2018-03-22
 */
public class DoubleHeap {

    private PriorityQueue<Integer> max = new PriorityQueue<>(16, (o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> min = new PriorityQueue<>();

    private float insertAndGetMid(int num) {
        if (min.isEmpty()) {
            // 加入第一个数字
            min.offer(num);
            return num;
        } else {
            if (num > min.element()) {
                min.offer(num);
            } else {
                max.offer(num);
            }

            // 调整一下，使得 min.size == max.size || min.size == max.size + 1

            while (min.size() < max.size()) {
                min.offer(max.poll());
            }

            while (max.size() < min.size() - 1) {
                max.offer(min.poll());
            }
        }

        if (min.size() == max.size()) {
            return (float) ((min.element() + max.element()) / 2.0);
        } else {
            return min.element();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 3, 1, 5, 8, 7, 6};
        DoubleHeap doubleHeap = new DoubleHeap();
        for (int num : nums) {
            System.out.print(doubleHeap.insertAndGetMid(num) + " ");
        }
    }
}
