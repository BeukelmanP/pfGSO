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
public class ContactTest {

    Contact c;

    public ContactTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        c = new Contact("Henk");
    }

    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorfalse1() {
        new Contact("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorfalse2() {
        new Contact(null);
    }

    @Test
    public void testgetName() {
        String name = c.getNaam();
        assertEquals("Henk", name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaddAppointmentfalse() {
        c.addAppointment(null);
    }

    @Test
    public void testaddAppointment() {
        c.addAppointment(new Appointment("Afspraak", new TimeSpan(new Time(2017, 2, 1, 12, 30), new Time(2017, 2, 1, 12, 40))));
        assertEquals(c.getAppointments().size(), 1);

        c.addAppointment(new Appointment("Afspraak", new TimeSpan(new Time(2017, 2, 1, 12, 30), new Time(2017, 2, 1, 12, 40))));
        assertEquals(c.getAppointments().size(), 1);

        c.addAppointment(new Appointment("testAfspraak", new TimeSpan(new Time(2017, 2, 1, 13, 30), new Time(2017, 2, 1, 13, 40))));
        assertEquals(c.getAppointments().size(), 2);

        c.addAppointment(new Appointment("testAfspraak", new TimeSpan(new Time(2017, 2, 1, 13, 38), new Time(2017, 2, 1, 13, 49))));
        assertEquals(c.getAppointments().size(), 3);

    }

    public void testremoveAppointment() {

        c.addAppointment(new Appointment("Afspraak", new TimeSpan(new Time(2017, 2, 1, 12, 30), new Time(2017, 2, 1, 12, 40))));
        assertEquals(c.getAppointments().size(), 1);

        c.addAppointment(new Appointment("testAfspraak", new TimeSpan(new Time(2017, 2, 1, 13, 30), new Time(2017, 2, 1, 13, 40))));
        assertEquals(c.getAppointments().size(), 2);

        c.removeAppointment(new Appointment("Afspraak", new TimeSpan(new Time(2017, 2, 1, 12, 30), new Time(2017, 2, 1, 12, 40))));
        assertEquals(c.getAppointments().size(), 1);

        c.removeAppointment(new Appointment("Afspraak", new TimeSpan(new Time(2017, 2, 1, 12, 30), new Time(2017, 2, 1, 12, 40))));
        assertEquals(c.getAppointments().size(), 1);
    }

    public void testappointments() {
    }

}
