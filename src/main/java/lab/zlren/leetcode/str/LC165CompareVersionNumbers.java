package lab.zlren.leetcode.str;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zlren
 * @date 2018-04-19
 */
@Slf4j
public class LC165CompareVersionNumbers {

    public static void main(String[] args) {
        int i = new Solution().compareVersion("1.0", "1");
        log.info("{}", i);
    }

    static class Solution {
        public int compareVersion(String version1, String version2) {

            if (version1.equals(version2)) {
                return 0;
            }

            String[] s1 = version1.split("\\.");
            String[] s2 = version2.split("\\.");

            if (s1.length < s2.length) {
                StringBuilder version1Builder = new StringBuilder(version1);
                for (int i = 0; i < s2.length - s1.length; i++) {
                    version1Builder.append(".0");
                }
                version1 = version1Builder.toString();
                s1 = version1.split("\\.");
            } else if (s1.length > s2.length) {
                StringBuilder version2Builder = new StringBuilder(version2);
                for (int i = 0; i < s1.length - s2.length; i++) {
                    version2Builder.append(".0");
                }
                version2 = version2Builder.toString();
                s2 = version2.split("\\.");
            }

            for (int i = 0; i < Math.min(s1.length, s2.length); i++) {
                int i1 = Integer.valueOf(s1[i]);
                int i2 = Integer.valueOf(s2[i]);
                if (i1 < i2) {
                    return -1;
                } else if (i1 > i2) {
                    return 1;
                }
            }

            return 0;
        }
    }
}
