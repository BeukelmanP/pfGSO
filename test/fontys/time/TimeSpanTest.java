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
public class TimeSpanTest {
    
    TimeSpan t1;
    TimeSpan t2;
    TimeSpan t3;
    
    public TimeSpanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        t1 = new TimeSpan(new Time(2017,3,20,12,0), new Time(2017,3,20,12,30));
        t2 = new TimeSpan(new Time(2017,3,20,12,0), new Time(2017,3,20,12,30));
        t3 = new TimeSpan(new Time(2017,3,20,12,5), new Time(2017,3,20,12,20));
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test the constructor.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConstructor() {
        assertEquals(false,new TimeSpan(new Time(2017,3,20,12,0), new Time(2017,2,20,12,30)));
    }

    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength() {
        System.out.println("Test Lenght");
        int Expected = 30;
        int Actual = t1.length();
        assertEquals(Expected, Actual);
    }

    /**
     * Test of setBeginTime method, of class TimeSpan.
     */
    //@Test(expected=IllegalArgumentException.class)
    public void testSetBeginTime() {
        System.out.println("Test setBeginTime");
        
        ITime bt = t1.getBeginTime();
        t1.setBeginTime(new Time(2017,3,20,12,5));
        
        ITime bt2 = t1.getBeginTime();
        assertEquals(false, bt.equals(bt2));
        
        ITime bt3 = new Time(2017,3,20,12,5);
        assertEquals(true, bt3.equals(bt2));
        
        t1.setBeginTime(new Time(2017,4,20,12,30));
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testSetEndTime() {
        System.out.println("Test setEndTime");
        
        //Stel oude en nieuwe eind tijden vast
        ITime Oldet = t1.getEndTime();
        ITime Newet = new Time(2017,4,20,12,45);

        //Verander de oude eindtijd naar de nieuwe eindtijd
        t1.setEndTime(Newet);
        
        //Test of dat de nieuwe eindtijd anders is dan de oude eindtijd.
        //Test of dat de nieuwe eindtijd gelijk is aan wat er de nieuwe eindtijd moest worden.
        assertEquals(false, Oldet.equals(t1.getEndTime()));
        assertEquals(true, Newet.equals(t1.getEndTime()));
        t1.setEndTime(new Time(2017,2,20,12,30));
    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {
        System.out.println("Test Move");
        int min = 1;
        
        assertEquals(true, t1.equals(t2));
        
        t1.move(min);
        assertEquals(false, t1.equals(t2));
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testChangeLengthWith() {
        System.out.println("Test changeLengthWith");
        int min =1;
         boolean actual = t1.equals(t2);
        //assertEquals(true,actual);
        int b = t1.getEndTime().getMinutes();
        
        t1.changeLengthWith(min);
        
        int a = t1.getEndTime().getMinutes();
                
        assertEquals(false, t1.equals(t2));
        
        t2.changeLengthWith(min);
        assertEquals(true, t1.equals(t2));
        
        t1.changeLengthWith(-1);
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("Test isPartOf");
        t1.move(10);
        assertEquals(false, t1.isPartOf(t2)); 
        assertEquals(true, t3.isPartOf(t2));
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("Test unionWith");
        TimeSpan tsstart = new TimeSpan(new Time(2017,3,20,12,30), new Time(2017,3,20,12,40));
        
        TimeSpan tsafter = new TimeSpan(new Time(2017,3,20,12,41), new Time(2017,3,20,12,50));
        TimeSpan tsbefore = new TimeSpan(new Time(2017,3,20,12,20), new Time(2017,3,20,12,29));
        TimeSpan tsin = new TimeSpan(new Time(2017,3,20,12,31), new Time(2017,3,20,12,35));
        TimeSpan tsleft = new TimeSpan(new Time(2017,3,20,12,25), new Time(2017,3,20,12,35));
        TimeSpan tsright = new TimeSpan(new Time(2017,3,20,12,35), new Time(2017,3,20,12,50));
        TimeSpan tsleftborder = new TimeSpan(new Time(2017,3,20,12,25), new Time(2017,3,20,12,30));
        TimeSpan tsrightborder = new TimeSpan(new Time(2017,3,20,12,40), new Time(2017,3,20,12,50));
        
        assertEquals(null, tsstart.unionWith(tsafter));
        assertEquals(null, tsstart.unionWith(tsbefore));
        assertEquals(10, tsstart.unionWith(tsin).length());
        assertEquals(15, tsstart.unionWith(tsleft).length());
        assertEquals(20, tsstart.unionWith(tsright).length());
        assertEquals(15, tsstart.unionWith(tsleftborder).length());
        assertEquals(20, tsstart.unionWith(tsrightborder).length());
        
        System.out.println(t1);

        
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("Test intersectionWith");        
        TimeSpan tsstart = new TimeSpan(new Time(2017,3,20,12,30), new Time(2017,3,20,12,40));
        
        TimeSpan tsafter = new TimeSpan(new Time(2017,3,20,12,41), new Time(2017,3,20,12,50));
        TimeSpan tsbefore = new TimeSpan(new Time(2017,3,20,12,20), new Time(2017,3,20,12,29));
        TimeSpan tsin = new TimeSpan(new Time(2017,3,20,12,31), new Time(2017,3,20,12,35));
        TimeSpan tsleft = new TimeSpan(new Time(2017,3,20,12,25), new Time(2017,3,20,12,35));
        TimeSpan tsright = new TimeSpan(new Time(2017,3,20,12,35), new Time(2017,3,20,12,50));
        TimeSpan tsleftborder = new TimeSpan(new Time(2017,3,20,12,25), new Time(2017,3,20,12,30));
        TimeSpan tsrightborder = new TimeSpan(new Time(2017,3,20,12,40), new Time(2017,3,20,12,50));
        
        
        assertEquals(null, tsstart.intersectionWith(tsafter));
        assertEquals(null, tsstart.intersectionWith(tsbefore));
        assertEquals(null, tsstart.intersectionWith(tsleftborder));
        assertEquals(null, tsstart.intersectionWith(tsrightborder));
        assertEquals(4, tsstart.intersectionWith(tsin).length());
        assertEquals(5, tsstart.intersectionWith(tsleft).length());
        assertEquals(5, tsstart.intersectionWith(tsright).length());
    }
    
}
