package lab.zlren.others;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author zlren
 * @date 2018-03-14
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> list = new Main().solution(new int[]{1, 2, 3});
        Collections.sort(list);
        System.out.println(list);
    }

    private List<Integer> solution(int[] nums) {

        List<Integer> list = new LinkedList<>();

        for (int num : nums) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                list.add(list.get(j) + num);
            }
            list.add(num);
        }

        return list;
    }

    /**
     * 从nums数组中随机选取k个数字，是随机的
     *
     * @param nums 数组
     * @param k    选取k个
     * @return
     */
    private static int[] getRandom(int[] nums, int k) {

        int n = nums.length;
        int[] sample = new int[n];
        System.arraycopy(nums, 0, sample, 0, n);

        Random random = new Random();
        for (int i = k; i < n; i++) {
            // 0 <= r < i
            int r = random.nextInt(i);
            if (r <= k - 1) {
                sample[r] = nums[i];
            }
        }

        return sample;
    }
}
