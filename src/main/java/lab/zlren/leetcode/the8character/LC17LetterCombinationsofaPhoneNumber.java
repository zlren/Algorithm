package lab.zlren.leetcode.the8character;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 键盘上的数字可以代表的所有字符串
 *
 * @author zlren
 * @date 2017-12-06
 */
public class LC17LetterCombinationsofaPhoneNumber {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC17LetterCombinationsofaPhoneNumber().letterCombinations("23").toArray()));
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new LinkedList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        // 递归的结束条件
        if (digits.length() == 1) {
            switch (digits) {
                case "2":
                    result.add("a");
                    result.add("b");
                    result.add("c");
                    break;
                case "3":
                    result.add("d");
                    result.add("e");
                    result.add("f");
                    break;
                case "4":
                    result.add("g");
                    result.add("h");
                    result.add("i");
                    break;
                case "5":
                    result.add("j");
                    result.add("k");
                    result.add("l");
                    break;
                case "6":
                    result.add("m");
                    result.add("n");
                    result.add("o");
                    break;
                case "7":
                    result.add("p");
                    result.add("q");
                    result.add("r");
                    result.add("s");
                    break;
                case "8":
                    result.add("t");
                    result.add("u");
                    result.add("v");
                    break;
                case "9":
                    result.add("w");
                    result.add("x");
                    result.add("y");
                    result.add("z");
                    break;
                default:
                    break;
            }
        } else { // digits.length() >= 2

            // 递归的核心逻辑
            List<String> l1 = letterCombinations(String.valueOf(digits.charAt(0)));
            List<String> l2 = letterCombinations(digits.substring(1, digits.length()));

            for (String s1 : l1) {
                for (String s2 : l2) {
                    result.add(s1 + s2);
                }
            }
        }

        return result;
    }
}
