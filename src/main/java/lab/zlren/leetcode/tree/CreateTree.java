package lab.zlren.leetcode.tree;

/**
 * 根据前序和中序结果，构建一棵树
 *
 * @author zlren
 * @date 2018-02-06
 */
public class CreateTree {

    public static void main(String[] args) {
        String preOrder = "ABDEGCF";
        String inOrder = "DBGEACF";
    }

    class TreeNode {
        private final char value;
        TreeNode left;
        TreeNode right;

        TreeNode(char value) {
            this.value = value;
        }
    }

    public TreeNode createTree(String preOrder, String inOrder) {

        if (preOrder == null || preOrder.isEmpty()) {
            return null;
        }

        char rootValue = preOrder.charAt(0);
        // rootIndex在数值上等于左子树的大小
        int rootIndex = inOrder.indexOf(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.left = createTree(preOrder.substring(1, 1 + rootIndex), inOrder.substring(0, rootIndex));
        root.right = createTree(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex));

        return root;
    }

    public String postOrder(String preOrder, String inOrder) {

        if (preOrder == null || preOrder.isEmpty()) {
            return "";
        }

        char rootValue = preOrder.charAt(0);
        // rootIndex在数值上等于左子树的大小
        int rootIndex = inOrder.indexOf(rootValue);

        return postOrder(preOrder.substring(1, 1 + rootIndex), inOrder.substring(0, rootIndex)) +
                postOrder(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex)) + rootValue;
    }

    public char afterInOrder(TreeNode node) {

        if (node.right != null) {
            TreeNode temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp.value;
        } else {

        }

        return ' ';
    }
}
