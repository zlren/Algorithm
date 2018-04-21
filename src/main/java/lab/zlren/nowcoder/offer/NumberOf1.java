package lab.zlren.nowcoder.offer;

import lombok.extern.slf4j.Slf4j;

/**
 * 计算一个整数转为二进制以后的数字1的个数
 *
 * @author zlren
 * @date 2018-04-13
 */
@Slf4j
public class NumberOf1 {

    public static void main(String[] args) {
        log.info("{}", new NumberOf1().numberOf1(10));
        log.info("{}", Integer.bitCount(10));
    }

    private int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
