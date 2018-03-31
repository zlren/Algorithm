package lab.zlren.jvm.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlren
 * @date 2018-03-29
 */
public class Subsets {

    public static void main(String[] args) {
        new Subsets().subsets(new int[]{1, 2, 3}).forEach(System.out::println);
    }

    private List<List<Integer>> res = new ArrayList<>();

    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int start, List<Integer> cur) {

        if (start == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // nums[start] not in
        helper(nums, start + 1, cur);

        // nums[start] in
        cur.add(nums[start]);
        helper(nums, start + 1, cur);
        cur.remove(cur.size() - 1);
    }
}
