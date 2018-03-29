package lab.zlren.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * @author zlren
 * @date 2018-03-28
 */
public class LC120Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        List<List<Integer>> dp = new ArrayList<>();

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == triangle.size() - 1) {
                    list.add(triangle.get(i).get(j));
                } else {
                    list.add(triangle.get(i).get(j) + Math.min(dp.get(0).get(j), dp.get(0).get(j + 1)));
                }
            }
            dp.add(0, list);
        }
        return dp.get(0).get(0);
    }
}
