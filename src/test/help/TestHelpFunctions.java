package test.help;

import org.junit.*;
import junit.framework.JUnit4TestAdapter;
import uis.HelpFunctions;
import uis.beans.Point;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 3/31/11
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestHelpFunctions {
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(TestHelpFunctions.class);
    }

    Point currPos,p1,p2, p3;

    @Before
    public void setUp() {
        currPos = new Point(3,3);
        p1 = new Point(-1,-1);
        p2 = new Point(1,1);
        p3 = new Point(-5, 3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSomething() {
        Point p = HelpFunctions.getClosestPoint(currPos, p1, p2);
        assertEquals(p2, p);
        p = HelpFunctions.getClosestPoint(currPos, p3, p1);
        assertEquals(p1, p);
    }

    @Test
    public void testNumberOfMoves() {
        int a = HelpFunctions.numberOfMoves(currPos, p1);
        assertEquals(a,8);
        a = HelpFunctions.numberOfMoves(currPos, p2);
        assertEquals(a,4);
        a = HelpFunctions.numberOfMoves(currPos, p3);
        assertEquals(a,8);

    }
}