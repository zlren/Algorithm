package lab.zlren.leetcode.test;

import lombok.extern.slf4j.Slf4j;

/**
 * 最小公约数、最大公倍数
 *
 * @author zlren
 * @date 2018-04-13
 */
@Slf4j
public class MinMax {

    public static void main(String[] args) {

        log.info("最小公倍数：{}", new MinMax().min(12, 8));
        log.info("最大公约数：{}", new MinMax().max(12, 8));
    }

    /**
     * 最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private int max(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        if (max % min == 0) {
            return min;
        } else {
            return max(min, max % min);
        }
    }

    /**
     * 最小公倍数，ab的乘机除以ab的最大公约数，就是ab的最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    private int min(int a, int b) {
        return a * b / max(a, b);
    }
}
