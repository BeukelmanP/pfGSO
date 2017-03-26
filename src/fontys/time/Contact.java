/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author piete
 */
public class Contact {
    
    public String naam;
    public List<Appointment> appointments;
    
    /**
    * Constructor
    *  
    * Constructor1 :
    * Param name of type String, name cannot be null and may not be empty
    */
    
    public Contact(String _naam) {
        
        if(_naam != null || _naam != ""){
            this.naam = naam;
            appointments = new ArrayList<Appointment>();
        }
        else{
            throw new IllegalArgumentException();
        }
        
    }   

    /**
    * Get/Set
    * 
    * getName returns the name of type String
    * appointments returns agenda of the contact
    */
    
    public String getNaam() {
        return naam;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
    
    /**
     * Method
     * 
     * addAppointment
     * Param a of type Appointment, a cannot be null and appointment may not already be in the Agenda.
     * 
     * adds a new appointment to the agenda
     * return false if no appointment was added else return true
     */
    
    public boolean addAppointment(Appointment apt){
        boolean found = false;
        if(apt != null){
           
            for(Appointment apt2 : appointments){
                if(apt2.equals(apt)){
                    found = true;
                }
            }
            
            if(!found){
                appointments.add(apt);
            }
            
        }
        return false;
    }
    
     /**
     * Method
     * 
     * removeAppointment
     * Param a of type Appointment, a cannot be null. 
     * 
     * removes the instance of appointment from agenda
     */
    
    public void removeAppointment(Appointment apt){
        if(apt != null){
            appointments.remove(apt);
        }
    }
}
