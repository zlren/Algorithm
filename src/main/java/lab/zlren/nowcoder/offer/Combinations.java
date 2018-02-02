package lab.zlren.nowcoder.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlren
 * @date 2018-02-02
 */
public class Combinations {

    public static void main(String[] args) {
        List<List<Integer>> list = new Combinations().combine(4, 2);
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        List<Integer> selected = new ArrayList<>();

        helper(selected, nums, k);

        return result;
    }


    public void helper(List<Integer> selected, List<Integer> nums, int k) {

        if (nums == null || nums.size() > k) {
            return;
        }

        if (k == 1) {
            for (int num : nums) {
                List l = new ArrayList<>(selected);
                l.add(num);
                result.add(l);
            }
        } else {
            // 不选第一个元素
            helper(selected, nums.subList(1, nums.size()), k);

            // 选择第一个元素
            List l = new ArrayList<>(selected);
            l.add(nums.get(0));
            helper(l, nums.subList(1, nums.size()), k - 1);
        }
    }

}
