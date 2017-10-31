package lab.zlren.leetcode.union;

/**
 * QuickFind
 *
 * @author zlren
 */
public class UnionFind {

    /**
     * id[i] = k 第i个元素所在的分组是k
     */
    private int[] id;
    private int count;


    public UnionFind(int n) {
        this.id = new int[n];
        this.count = n;

        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * On的复杂度
     *
     * @param p
     * @param q
     */
    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < count; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }

    }

}
