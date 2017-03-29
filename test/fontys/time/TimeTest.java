/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author piete
 */
public class TimeTest {

    Time t;
    Time t2;
    Time t3;

    public TimeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        t = new Time(2017, 3, 20, 20, 31);
        t2 = new Time(2017, 3, 20, 19, 31);
        t3 = new Time(2017, 3, 20, 20, 36);
    }

    @After
    public void tearDown() {
    }

    
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testConstructTimeMonthExeption()
    {
        System.out.println("Test method: getDayInWeekConstructor Exeption Month \n");
     Time t4 = new Time(2017,13,20,20,31);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testConstructTimeDayExeption()
    {
        System.out.println("Test method: getDayInWeekConstructor Exeption Day \n");
     Time t4 = new Time(2017,3,32,20,31);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testConstructTimeHourExeption()
    {
        System.out.println("Test method: getDayInWeekConstructor Exeption Hour \n");
     Time t4 = new Time(2017,3,20,25,31);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testConstructTimeMinuteExeption()
    {
     System.out.println("Test method: getDayInWeekConstructor Exeption Minute \n");
     Time t4 = new Time(2017,3,20,20,60);
    }
    
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testConstructTimeMonthExeption2()
    {
        System.out.println("Test method: getDayInWeekConstructor Exeption Month \n");
     Time t4 = new Time(2017,0,20,20,31);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testConstructTimeDayExeption2()
    {
        System.out.println("Test method: getDayInWeekConstructor Exeption Day \n");
     Time t4 = new Time(2017,3,0,20,31);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testConstructTimeHourExeption2()
    {
        System.out.println("Test method: getDayInWeekConstructor Exeption Hour \n");
     Time t4 = new Time(2017,3,20,-1,31);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testConstructTimeMinuteExeption2()
    {
     System.out.println("Test method: getDayInWeekConstructor Exeption Minute \n");
     Time t4 = new Time(2017,3,20,20,-1);
    }
    /**
     * Test of getDayInWeek method, of class Time.
     */
    @Test
    public void testGetDayInWeek() {
        //@return the concerning day in the week of this time
        System.out.println("Test method: getDayInWeek");

        Time dayTest = new Time(2017, 3, 13, 20, 31);
        DayInWeek expResult = DayInWeek.MON;
        DayInWeek result = dayTest.getDayInWeek();
        System.out.println("Expected: " + expResult.toString() + " Actual: " + result.toString() + " \n ");
        assertEquals(expResult, result);
        
        dayTest = new Time(2017, 3, 14, 20, 31);
        expResult = DayInWeek.TUE;
        result = dayTest.getDayInWeek();
        System.out.println("Expected: " + expResult.toString() + " Actual: " + result.toString() + " \n ");
        assertEquals(expResult, result);
        
        dayTest = new Time(2017, 3, 15, 20, 31);
        expResult = DayInWeek.WED;
        result = dayTest.getDayInWeek();
        System.out.println("Expected: " + expResult.toString() + " Actual: " + result.toString() + " \n ");
        assertEquals(expResult, result);

        dayTest = new Time(2017, 3, 16, 20, 31);
        expResult = DayInWeek.THU;
        result = dayTest.getDayInWeek();
        System.out.println("Expected: " + expResult.toString() + " Actual: " + result.toString() + " \n ");
        assertEquals(expResult, result);
        
        dayTest = new Time(2017, 3, 17, 20, 31);
        expResult = DayInWeek.FRI;
        result = dayTest.getDayInWeek();
        System.out.println("Expected: " + expResult.toString() + " Actual: " + result.toString() + " \n ");
        assertEquals(expResult, result);
        
        dayTest = new Time(2017, 3, 18, 20, 31);
        expResult = DayInWeek.SAT;
        result = dayTest.getDayInWeek();
        System.out.println("Expected: " + expResult.toString() + " Actual: " + result.toString() + " \n ");
        assertEquals(expResult, result);
        
        dayTest = new Time(2017, 3, 19, 20, 31);
        expResult = DayInWeek.SUN;
        result = dayTest.getDayInWeek();
        System.out.println("Expected: " + expResult.toString() + " Actual: " + result.toString() + " \n ");
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getYear method, of class Time.
     */
    @Test
    public void testGetYear() {
        //* @return the concerning year of this time
        System.out.println("Test method: getYear");
        int expResult = 2017;
        int result = t.getYear();
        System.out.println("Expected: " + expResult + " Actual: " + result + " \n ");
        assertEquals(expResult, result);

    }

    /**
     * Test of getMonth method, of class Time.
     */
    @Test
    public void testGetMonth() {
        //@return the number of the month of this time (1..12)
        System.out.println("Test method: getMonth");
        int expResult =3 ;
        int result = t.getMonth();
        System.out.println("Expected: " + expResult + " Actual: " + result + " \n ");
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class Time.
     */
    @Test
    public void testGetDay() {
        //@return the number of the day in the month of this time (1..31)
        System.out.println("Test method: getDay");
        int expResult = 20;
        int result = t.getDay();
        System.out.println("Expected: " + expResult + " Actual: " + result + " \n ");
        assertEquals(expResult, result);
    }

    /**
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        //@return the number of hours in a day of this time (0..23)
        System.out.println("Test method: getHours");
        int expResult = 20;
        int result = t.getHours();
        System.out.println("Expected: " + expResult + " Actual: " + result + " \n ");
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        //@return the number of minutes in a hour of this time (0..59)
        System.out.println("Test method: getMinutes");
        int expResult = 31;
        int result = t.getMinutes();
        System.out.println("Expected: " + expResult + " Actual: " + result + " \n ");
        assertEquals(expResult, result);
    }

    /**
     * Test of plus method, of class Time.
     */
    @Test
    public void testPlus() {
        System.out.println("Test method: plus");
        int minutes = 5;
        int expResult = t3.getMinutes();
        t = (Time) t.plus(minutes);
        int result = t.getMinutes();
        System.out.println("Expected: " + expResult + " Actual: " + result + " \n ");
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("Test method: compareTo");
        //Compares this object with the specified object for order.  Returns a
        //negative integer, zero, or a positive integer as this object is less
        //than, equal to, or greater than the specified object.
        int expResult = -1;
        int result = t.compareTo(t2);
        System.out.println("Expected: " + expResult + " Actual: " + result + " \n ");
        assertEquals(expResult, result);
    }

    /**
     * Test of difference method, of class Time.
     */
    @Test
    public void testDifference() {
        System.out.println("Test method: difference");
        //the difference between this time and [time] expressed in minutes
        int expResult = 60;
        int result = t.difference(t2);
        System.out.println("Expected: " + expResult + " Actual: " + result + " \n ");
        assertEquals(expResult, result);
    }

}
