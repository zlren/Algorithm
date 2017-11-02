package lab.zlren.leetcode.graph;

import java.io.IOException;

/**
 * @author zlren
 * @date 2017-11-01
 */
public class Test {

    public static void main(String[] args) throws IOException {
        SparseGraph graph = new SparseGraph(6, false);
        ReadGraph.readGraph(graph, "testG2.txt");

        // System.out.println(graph.hasEdge(0, 1));
        // System.out.println(graph.vertex());

        Component component = new Component();
        System.out.println(component.component(graph));

    }

}
