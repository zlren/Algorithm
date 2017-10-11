package lab.zlren.leetcode.array;

/**
 * 二分查找算法
 * Created by zlren on 17/10/10.
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

        int l = 0, r = arr.length - 1; // 在[l .. r]的范围里寻找target

        while (l <= r) { // 当l和r相等的时候，区间依然是有效的，所以有=号
            int mid = (l + r) / 2;
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
