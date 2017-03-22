package fontys.time;

/**
 *
 * a moment on the time line with a precision of one minute
 * 
 * @author Frank Peeters, Nico Kuijpers
 */
public interface ITime extends Comparable<ITime> {
    
    /**
     * 
     * @return the concerning year of this time
     */
    int getYear();
    
    /**
     * 
     * @return the number of the month of this time (1..12)
     */
    int getMonth();
    
    /**
     * 
     * @return the number of the day in the month of this time (1..31)
     */
    int getDay();
    
    /**
     * 
     * @return the number of hours in a day of this time (0..23)
     */
    int getHours();
    
    /**
     * 
     * @return the number of minutes in a hour of this time (0..59)
     */
    int getMinutes();
    
    /**
     * 
     * @return the concerning day in the week of this time
     */
    DayInWeek getDayInWeek();
    
    /**
     * 
     * @param minutes (a negative value is allowed)
     * @return  this time plus minutes
     */
    ITime plus(int minutes);
    
    /**
     * 
     * @param time
     * @return the difference between this time and [time] expressed in minutes
     */
    int difference(ITime time);
    
}
