/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author Administrator
 */
public class Appointment {
    
    /**
     * Properties
     * 
     * 1 subject van het type String, mag een empty String zijn.
     * 1 TimeSpan van het type ITimeSpan.
     * 0..* invitees van het type Contact
     */
    
    /**
     * Constructor
     *  
     * Constructor1 :
     * parm Subject van het type String, mag een empty String zijn.
     * parm timeSpan van het type ITimeSpan, timeSpan mag niet in het verleden liggen.
     */
    
    /**
     * Get/Set
     * 
     * getSubject returns the subject of type String
     * getTimeSpan returns the timespan of the appointment of type ITimeSpan
     */
    
    /**
     * Method
     * 
     * invitees returns a iterator of all contacts for this appointment.
     */
    
    /**
     * Method
     * 
     * addContact
     * parm contact of type contact
     * 
     * adds the contact if the contact isnt already added to this appointment.
     * if the contact is already in the invitees list return false otherwise return true
     */
    
    /**
     * Method
     * 
     * removeContact
     * parm contact of type contact
     * 
     * if the contact is in the list of invitees for this appointment remove it
     * if the contact cannot be found in the list of invitees do nothing.
     */
    
    @Override
    public boolean equals(Object obj){
        Appointment apt1 = (Appointment)obj;
        
        if(apt1.timeSpan == this.timeSpan)
        {
            return true;
        }
        
        return false;
    }
    
}
