package lab.zlren.leetcode.array;

/**
 * 二分查找算法
 *
 * @author zlren
 * @date 17/10/10
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        System.out.println(binarySearch(arr, 20));
        System.out.println(binarySearch(arr, 60));
        System.out.println(binarySearch(arr, 111));
    }

    private static int binarySearch(int[] arr, int target) {

        // 在[l .. r]的范围里寻找target
        int l = 0, r = arr.length - 1;

        // 当l和r相等的时候，区间依然是有效的，所以有=号
        while (l <= r) {
            // int mid = (l + r) / 2; // 求两个数的均值，相加后可能导致溢出
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
