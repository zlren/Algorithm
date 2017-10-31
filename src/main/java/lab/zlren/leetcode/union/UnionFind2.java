package lab.zlren.leetcode.union;

/**
 * QuickUnion
 *
 * @author zlren
 * @date 17/10/31
 */
public class UnionFind2 {

    /**
     * parent[i] = k 第i个元素的父节点是k，i和k就在一个组
     * i所在的组的标识就是祖先节点
     * 祖先节点有什么特点？parent[z] == z
     */
    private int[] parent;

    /**
     * size[i]表示以i为根的组的元素的个数，用于优化union操作
     */
    private int[] size;

    private int count;

    public UnionFind2(int n) {
        parent = new int[n];
        size = new int[n];
        this.count = n;

        // 初始，每个元素的父亲都是自己，表示大家都是不同的组
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        assert p >= 0 && p < count;

        while (p != parent[p]) {
            p = parent[p];
        }

        // p == parent[p]
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 将元素少的组组成的树挂到元素多的组树上
        if (size[qRoot] < size[pRoot]) {
            parent[qRoot] = pRoot;

            size[pRoot] += size[qRoot];
        } else {
            parent[pRoot] = qRoot;

            size[qRoot] += size[pRoot];
        }
    }

}
