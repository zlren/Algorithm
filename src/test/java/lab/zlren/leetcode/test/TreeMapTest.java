package lab.zlren.leetcode.test;

import java.util.*;

/**
 * @author zlren
 * @date 2017-11-11
 */
public class TreeMapTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("a", "ddddd");
        map.put("c", "bbbbb");
        map.put("d", "aaaaa");
        map.put("b", "ccccc");

        // 这里将map.entrySet()转换成list
        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
        // 然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            // 升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }

        TreeMapTest treeMapTest = new TreeMapTest();
        Class<? extends TreeMapTest> aClass = treeMapTest.getClass();

    }
}
