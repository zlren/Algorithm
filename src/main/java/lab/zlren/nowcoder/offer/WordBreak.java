package lab.zlren.nowcoder.offer;

import java.util.Set;

/**
 * @author zlren
 * @date 2018-02-01
 */
public class WordBreak {

    public static void main(String[] args) {
        // Set<String> dict = new HashSet<>();
        // dict.add("dog");
        // dict.add("s");
        // dict.add("gs");
        //
        // System.out.println(new WordBreak().wordBreak("dogs", dict));
        System.out.println(Integer.valueOf(299) == Integer.valueOf(299));
    }

    public boolean wordBreak(String s, Set<String> dict) {

        if (s == null || s.length() == 0) {
            return true;
        }

        int len = s.length();
        boolean[] f = new boolean[len]; // 默认false

        // f(k)表示[0, k]子串是合题的
        if (dict.contains(s.substring(0, 1))) {
            f[0] = true;
        }

        dict.add("");

        for (int i = 1; i <= len - 1; i++) {
            for (int j = 0; j <= i; j++) {

                String sub = s.substring(j, i + 1);
                if (j > 0 ? f[j - 1] && dict.contains(sub) : dict.contains(sub)) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[len - 1];
    }
}
