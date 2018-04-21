package lab.zlren.leetcode.stack;

import java.util.Stack;

/**
 * @author zlren
 * @date 2018-03-31
 */
public class StackSort {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.push(5);
        stack.push(8);
        stack.push(1);
        new StackSort().sortWithStack(stack);
        System.out.println(stack);
    }

    private void sortWithStack(Stack<Integer> stack) {
        Stack<Integer> helper = new Stack<>();

        while (stack.size() > 0) {
            int pop = stack.pop();
            int n = 0;
            while (!helper.isEmpty() && helper.peek() > pop) {
                n++;
                stack.push(helper.pop());
            }
            helper.push(pop);
            for (int i = 0; i < n; i++) {
                helper.push(stack.pop());
            }
        }

        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }

}
