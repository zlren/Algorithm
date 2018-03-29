package lab.zlren.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zlren
 * @date 2018-03-29
 */
public class LC139WordBreak {

    public static void main(String[] args) {
        System.out.println(new LC139WordBreak().wordBreak("acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb", Arrays.asList
                ("abbcbda", "cbdaaa", "b", "dadaaad", "dccbbbc", "dccadd", "ccbdbc", "bbca", "bacbcdd", "a", "bacb", "cbc",
                        "adc", "c", "cbdbcad", "cdbab", "db", "abbcdbd", "bcb", "bbdab", "aa", "bcadb", "bacbcb", "ca",
                        "dbdabdb", "ccd", "acbb", "bdc", "acbccd", "d", "cccdcda", "dcbd", "cbccacd", "ac", "cca", "aaddc",
                        "dccac", "ccdc", "bbbbcda", "ba", "adbcadb", "dca", "abd", "bdbb", "ddadbad", "badb", "ab", "aaaaa",
                        "acba", "abbb")));
    }

    Map<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict);
    }

    private boolean helper(String s, List<String> wordDict) {

        if (s.length() == 0) {
            return true;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        boolean res = false;
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.startsWith(wordDict.get(i))) {
                res |= helper(s.substring(wordDict.get(i).length()), wordDict);
            }
        }

        memo.put(s, res);

        return res;
    }
}
