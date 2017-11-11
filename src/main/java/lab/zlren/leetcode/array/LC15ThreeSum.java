package lab.zlren.leetcode.array;

import java.util.*;

/**
 * @author zlren
 * @date 2017-11-11
 */
public class LC15ThreeSum {
    public static void main(String[] args) {

        LC15ThreeSum lc15ThreeSum = new LC15ThreeSum();
        int[] p = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = lc15ThreeSum.threeSum(p);
        System.out.println(result.size());

    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();

        int target;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i <= nums.length - 3; i++) {
            map.clear();
            target = 0 - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[j])) {
                    List<Integer> l = new ArrayList<>(3);
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[map.get(target - nums[j])]);
                    ret.add(l);
                } else {
                    map.put(nums[j], j);
                }
            }
        }

        return ret;
    }
}
