package lab.zlren.leetcode.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 稠密图，使用邻接矩阵实现
 *
 * @author zlren
 * @date 17/11/1
 */
public class DenseGraph implements Graph {

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

    /**
     * 邻接矩阵
     */
    private boolean[][] edges;


    /**
     * 构造函数
     *
     * @param vertex
     * @param directed
     */
    public DenseGraph(int vertex, boolean directed) {
        this.vertex = vertex;
        this.directed = directed;

        this.edge = 0;

        // boolean默认是false
        edges = new boolean[vertex][vertex];
    }

    /**
     * 返回顶点个数
     *
     * @return
     */
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

        if (hasEdge(v, w)) {
            return;
        }

        edges[v][w] = true;

        if (!directed) {
            edges[w][v] = true;
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

        return edges[v][w];
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

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < edge; i++) {
            if (edges[v][i]) {
                list.add(i);
            }
        }

        return list.iterator();
    }

}
