package lab.zlren.leetcode.graph;

import java.util.Iterator;

public interface Graph {

    int vertex();

    int edge();

    void addEdge(int v, int w);

    boolean hasEdge(int v, int w);

    Iterator<Integer> adj(int v);
}
