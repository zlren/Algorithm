package lab.zlren.leetcode.array;

/**
 * @author zlren
 * @date 2018-03-15
 */
public class LC42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{2, 0, 2}));
        Runtime.getRuntime().gc();
        System.gc();
    }

    public static int trap(int[] height) {

        if (height == null || height.length <= 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        int res = 0;
        for (int i = 1; i < maxIndex; i++) {
            if (height[i] < height[i - 1]) {
                height[i] += (height[i - 1] - height[i]);
                res += (height[i - 1] - height[i]);
            }
        }

        for (int i = height.length - 2; i > maxIndex; i--) {
            if (height[i] < height[i + 1]) {
                height[i] += (height[i + 1] - height[i]);
                res += (height[i + 1] - height[i]);
            }
        }

        return res;
    }

}
