package lab.zlren.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长不包含重复字符的子串
 *
 * @author zlren
 * @date 2017-11-06
 */
public class LC3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LC3LongestSubstringWithoutRepeatingCharacters l = new LC3LongestSubstringWithoutRepeatingCharacters();
        int i = l.lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {

        char[] array = s.toCharArray();

        // [l..r]滑动窗口
        int l = 0, r = -1;
        Set<Character> set = new HashSet<>();
        int ret = Integer.MIN_VALUE;

        while (l <= array.length - 1) {

            if (r + 1 <= array.length - 1) {
                if (!set.contains(array[r + 1])) {
                    r++;
                    set.add(array[r]);
                } else {
                    while (set.contains(array[r + 1])) {
                        set.remove(array[l]);
                        l++;
                    }

                    r++;
                    set.add(array[r]);
                }
            } else {
                break;
            }

            ret = Math.max(ret, r - l + 1);
        }

        return ret;
    }
}
