package lab.zlren.leetcode.the8character;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合数
 *
 * @author zlren
 * @date 2018-03-27
 */
public class LC77Combinations {

    public static void main(String[] args) {
        List<List<Integer>> combine = new LC77Combinations().combine(4, 2);
        for (List<Integer> integers : combine) {
            System.out.println(integers);
        }
    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        generateCombinations(n, k, 1, new ArrayList<>());
        return res;
    }

    /**
     * 求解C(n, k)，当前已经找到的组合存储在cur中，需要从start开始搜索新的元素
     *
     * @param n
     * @param k
     * @param start
     */
    private void generateCombinations(int n, int k, int start, List<Integer> cur) {

        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n - (k - cur.size()) + 1; i++) {
            cur.add(i);
            generateCombinations(n, k, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
