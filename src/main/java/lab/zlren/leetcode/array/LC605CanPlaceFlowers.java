package lab.zlren.leetcode.array;

/**
 * @author zlren
 * @date 2018-03-25
 */
public class LC605CanPlaceFlowers {

    public static void main(String[] args) {
        System.out.println(new LC605CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0}, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }

        if (flowerbed.length == 1) {
            return flowerbed[0] == 0 ? 1 >= n : 0 >= n;
        }

        int count = 0;
        for (int i = 0; i <= flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && flowerbed[i + 1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                } else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                } else if (flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return count >= n;
    }
}
