package pset1;
import static org.junit.Assert.*;
import org.junit.Test;
public class HashCodeTester {
    /*
    * P5: If two objects are equal according to the equals(Object)
    * method, then calling the hashCode method on each of
    * the two objects must produce the same integer result.
    */
    // your test methods go here
    @Test public void t0(){
        Object x = new Object();
        Object y = new Object();
        assertTrue(x.equals(y) == (x.hashCode() == y.hashCode()));
    }
    @Test public void t1(){
        Object x = new Object();
        C y = new C(0);
        assertTrue(x.equals(y) == (x.hashCode() == y.hashCode()));
    }
    @Test public void t2(){
        Object x = new Object();
        D y = new D(0, 0);
        assertTrue(x.equals(y) == (x.hashCode() == y.hashCode()));
    }
    @Test public void t3(){
        C x = new C(0);
        Object y = new Object();
        assertTrue(x.equals(y) == (x.hashCode() == y.hashCode()));
    }
    @Test public void t4(){
        C x = new C(0);
        C y = new C(0);
        assertTrue(x.equals(y) == (x.hashCode() == y.hashCode()));
    }
    @Test public void t5(){
        C x = new C(0);
        D y = new D(0, 0);
        assertTrue(x.equals(y) == (x.hashCode() == y.hashCode()));
    }
    @Test public void t6(){
        D x = new D(0, 0);
        Object y = new Object();
        assertTrue(x.equals(y) == (x.hashCode() == y.hashCode()));
    }
    @Test public void t7(){
        D x = new D(0, 0);
        C y = new C(0);
        assertTrue(x.equals(y) == (x.hashCode() == y.hashCode()));
    }
    @Test public void t8(){
        D x = new D(0, 0);
        D y = new D(0, 0);;
        assertTrue(x.equals(y) == (x.hashCode() == y.hashCode()));
    }

}
