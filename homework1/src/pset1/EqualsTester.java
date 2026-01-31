package pset1;
import static org.junit.Assert.*;
import org.junit.Test;

public class EqualsTester {
    /*
    * P1: For any non-null reference value x, x.equals(null) should return false.
    */
    @Test public void t0() {
        assertFalse(new Object().equals(null));
    }
    @Test public void t1() {
        assertFalse(new C(0).equals(null));
    }
    @Test public void t2() { 
        assertFalse(new D(0,0).equals(null));
    }
    // your test methods for P1 go here
    /*
    * P2: It is reflexive: for any non-null reference value x, x.equals(x)
    * should return true.
    */
    // your test methods for P2 go here
    @Test public void t3() {
        Object new_object = new Object();
        assertTrue(new_object.equals(new_object));
    }
    @Test public void t4() {
        C c = new C(0);
        assertTrue(c.equals(c));
    }
    @Test public void t5() {
        D d = new D(0, 0);
        assertTrue(d.equals(d));
    }
    /*
    * P3: It is symmetric: for any non-null reference values x and y, x.equals(y)
    * should return true if and only if y.equals(x) returns true.
    */
    // your test methods for P3 go here
    @Test public void t_p3_0() {
        Object x = new Object();
        Object y = new Object();
        assertTrue(x.equals(y) == y.equals(x));
    }
    @Test public void t_p3_1() {
        Object x = new Object();
        C y = new C(0);
        assertTrue(x.equals(y) == y.equals(x));
    }
    @Test public void t_p3_2() {
        Object x = new Object();
        D y = new D(0,0);
        assertTrue(x.equals(y) == y.equals(x));
    }
    @Test public void t_p3_3() {
        C x = new C(0);
        Object y = new Object();
        assertTrue(x.equals(y) == y.equals(x));
    }
    @Test public void t_p3_4() {
        C x = new C(0);
        C y = new C(0);
        assertTrue(x.equals(y) == y.equals(x));
    }
    @Test public void t_p3_5() {
        C x = new C(0);
        D y = new D(0,0);
        assertTrue(x.equals(y) == y.equals(x));
    }
    @Test public void t_p3_6() {
        D x = new D(0, 0);
        Object y = new Object();
        assertTrue(x.equals(y) == y.equals(x));
    }
    @Test public void t_p3_7() {
        D x = new D(0, 0);
        C y = new C(0);
        assertTrue(x.equals(y) == y.equals(x));
    }
    @Test public void t_p3_8() {
        D x = new D(0, 0);
        D y = new D(0,0);
        assertTrue(x.equals(y) == y.equals(x));
    }
    /*
    * P4: It is transitive: for any non-null reference values x, y, and z,
    * if x.equals(y) returns true and y.equals(z) returns true, then
    * x.equals(z) should return true.
    */
    // you do not need to write tests for P4
}
