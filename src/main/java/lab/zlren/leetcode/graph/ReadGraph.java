package lab.zlren.leetcode.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author zlren
 * @date 2017-11-02
 */
public class ReadGraph {

    public static Graph readGraph(Graph graph, String filename) throws IOException {

        InputStream resourceAsStream = ReadGraph.class.getClassLoader().getResourceAsStream("graph/" + filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));

        String s = bufferedReader.readLine();
        int vertex = Integer.parseInt(s.split(" ")[0]);

        for (int i = 0; i < Integer.parseInt(s.split(" ")[1]); i++) {
            String line = bufferedReader.readLine();
            int v = Integer.parseInt(line.split(" ")[0]);
            int w = Integer.parseInt(line.split(" ")[1]);

            graph.addEdge(v, w);
        }

        return graph;
    }
}
