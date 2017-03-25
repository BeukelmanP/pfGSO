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
import com.google.common.collect.Lists;

/**
 *
 * @author Administrator
 */
public class AppointmentTest {
    
    Appointment apt1;
    
    public AppointmentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        apt1 = new Appointment("Doctors afspraak", new TimeSpan(new Time(2017,2,1,12,30), new Time(2017,2,1,12,40)));
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void addContactTest(){
        apt1.addContact(new Contact("Doctor"));
        assertEquals(true,apt1.addContact(new Contact("Doctor")));
        
        apt1.addContact(new Contact("Ham Speklap"));
        assertEquals(Lists.newArrayList(apt1.invitees().size()),2);
        
        assertEquals(false,apt1.addContact(new Contact("Ham Speklap")));
    }
    
    @Test
    public void removeContact(){
        apt1.addContact(new Contact("Doctor"));
        assertEquals(Lists.newArrayList(apt1.invitees().size()),1);
        
        apt1.removeContact(new Contact("Doctor"));
        assertEquals(Lists.newArrayList(apt1.invitees().size()),0);
        
        apt1.removeContact(new Contact("Doctor"));
        assertEquals(Lists.newArrayList(apt1.invitees().size()),0);
    }
}
