package test.beanTest;

import org.junit.*;
import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.*;
import uis.beans.Line;
import uis.beans.Point;
import java.awt.Color;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 3/31/11
 * Time: 12:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class lineTest {
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(lineTest.class);
    }

    Line l1, l2, l3;
    @Before
    public void setUp() {
        l1 = new Line(new Point(1,2), new Point(2,1), Color.black);
        l2 = new Line(new Point(2,1), new Point(1,2), Color.black);
        l3 = new Line(new Point(3,1), new Point(1,2), Color.black);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEquals() {
        assertTrue(l1.equals(l2));
        assertFalse(l1.equals(l3));
    }
}