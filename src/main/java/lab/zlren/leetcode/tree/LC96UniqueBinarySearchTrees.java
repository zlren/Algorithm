package lab.zlren.leetcode.tree;

/**
 * 使用n个树节点（值分别为1到n）可以构成多少个不同的BST
 *
 * @author zlren
 * @date 2018-04-15
 */
public class LC96UniqueBinarySearchTrees {

    public static void main(String[] args) {

    }

    private static class Solution {

        /**
         * mem记忆化搜索
         */
        int[] mem;

        public int numTrees(int n) {
            mem = new int[n + 1];
            return helper(n);
        }

        private int helper(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            if (mem[n] != 0) {
                return mem[n];
            }
            int res = 0;
            // 一共有n个节点，选取一个为根，左右子树的总节点个数为n-1
            // 每选取一个跟，可能的情况是左子树的情况数*右子树的情况数
            for (int i = 0; i <= n - 1; i++) {
                res += helper(i) * helper(n - 1 - i);
            }
            mem[n] = res;
            return res;
        }
    }
}
