package pset4;

import java.util.Arrays;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class Graph {
    private int numNodes; // number of nodes in the graph
    private boolean[][] edges;
    // edges[i][j] is true if and only if there is an edge from node i to node j

    // class invariant: edges != null; edges is a square matrix;
    //                  numNodes >= 0; numNodes is number of rows in edges

    public Graph(int size) {
        if (size >= 0) { 
            numNodes = size;
            // your code goes here
            // ...
            edges = new boolean[size][size];
            for (int i = 0; i < edges.length; i++){ 
                for (int j = 0; j < edges[i].length; j++) {
                    edges[i][j] = false;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "numNodes: " + numNodes + "\n" + "edges: " + Arrays.deepToString(edges);
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != Graph.class) return false;
        return toString().equals(o.toString());
    }

    public void addEdge(int from, int to) {
        // postcondition: adds a directed edge "from" -> "to" to this graph
        // your code goes here
        // ...
        
        if (from < 0 || to < 0 || from >= numNodes || to >= numNodes) {
            System.out.println("Invalid node index");
        }else {
            edges[from][to] = true;
        }
    }

    public boolean reachable(Set<Integer> sources, Set<Integer> targets) {
        if (sources == null || targets == null) throw new IllegalArgumentException();

        // postcondition: returns true if (1) "sources" does not contain an illegal node,
        //                  (2) "targets" does not contain an illegal node, and
        //                  (3) for each node "m" in set "targets", there is some
        //                  node "n" in set "sources" such that there is a directed
        //                  path that starts at "n" and ends at "m" in "this"; and
        //                  false otherwise

        // your code goes here
        // ...

        // bfs 
        // 1. Validate inputs (no illegal node indices)
        // 2. Create visited array
        boolean[] visited = new boolean[numNodes];

        // 3. Create queue
        Queue<Integer> queue = new LinkedList<>();
        // 4. Add all source nodes to queue
        for (int s : sources){
            if (s < 0 || s >= numNodes) {
                throw new IllegalArgumentException();
            }
            visited[s] = true;
            queue.add(s);
        }
        // 5. While queue not empty:
        //     a. Remove current node
        //     b. For each neighbor:
        //             if edge exists and not visited:
        //                 mark visited
        //                 add to queue
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for (int j = 0; j < numNodes; j++) {
                if (edges[curr][j] && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }

        // 6. Check that every target node was visited
        for (int t : targets) {
            if (t < 0 || t >= numNodes) {
                throw new IllegalArgumentException();
            }
            if (!visited[t]) {
                return false;
            }
        }

        return true;

    }
}
