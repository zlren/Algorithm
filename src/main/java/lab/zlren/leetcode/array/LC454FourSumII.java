package lab.zlren.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zlren
 * @date 2017-11-12
 */
public class LC454FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 注意这个问题只让返回个数
        // 将A和B中的值每两个数字的和作为key，value是有几对这样的i和j使得A[i]+B[j]为key
        // 同理C和D，但是C和D不用再存一遍，遍历的过程就可以计算
        Map<Integer, Integer> map = new HashMap<>();

        // 注释掉是因为那是java 8的写法
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                // map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                // res += map.getOrDefault(-1 * (A[i] + B[j]), 0);
            }
        }

        return res;
    }

}
