package test.beanTest;

import org.junit.*;
import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.*;
import uis.beans.Point;

public class pointTest {
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(pointTest.class);
    }

    Point p1, p2, p3;
    @Before
    public void setUp() {
        p1 = new Point(2,2);
        p2 = new Point(0,0);
        p3 = new Point(2,2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLessThanMethod() {
        assertTrue(p2.lessThan(p1));
        assertFalse(p1.lessThan(p2));
    }

    @Test
    public void testEqualsMethod() {
        assertTrue(p1.equals(p3));
        assertFalse(p1.equals(p2));
    }
}