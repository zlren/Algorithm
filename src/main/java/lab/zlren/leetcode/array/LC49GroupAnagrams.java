package lab.zlren.leetcode.array;

import java.util.*;

/**
 * @author zlren
 * @date 2017-11-12
 */
public class LC49GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 将互为anagrams的词映射到一个组中，也就是通过一种映射他们有相同的key
        // 可以将每个字符串按字母排序，这样ate、eat、tea就可以映射成aet了

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String sorted = String.valueOf(ca);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }

            map.get(sorted).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
