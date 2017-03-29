/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fred
 */
public class TimeSpan2Test {

    TimeSpan2 t1;
    TimeSpan2 t2;
    TimeSpan2 t3;

    public TimeSpan2Test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        t1 = new TimeSpan2(new Time(2017, 3, 20, 12, 0), new Time(2017, 3, 20, 12, 30));
        t2 = new TimeSpan2(new Time(2017, 3, 20, 12, 0), new Time(2017, 3, 20, 12, 30));
        t3 = new TimeSpan2(new Time(2017, 3, 20, 12, 5), new Time(2017, 3, 20, 12, 20));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test the constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor() {
        System.out.println("Test Constructor Error \n ");

        assertEquals(false, new TimeSpan2(new Time(2017, 3, 20, 12, 0), new Time(2017, 2, 20, 12, 30)));
    }

    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength() {
        System.out.println("Test method: getLength ");
        int Expected = 30;
        int Actual = t1.length();
        System.out.println("Expected: " + Expected + " Actual: " + Actual + " \n ");
        assertEquals(Expected, Actual);

    }

    /**
     * Test of setBeginTime method, of class TimeSpan.
     */
    @Test
    public void testSetBeginTime() {
        System.out.println("Test method: setBeginTime");
        t1.setBeginTime(new Time(2017, 4, 20, 12, 30));
        ITime Expected = new Time(2017, 4, 20, 12, 30);
        ITime Actual = t1.getBeginTime();
        System.out.println("Expected: " + Expected.toString() + " Actual: " + Actual.toString() + " \n ");
        assertEquals(Expected, Actual);
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("Test method: setEndTime");
        //Stel oude en nieuwe eind tijden vast
        t1.setEndTime(new Time(2017, 4, 20, 12, 45));

        //Verander de oude eindtijd naar de nieuwe eindtijd
        ITime Expected = new Time(2017, 4, 20, 12, 45);
        ITime Actual = t1.getEndTime();
        System.out.println("Expected: " + Expected.toString() + " Actual: " + Actual.toString() + " \n ");
        assertEquals(Expected, Actual);
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetEndTimeExeption() {
        System.out.println("Test method: setEndTime Exeption \n");
        t1.setEndTime(new Time(2015, 1, 20, 12, 45));
    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {
        System.out.println("Test method: Move");
        int min = 1;
        System.out.println("Expected: true Actual: " + t1.equals(t2) + "");
        assertEquals(true, t1.equals(t2));
        t1.move(min);
        System.out.println("Expected: false Actual: " + t1.equals(t2) + " \n ");
        assertEquals(false, t1.equals(t2));
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testChangeLengthWith() {
        System.out.println("Test method: changeLengthWith");
        int min = 1;
        System.out.println("Expected: true Actual: " + t1.equals(t2) + "");
        assertEquals(true, t1.equals(t2));

        t1.changeLengthWith(min);
        System.out.println("Expected: false Actual: " + t1.equals(t2) + "");
        assertEquals(false, t1.equals(t2));

        t2.changeLengthWith(min);
        System.out.println("Expected: true Actual: " + t1.equals(t2) + " \n ");
        assertEquals(true, t1.equals(t2));

        t1.changeLengthWith(-1);
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("Test method: isPartOf");
        t1.move(10);
        System.out.println("Expected: false Actual: " + t1.isPartOf(t2) + "  ");

        assertEquals(false, t1.isPartOf(t2));
        System.out.println("Expected: true Actual: " + t3.isPartOf(t2) + " \n ");

        assertEquals(true, t3.isPartOf(t2));
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("Test method: unionWith");
        TimeSpan2 tsstart = new TimeSpan2(new Time(2017,3,20,12,30), new Time(2017,3,20,12,40));
        
        TimeSpan2 tsafter = new TimeSpan2(new Time(2017,3,20,12,41), new Time(2017,3,20,12,50));
        TimeSpan2 tsbefore = new TimeSpan2(new Time(2017,3,20,12,20), new Time(2017,3,20,12,29));
        TimeSpan2 tsin = new TimeSpan2(new Time(2017,3,20,12,31), new Time(2017,3,20,12,35));
        TimeSpan2 tsleft = new TimeSpan2(new Time(2017,3,20,12,25), new Time(2017,3,20,12,35));
        TimeSpan2 tsright = new TimeSpan2(new Time(2017,3,20,12,35), new Time(2017,3,20,12,50));
        TimeSpan2 tsleftborder = new TimeSpan2(new Time(2017,3,20,12,25), new Time(2017,3,20,12,30));
        TimeSpan2 tsrightborder = new TimeSpan2(new Time(2017,3,20,12,40), new Time(2017,3,20,12,50));
        
assertEquals(null, tsstart.unionWith(tsafter));
        assertEquals(null, tsstart.unionWith(tsbefore));
        assertEquals(10, tsstart.unionWith(tsin).length());
        assertEquals(15, tsstart.unionWith(tsleft).length());
        assertEquals(20, tsstart.unionWith(tsright).length());
        assertEquals(15, tsstart.unionWith(tsleftborder).length());
        assertEquals(20, tsstart.unionWith(tsrightborder).length());

    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("Test method: intersectionWith");
        TimeSpan2 tsstart = new TimeSpan2(new Time(2017,3,20,12,30), new Time(2017,3,20,12,40));     
        TimeSpan2 tsafter = new TimeSpan2(new Time(2017,3,20,12,41), new Time(2017,3,20,12,50));
        TimeSpan2 tsbefore = new TimeSpan2(new Time(2017,3,20,12,20), new Time(2017,3,20,12,29));
        TimeSpan2 tsin = new TimeSpan2(new Time(2017,3,20,12,31), new Time(2017,3,20,12,35));
        TimeSpan2 tsleft = new TimeSpan2(new Time(2017,3,20,12,25), new Time(2017,3,20,12,35));
        TimeSpan2 tsright = new TimeSpan2(new Time(2017,3,20,12,35), new Time(2017,3,20,12,50));
        TimeSpan2 tsleftborder = new TimeSpan2(new Time(2017,3,20,12,25), new Time(2017,3,20,12,30));
        TimeSpan2 tsrightborder = new TimeSpan2(new Time(2017,3,20,12,40), new Time(2017,3,20,12,50));
        
        
        assertEquals(null, tsstart.intersectionWith(tsafter));
        assertEquals(null, tsstart.intersectionWith(tsbefore));
        assertEquals(null, tsstart.intersectionWith(tsleftborder));
        assertEquals(null, tsstart.intersectionWith(tsrightborder));
        assertEquals(4, tsstart.intersectionWith(tsin).length());
        assertEquals(5, tsstart.intersectionWith(tsleft).length());
        assertEquals(5, tsstart.intersectionWith(tsright).length());
    }

    @Test
    public void testToString() {
        String expected = "BeginTime:" + new Time(2017, 3, 20, 12, 0).toString() + "     EndTime" + new Time(2017, 3, 20, 12, 30).toString();
        String actual = t1.toString();
        System.out.println("Expected: " + expected + " Actual: " + actual + " \n ");

        assertEquals(expected, actual);
    }
}
