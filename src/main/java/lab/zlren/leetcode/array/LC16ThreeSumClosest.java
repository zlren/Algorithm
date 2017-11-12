package lab.zlren.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zlren
 * @date 2017-11-11
 */
public class LC16ThreeSumClosest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.values();
    }

    public int threeSumClosest(int[] nums, int target) {

        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);

        int ret = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            int sum;
            while (lo < hi) {
                sum = nums[i] + nums[lo] + nums[hi];
                if (sum == target) return target;
                else if (sum > target) hi--;
                else lo++;
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    ret = sum;
                }
            }
        }

        return ret;
    }

}
