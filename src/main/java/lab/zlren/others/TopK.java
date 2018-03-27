package lab.zlren.others;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zlren
 * @date 2018-03-13
 */
public class TopK {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new TopK().topK(new int[]{5, 7, 6, 4, 3, 5, 4}, 3)));
    }

    /**
     * 最大的k个元素
     *
     * @param nums
     * @param k
     * @return
     */
    private int[] topK(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.element()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }

        System.out.println(queue.size());

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }

        return res;
    }

}
