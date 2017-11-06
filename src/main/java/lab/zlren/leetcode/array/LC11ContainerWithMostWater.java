package lab.zlren.leetcode.array;

/**
 * @author zlren
 * @date 2017-11-06
 */
public class LC11ContainerWithMostWater {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1;
        int ret = Integer.MIN_VALUE, cur;

        while (i < j) {
            cur = Math.min(height[i], height[j]) * (j - i);
            if (cur > ret) {
                ret = cur;
            }

            // 短边靠拢，看看会不会变长从而弥补靠拢带来的损失
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return ret;
    }

}
