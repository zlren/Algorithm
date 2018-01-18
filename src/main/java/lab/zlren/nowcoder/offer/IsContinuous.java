package lab.zlren.nowcoder.offer;

/**
 * @author zlren
 * @date 2018-01-10
 */
public class IsContinuous {


    public boolean isContinuous(int[] numbers) {

        if (numbers.length != 5) {
            return false;
        }

        int min = 14, max = -1, flag = 0;

        // flag来保证不重复，flag转成二进制后从右往左的第k位为1表示k出现过
        for (int n : numbers) {

            if (n == 0) {
                continue;
            }

            // 重复
            if (((flag >> n) & 1) == 1) {
                return false;
            }

            // 标记出现过
            flag |= (1 << n);

            if (n > max) {
                max = n;
            }

            if (n < min) {
                min = n;
            }

            if (max - min >= 5) {
                return false;
            }
        }
        return true;
    }

}
