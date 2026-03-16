package pset7;

import java.util.Arrays;
// import java.util.Set;


public class Graph {
    private int numNodes; // number of nodes in the graph
    private boolean[][] edges;

    // edges[i][j] is true if and only if there is an edge from node i to node j
    // class invariant: edges != null; edges is a square matrix;
    // numNodes >= 0; numNodes is number of rows in edges

    public Graph(int size) {
        numNodes = size;
        edges = new boolean[size][size];
    }

    @Override
    public String toString() {
        return "numNodes: " + numNodes + "; " + "edges: " + Arrays.deepToString(edges);
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != pset7.Graph.class) return false;
            return toString().equals(o.toString());
    }

    @Override
    public int hashCode() {
        // your code goes here
        // ...
        return toString().hashCode();
    }

    public void addEdge(int from, int to) {
        // postcondition: adds a directed edge "from" -> "to" to this graph
        edges[from][to] = true;
    }

    public int numEdges() {
        // post: returns the number of edges in this
        // your code goes here
        // ...
        
        int num_edges = 0;

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++){
                if (edges[i][j]){
                    num_edges++;
                }
            }
        }
        return num_edges;
    }

    public boolean hasExactlyOneEdge() {
        // post: returns true if and only if there is exactly one edge in this
        // your code goes here
        // ...
        
        return this.numEdges() == 1;
    }

    public boolean isReflexive() {
        // post: returns true if this represents a reflexive relation
        // your code goes here
        // ...
        
        for (int i = 0; i < this.edges.length; i++){
            if (!edges[i][i]) {return false;}
        }
        return true;
    }
    

    public boolean isSymmetric() {
        // post: returns true if and only if this represents a symmetric relation
        // your code goes here
        // ...

        for (int i = 0; i < numNodes; i++) {
            for (int j = i + 1; j < numNodes; j++) { // only check j > i
                if (edges[i][j] != edges[j][i]) {   // mismatch means not symmetric
                    return false;
                }
            }
        }
        return true;


    }

    public boolean isTransitive() {
        // post: returns true if and only if this represents a transitive relation
        // your code goes here
        // ...
        
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++){
                if (edges[i][j]) {
                    for (int k = 0; k < edges.length; k++) {
                        if (edges[j][k] && !edges[i][k]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}