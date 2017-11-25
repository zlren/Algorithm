package lab.zlren.leetcode.stack;

import java.util.Stack;

/**
 * @author zlren
 * @date 2017-11-25
 */
public class LC71SimplifyPath {

    public static void main(String[] args) {

        System.out.println(simplifyPath("/.."));
    }

    /**
     * 简化Linux路径
     *
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] split = path.split("/");

        for (String s : split) {

            if (s.length() == 0 || ".".equals(s)) {
                continue;
            }

            if ("..".equals(s)) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        StringBuilder ret = new StringBuilder();
        while (!stack.empty()) {
            ret.insert(0, stack.pop());
            ret.insert(0, "/");
        }

        if (ret.length() == 0) {
            return "/";
        }

        return ret.toString();
    }
}
