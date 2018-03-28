package lab.zlren.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个集合的所有子集
 *
 * @author zlren
 * @date 2018-03-27
 */
public class LC78Subsets {

    public static void main(String[] args) {
        new LC78Subsets().subsets(new int[]{1, 2, 3}).forEach(System.out::println);
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int start, List<Integer> cur) {

        if (start == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (start <= nums.length - 1) {

            // start在结果中
            cur.add(nums[start]);
            helper(nums, start + 1, cur);

            // start不在结果中
            cur.remove(cur.size() - 1);
            helper(nums, start + 1, cur);
        }

    }
}
