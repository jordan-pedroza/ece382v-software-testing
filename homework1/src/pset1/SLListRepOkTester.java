package pset1;
import static org.junit.Assert.*;
import org.junit.Test;
import pset1.SLList.Node;

public class SLListRepOkTester {
    // 0 nodes
    @Test public void t0() {
        SLList l = new SLList();
        assertTrue(l.repOk());
    }

    // 1 node, acyclic
    @Test public void t1() {
        SLList l = new SLList();
        Node n = new Node();
        l.header = n;
        n.next = null;
        assertTrue(l.repOk());
    }

    // 1 node, self-cycle
    @Test public void t2() {
        SLList l = new SLList();
        Node n = new Node();
        l.header = n;
        n.next = n;
        assertFalse(l.repOk());
    }

    // 2 nodes, acyclic
    @Test public void t3() {
        SLList l = new SLList();
        Node n1 = new Node();
        Node n2 = new Node();
        l.header = n1;
        n1.next = n2;
        n2.next = null;
        assertTrue(l.repOk());
    }

    // 2 nodes, first node self-cycle
    @Test public void t4() {
        SLList l = new SLList();
        Node n1 = new Node();
        Node n2 = new Node();
        l.header = n1;
        n1.next = n1;
        assertFalse(l.repOk());
    }

    // 2 nodes, second node self-cycle
    @Test public void t5() {
        SLList l = new SLList();
        Node n1 = new Node();
        Node n2 = new Node();
        l.header = n1;
        n1.next = n2;
        n2.next = n2;
        assertFalse(l.repOk());
    }

    // 2 nodes, cycle between nodes
    @Test public void t6() {
        SLList l = new SLList();
        Node n1 = new Node();
        Node n2 = new Node();
        l.header = n1;
        n1.next = n2;
        n2.next = n1;
        assertFalse(l.repOk());
    }
}
