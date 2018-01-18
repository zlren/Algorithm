package lab.zlren.nowcoder.offer;

/**
 * @author zlren
 * @date 2018-01-10
 */
public class LastRemaining {

    public static void main(String[] args) {
        new LastRemaining().LastRemaining_Solution(5, 3);
    }

    public int LastRemaining_Solution(int n, int m) {

        int cur = 0; // 当前报的数字
        int i = 0; // 当前是第i个人报数字
        int count = 0; // 出局的人数
        int[] arr = new int[n];

        while (count < n) {

            if (arr[i] == 0) { // 当前这个人没有出局
                if (cur == m - 1) { // 报的数字是m-1
                    count++; // 出局个数+1
                    arr[i] = 1; // 出局
                    cur = 0; // 下一个要报的数字是0
                } else { // 报的数字不是m-1
                    cur++; // 下一个要报的数字
                }
            }

            if (i == n - 1) {
                i = 0;
            } else {
                i++;
            }
        }

        return i + 1; // 差着1
    }
}
