package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlren
 * @date 2017-12-02
 */
public class LC257BinaryTreePaths {

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root != null) {
            findPath(root, String.valueOf(root.val));
        }

        return result;
    }

    /**
     * 像这种递归遍历的时候，会伴随着被遍历对象有一个附加的值，一般递归函数中要把这两个都作为参数才可以
     * 比如这道题遍历到某个节点的时候伴随着这个节点的是路径累加的字符串
     *
     * @param t
     * @param path
     */
    public void findPath(TreeNode t, String path) {

        // 叶子节点
        if (t.left == null && t.right == null) {
            result.add(path);
        }

        if (t.left != null) {
            findPath(t.left, path + "->" + t.left.val);
        }

        if (t.right != null) {
            findPath(t.right, path + "->" + t.right.val);
        }
    }
}
