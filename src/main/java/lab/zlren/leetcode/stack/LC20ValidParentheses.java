package lab.zlren.leetcode.stack;

import java.util.Stack;

/**
 * @author zlren
 * @date 2017-11-24
 */
public class LC20ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}}"));
    }

    public static boolean isValid(String s) {

        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {

                if (stack.size() <= 0) {
                    return false;
                }

                Character pop = stack.pop();

                if ((c == ')' && pop == '(') || (c == ']' && pop == '[') || (c == '}' && pop == '{')) {

                } else {
                    return false;
                }
            }
        }

        if (stack.size() > 0) {
            return false;
        }

        return true;
    }
}
