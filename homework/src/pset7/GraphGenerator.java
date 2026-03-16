package pset7;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class GraphGenerator {
    public static Set<Graph> generateAllGraphs(int num) {
    // pre: num >= 0
    // post: returns a set of all graphs that have num nodes
    // your code goes here
    // ...
       Set<Graph> graphs = new HashSet<>();

        int totalEdges = num * num;
        int totalGraphs = (int) Math.pow(2, totalEdges);

        for (int i = 0; i < totalGraphs; i++) {

            Graph g = new Graph(num);

            String bits = Integer.toBinaryString(i);

            // pad with leading zeros
            while (bits.length() < totalEdges) {
                bits = "0" + bits;
            }

            int pos = 0;

            for (int from = 0; from < num; from++) {
                for (int to = 0; to < num; to++) {

                    if (bits.charAt(pos) == '1') {
                        g.addEdge(from, to);
                    }

                    pos++;
                }
            }

            graphs.add(g);
        }

        return graphs;
    }

    public static Set<Graph> generateAllGraphs(int num, String property) {
    // pre: num >= 0 and
    // property is the name of a valid boolean method in class Graph
    // post: returns a set of all graphs (with num nodes) that represent binary
    // relations with the given property
    return generateAllGraphs(num, new String[]{ property });
    }
    
    public static Set<Graph> generateAllGraphs(int num, String[] properties) {
    // pre: num >= 0 and
    // each element of properties is the name of a valid boolean method in class Graph
    // post: returns a set of all graphs (with num nodes) that represent binary
    // relations with all the given properties
    // your code goes here
    // ...
    
        Set<Graph> allGraphs = generateAllGraphs(num);
        Set<Graph> result = new HashSet<>();

        for (Graph g : allGraphs) {
            boolean valid = true;
            for (String prop : properties) {
                try {
                    Method m = Graph.class.getMethod(prop);
                    boolean value = (boolean) m.invoke(g);

                    if (!value) {
                        valid = false;
                        break;
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    valid = false;
                }
            }
            if (valid) {
                result.add(g);
            }
        }
        return result;
    }
}
