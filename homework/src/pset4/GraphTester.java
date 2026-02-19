package pset4;

import static org.junit.Assert.*;
import java.util.TreeSet;
import java.util.Set;
import org.junit.Test;

public class GraphTester {
    // tests for method "addEdge" in class "Graph"
    @Test public void testAddEdge0() {
        Graph g = new Graph(2);
        g.addEdge(0, 1);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 2\nedges: [[false, true], [false, false]]");
}
// your tests for method "addEdge" in class "Graph" go here

// provide at least 4 test methods such that together they provide full statement
// coverage of your implementation of addEdge and any helper methods;
// each test method has at least 1 invocation of addEdge;
// each test method creates exactly 1 graph
// each test method creates a unique graph w.r.t. "equals" method
// each test method has at least 1 test assertion;
// each test assertion correctly characterizes expected behavior with respect to the spec;

// ...

    //add an edge to nothing
    @Test public void testAddEdge1() {
        Graph g = new Graph(0);
        g.addEdge(0, 0);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 0\nedges: []");
    }

    //add edge to out of bounds
    @Test public void testAddEdge2() {
        Graph g = new Graph(1);
        g.addEdge(3, 1);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 1\nedges: [[false]]");
    }

    //add edge to out of bounds
    @Test public void testAddEdge3() {
        Graph g = new Graph(2);
        g.addEdge(-1, 1);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 2\nedges: [[false, false], [false, false]]");
    }

    //add edge to out of bounds
    @Test public void testAddEdge4() {
        Graph g = new Graph(4);
        g.addEdge(0, -1);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 4\nedges: [[false, false, false, false], [false, false, false, false], [false, false, false, false], [false, false, false, false]]");
    }

    //add edge to out of bounds
    @Test public void testAddEdge5() {
        Graph g = new Graph(3);
        g.addEdge(0, 5);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 3\nedges: [[false, false, false], [false, false, false], [false, false, false]]");
    }

        @Test public void testNegSize() {
        Graph g = new Graph(-1);
        g.addEdge(0, 3);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 0\nedges: null");
    }

// tests for method "reachable" in class "Graph"

    @Test public void testReachable0() {
        Graph g = new Graph(1);
        Set<Integer> nodes = new TreeSet<Integer>();
        nodes.add(0);
        assertTrue(g.reachable(nodes, nodes));
    }
    // your tests for method "reachable" in class "Graph" go here

    // provide at least 6 test methods such that together they provide full statement
    // coverage of your implementation of reachable and any helper methods;
    // each test method has at least 1 invocation of reachable;
    // each test method has at least 1 test assertion;
    // at least 2 test methods have at least 1 invocation of addEdge;

    // ...

    // null
    @Test public void testReachable1() {
        Graph g = new Graph(1);
        Set<Integer> nodes = new TreeSet<Integer>();
        assertThrows(IllegalArgumentException.class, () -> g.reachable(null, nodes));
    }
        @Test public void testReachable11() {
        Graph g = new Graph(1);
        Set<Integer> nodes = new TreeSet<Integer>();
        assertThrows(IllegalArgumentException.class, () -> g.reachable(nodes, null));
    }

    // add edge
    @Test public void testReachable2() {
        Graph g = new Graph(3);
        g.addEdge(0, 2);
        Set<Integer> sources = new TreeSet<Integer>();
        Set<Integer> targets = new TreeSet<Integer>();
        sources.add(0);
        targets.add(2);
        assertTrue(g.reachable(sources, targets));
    }

    @Test public void testReachable3() {
        Graph g = new Graph(3);
        g.addEdge(0, 2);
        Set<Integer> sources = new TreeSet<Integer>();
        Set<Integer> targets = new TreeSet<Integer>();
        sources.add(2);
        targets.add(0);
        assertFalse(g.reachable(sources, targets));
    }

    // out of bounds testing for sources and targets
    @Test public void testReachable4() {
        Graph g = new Graph(3);
        g.addEdge(0, 2);
        Set<Integer> sources = new TreeSet<Integer>();
        Set<Integer> targets = new TreeSet<Integer>();
        sources.add(-10);
        targets.add(2);
        assertThrows(IllegalArgumentException.class, () -> g.reachable(sources, targets));
    }

        @Test public void testReachable5() {
        Graph g = new Graph(3);
        g.addEdge(0, 2);
        Set<Integer> sources = new TreeSet<Integer>();
        Set<Integer> targets = new TreeSet<Integer>();
        sources.add(10);
        targets.add(2);
        assertThrows(IllegalArgumentException.class, () -> g.reachable(sources, targets));
    }

    @Test public void testReachable6() {
        Graph g = new Graph(3);
        g.addEdge(0, 2);
        Set<Integer> sources = new TreeSet<Integer>();
        Set<Integer> targets = new TreeSet<Integer>();
        sources.add(0);
        targets.add(-10);
        assertThrows(IllegalArgumentException.class, () -> g.reachable(sources, targets));
    }

    @Test public void testReachable7() {
        Graph g = new Graph(3);
        g.addEdge(0, 2);
        Set<Integer> sources = new TreeSet<Integer>();
        Set<Integer> targets = new TreeSet<Integer>();
        sources.add(0);
        targets.add(10);
        assertThrows(IllegalArgumentException.class, () -> g.reachable(sources, targets));
    }
}