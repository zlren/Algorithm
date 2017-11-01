package lab.zlren.leetcode.union;

/**
 * 路径压缩
 *
 * @author zlren
 * @date 17/10/31
 */
public class UnionFind4 {

    /**
     * parent[i] = k 第i个元素的父节点是k，i和k就在一个组
     * i所在的组的标识就是祖先节点
     * 祖先节点有什么特点？parent[z] == z
     */
    private int[] parent;

    /**
     * rank[i]表示以i为根的集合所表示的树的层数
     */
    private int[] rank;

    private int count;

    public UnionFind4(int n) {
        parent = new int[n];
        rank = new int[n];
        this.count = n;

        // 初始，每个元素的父亲都是自己，表示大家都是不同的组
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        assert p >= 0 && p < count;

        // while (p != parent[p]) {
        //
        //     // 路径压缩
        //     // 把自己挂到爷爷身上
        //     parent[p] = parent[parent[p]];
        //
        //     // 考虑这时候自己的父亲
        //     p = parent[p];
        // }
        //
        // // p == parent[p]
        // return p;


        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }

        return parent[p];
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
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            // 相等的时候
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

}
