package lab.zlren.nowcoder.offer;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列
 *
 * @author zlren
 * @date 2018-01-08
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 1) {
            return result;
        }

        int left = 1, right = 2;
        int curSum = left + right;
        while (left <= (sum / 2 + 1)) {
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                result.add(list);

                curSum = curSum - left;
                left++;

                right++;
                curSum = curSum + right;

            } else if (curSum < sum) {
                right++;
                curSum = curSum + right;
            } else {
                curSum = curSum - left;
                left++;
            }
        }

        return result;
    }
}
