package lab.zlren.leetcode.graph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 稀疏图，使用邻接表实现
 *
 * @author zlren
 * @date 17/11/1
 */
public class SparseGraph implements Graph {

    /**
     * 节点数
     */
    private int vertex;

    /**
     * 边数
     */
    private int edge;

    /**
     * 有向图、无向图
     */
    private boolean directed;

    private ArrayList[] edges;

    public SparseGraph(int vertex, boolean directed) {
        this.vertex = vertex;
        this.directed = directed;

        edges = new ArrayList[vertex];
        for (int i = 0; i < vertex; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    /**
     * 返回顶点个数
     *
     * @return
     */
    @Override
    public int vertex() {
        return vertex;
    }

    /**
     * 返回边数
     *
     * @return
     */
    @Override
    public int edge() {
        return edge;
    }

    /**
     * 增加一条边
     * 在顶点v和w之间增加一条边
     *
     * @param v
     * @param w
     */
    @Override
    public void addEdge(int v, int w) {

        // On的时间复杂度
        // if (hasEdge(v, w)) {
        //     return;
        // }

        edges[v].add(w);
        if (v != w && !directed) {
            edges[w].add(v);
        }

        edge++;
    }

    /**
     * 判断v和w之间是否有一条边
     *
     * @param v
     * @param w
     * @return
     */
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < vertex;
        assert w >= 0 && w < vertex;

        for (int i = 0; i < edges[v].size(); i++) {
            // if (edges[v].get(i) == w) {
            //     return true;
            // }
        }

        return false;
    }

    /**
     * 返回一个顶点的所有临边
     *
     * @param v
     * @return
     */
    @Override
    public Iterator<Integer> adj(int v) {
        assert v >= 0 && v < vertex;

        return edges[v].iterator();
    }
}
