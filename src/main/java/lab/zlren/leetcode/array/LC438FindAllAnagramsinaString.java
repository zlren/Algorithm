package lab.zlren.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zlren
 * @date 2017-11-07
 */
public class LC438FindAllAnagramsinaString {

    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {

        // 滑动窗口，On的时间复杂度解决问题
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        int[] hs = new int[256];
        int[] hp = new int[256];
        int pLen = p.length();
        for (int i = 0; i < pLen; i++) {
            hp[p.charAt(i)]++;
        }

        for (int j = 0; j < s.length(); j++) {
            hs[s.charAt(j)]++;
            if (j >= pLen) {
                hs[s.charAt(j - pLen)]--;
            }
            // 判断两个数组是否相等
            if (Arrays.equals(hs, hp)) {
                res.add(j - pLen + 1);
            }
        }
        return res;
    }
}
