/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frederick
 */
public class Appointment {

    /**
     * Properties
     *
     * 1 subject van het type String, mag een empty String zijn. 1 TimeSpan van
     * het type ITimeSpan. 0..* invitees van het type Contact
     */
    private String subject;
    private ITimeSpan timeSpan;
    private List<Contact> invitees;

    /**
     * Constructor
     *
     * Constructor1 : parm Subject van het type String, mag een empty String
     * zijn. parm timeSpan van het type ITimeSpan, timeSpan mag niet in het
     * verleden liggen.
     */
    public Appointment(String subject, ITimeSpan timeSpan) {
        boolean past = false;
        int year = LocalDateTime.now().getYear();
        int month = LocalDateTime.now().getMonthValue();
        int dayofm =LocalDateTime.now().getDayOfMonth();
        int hour = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();
        int a = timeSpan.getBeginTime().compareTo(new Time(year,month,dayofm,hour,minute));
        if(a==-1)
        {
            past = true;
        }
        if (subject == "" || past) {
            throw new IllegalArgumentException();
        } else {
            this.subject = subject;
            this.timeSpan = timeSpan;
            invitees = new ArrayList<>();
        }
    }

    /**
     * Get/Set
     *
     * getSubject returns the subject of type String getTimeSpan returns the
     * timespan of the appointment of type ITimeSpan
     */
    public String getSubject() {
        return subject;
    }

    public ITimeSpan getTimeSpan() {
        return timeSpan;
    }

    /**
     * Method
     *
     * invitees returns a iterator of all contacts for this appointment.
     */
    public List<Contact> getInvitees() {
        return invitees;
    }

    /**
     * Method
     *
     * addContact parm contact of type contact
     *
     * adds the contact if the contact isnt already added to this appointment.
     * if the contact is already in the invitees list return false otherwise
     * return true
     */
    public boolean addContact(Contact contact) {
        boolean found = false;
        for (Contact contact2 : invitees) {
            if (contact2.appointments.equals(contact.appointments) && contact2.getNaam().equals(contact.getNaam())) {
                found = true;
            }
        }
        if (found) {
            return false;
        } else {
            invitees.add(contact);
            return true;
        }
    }

    /**
     * Method
     *
     * removeContact parm contact of type contact
     *
     * if the contact is in the list of invitees for this appointment remove it
     * if the contact cannot be found in the list of invitees do nothing.
     */
    public void removeContact(Contact contact) {
        int removethis = -1;
        int i = 0;
        for (Contact contact2 : invitees) {
            if (contact2.appointments.equals(contact.appointments) && contact2.getNaam().equals(contact.getNaam())) {
                removethis = i;
            }
            i++;
        }
        if (removethis >= 0) {
            invitees.remove(removethis);
        }
    }

    @Override
    public boolean equals(Object obj) {
        Appointment apt1 = (Appointment) obj;

        if (apt1.timeSpan.equals(this.timeSpan) && apt1.getSubject() == getSubject()) {
            return true;
        }

        return false;
    }

}
