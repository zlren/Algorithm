package lab.zlren.nowcoder.offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次
 * 请写程序找出这两个只出现一次的数字
 *
 * @author zlren
 * @date 2018-01-06
 */
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        System.out.println(5 >> 1);
    }

    /**
     * 将num1[0],num2[0]设置为返回结果
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {

        int length = array.length;
        if (length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }

        int bitResult = 0;
        for (int anArray : array) {
            bitResult ^= anArray;
        }

        int index = findFirst1(bitResult);
        for (int anArray : array) {
            if (isBit1(anArray, index)) {
                num1[0] ^= anArray;
            } else {
                num2[0] ^= anArray;
            }
        }
    }

    private int findFirst1(int bitResult) {
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }
}
