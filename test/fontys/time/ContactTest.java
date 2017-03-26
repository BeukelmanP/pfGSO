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

    public void testgetName() {
        String name = s.getName();
        assertEquals("Henk", name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaddAppointmentfalse() {
        a.addAppointment(null);
    }

    public void testaddAppointment() {
        
    }

    public void testremoveAppointment() {
    }

    public void testappointments() {
    }

}
