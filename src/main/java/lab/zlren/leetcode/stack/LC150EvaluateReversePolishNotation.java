package lab.zlren.leetcode.stack;

import java.util.Stack;

/**
 * 逆波兰表达式
 *
 * @author zlren
 */
public class LC150EvaluateReversePolishNotation {

    public static void main(String[] args) {

        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                if ("+".equals(token)) {
                    stack.push(String.valueOf(num2 + num1));
                } else if ("-".equals(token)) {
                    stack.push(String.valueOf((num2 - num1)));
                } else if ("*".equals(token)) {
                    stack.push(String.valueOf(num2 * num1));
                } else if ("/".equals(token)) {
                    stack.push(String.valueOf(num2 / num1));
                }
            } else {
                stack.push(token);
            }
        }

        return Integer.valueOf(stack.pop());
    }
}
