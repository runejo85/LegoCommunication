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
        pointGrid.add(new Point(10, 0));
        pointGrid.add(new Point(20, 0));

        pointGrid.add(new Point(0, 10));
        pointGrid.add(new Point(10, 10));
        pointGrid.add(new Point(20, 10));

        pointGrid.add(new Point(0, 20));
        pointGrid.add(new Point(10, 20));
        pointGrid.add(new Point(20, 20));

        pointGrid.add(new Point(0, 30));
        pointGrid.add(new Point(10, 30));
        pointGrid.add(new Point(20, 30));

        pointGrid.add(new Point(0, 40));
        pointGrid.add(new Point(10, 40));
        pointGrid.add(new Point(20, 40));
        points = LeeAlgorithm.getShortestPath(new Point(0,0), new Point(20,0), null);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLeeAlgorithm() {
        Point[] result = { new Point(10,20), new Point(10,30), new Point(10,40), new Point(20,40)};
        for(int i = 0; i < points.length; i++) {
           // assertEquals(points[i], result[i]);
            System.out.println(points[i]);

        }



    }
}