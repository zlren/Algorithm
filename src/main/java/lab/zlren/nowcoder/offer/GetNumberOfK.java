package lab.zlren.nowcoder.offer;

/**
 * 统计一个数字在排序数组中出现的次数
 *
 * @author zlren
 * @date 2018-01-01
 */
public class GetNumberOfK {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int k = 3;
        GetNumberOfK getNumberOfK = new GetNumberOfK();
        System.out.println(getNumberOfK.getFirstK(array, 0, array.length - 1, k));
    }

    // 有序可重复的数组中，利用二分搜索找到某个值的第一次和最后一次出现的位置
    public int GetNumberOfK(int[] array, int k) {
        return getLastK(array, 0, array.length - 1, k) - getFirstK(array, 0, array.length - 1, k) + 1;
    }

    public int getFirstK(int[] array, int left, int right, int k) {
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] > k) {
                right = mid - 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else if (mid - 1 >= 0 && array[mid - 1] == k) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int getLastK(int[] array, int left, int right, int k) {
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] > k) {
                right = mid - 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else if (mid + 1 <= array.length - 1 && array[mid + 1] == k) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }
}
