/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author frederick
 */
public class AppointmentTest {
    
    Appointment apt1;
    
    public AppointmentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        apt1 = new Appointment("Doctors afspraak", new TimeSpan(new Time(2017,2,1,12,30), new Time(2017,2,1,12,40)));
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
        assertEquals(true,apt1.addContact(new Contact("Doctor")));
        
        apt1.addContact(new Contact("Ham Speklap"));
        assertEquals(apt1.getInvitees().size(),2);
        
        assertEquals(false,apt1.addContact(new Contact("Ham Speklap")));
    }
    
    @Test
    public void removeContact(){
        apt1.addContact(new Contact("Doctor"));
        assertEquals(apt1.getInvitees().size(),1);
        
        apt1.removeContact(new Contact("Doctor"));
        assertEquals(apt1.getInvitees().size(),0);
        
        apt1.removeContact(new Contact("Doctor"));
        assertEquals(apt1.getInvitees().size(),0);
    }
}
