package lab.zlren.leetcode.graph;

import java.util.Iterator;

/**
 * 计算图的联通分量和节点间是否联通
 *
 * @author zlren
 * @date 2017-11-02
 */
public class Component {

    private Graph graph;
    private boolean[] visited;
    /**
     * 联通的节点的id值一致
     */
    private int[] id;
    /**
     * 联通分量的个数
     */
    private int count;

    /**
     * 计算联通分量
     *
     * @param graph
     * @return
     */
    public int component(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.vertex()];
        id = new int[graph.vertex()];
        for (int i = 0; i < id.length; i++) {
            id[i] = -1;
        }
        count = 0;

        for (int i = 0; i < graph.vertex(); i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        return count;
    }

    /**
     * 深度优先遍历
     *
     * @param i
     */
    private void dfs(int i) {
        visited[i] = true;
        // !!
        id[i] = count;
        Iterator<Integer> iterator = graph.adj(i);
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public boolean isConnected(int v, int w) {
        return id[v] == id[w];
    }

}
