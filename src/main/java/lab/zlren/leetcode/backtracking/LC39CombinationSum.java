package lab.zlren.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 寻找和为sum的组合数
 *
 * @author zlren
 * @date 2018-03-27
 */
public class LC39CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> list = new LC39CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

private List<List<Integer>> res = new ArrayList<>();

public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    back(candidates, 0, target, new ArrayList<>());
    return res;
}

private void back(int[] nums, int start, int remain, List<Integer> cur) {
    if (remain == 0) {
        res.add(new ArrayList<>(cur));
        return;
    }

    for (int i = start; i <= nums.length - 1; i++) {
        if (remain >= nums[i]) {
            cur.add(nums[i]);
            back(nums, i, remain - nums[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}
}
