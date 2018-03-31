package lab.zlren.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @author zlren
 * @date 2018-03-26
 */
public class LC46Permutations {

    public static void main(String[] args) {

    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        if (nums.length == 0) {
            return res;
        }

        generatePermutation(nums, new ArrayList<>());

        return res;
    }

    /**
     * @param nums
     * @param cur
     */
    private void generatePermutation(int[] nums, List<Integer> cur) {

        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int num : nums) {
            // 这里有一个判重
            if (cur.contains(num)) {
                continue;
            }

            cur.add(num);
            generatePermutation(nums, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
