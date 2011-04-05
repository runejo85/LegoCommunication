package test;

import org.junit.*;
import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.*;
import uis.LeeAlgorithm;
import uis.beans.Point;
import uis.beans.PointGrid;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 4/5/11
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class LeeTest {
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(LeeTest.class);
    }
    PointGrid pointGrid = PointGrid.getInstance();

    Point[] points;
    @Before
    public void setUp() {

        pointGrid.add(new Point(0, 0));
        pointGrid.add(new Point(1, 0));
        pointGrid.add(new Point(2, 0));

        pointGrid.add(new Point(0, 1));
        pointGrid.add(new Point(1, 1));
        pointGrid.add(new Point(2, 1));

        pointGrid.add(new Point(0, 2));
        pointGrid.add(new Point(1, 2));
        pointGrid.add(new Point(2, 2));

        pointGrid.add(new Point(0, 3));
        pointGrid.add(new Point(1, 3));
        pointGrid.add(new Point(2, 3));

        pointGrid.add(new Point(0, 4));
        pointGrid.add(new Point(1, 4));
        pointGrid.add(new Point(2, 4));
        points = LeeAlgorithm.getShortestPath(new Point(2,4), new Point(1,1));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLeeAlgorithm() {
        Point[] result = {new Point(2,4), new Point(2,3), new Point(2,2), new Point(2,1), new Point(1,1)};
        for(int i = 0; i < points.length; i++) {
            assertEquals(points[i], result[i]);
        }


    }
}