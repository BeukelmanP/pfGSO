package fontys.time;

/**
 * A stretch of time with a begin time and end time.
 * The end time is always later than the begin time; the length of the time span is
 * always positive
 * 
 * 
 * WARNING: length of time span should be smaller than Integer.MAXINT; this restriction
 * will never be checked
 * 
 * @author Frank Peeters, Nico Kuijpers
 */
public interface ITimeSpan {

    /**
     * 
     * @return the begin time of this time span
     */
    ITime getBeginTime();

    /**
     * 
     * @return the end time of this time span
     */
    ITime getEndTime();

    /**
     * 
     * @return the length of this time span expressed in minutes (always positive)
     */
    int length();

    /**
     * beginTime will be the new begin time of this time span
     * @param beginTime must be earlier than the current end time
     * of this time span
     */
    void setBeginTime(ITime beginTime);

    /**
     * endTime will be the new end time of this time span
     * @param endTime must be later than the current begin time
     * of this time span
     */
    void setEndTime(ITime endTime);

    /**
     * the begin and end time of this time span will be moved up both with [minutes]
     * minutes
     * @param minutes (a negative value is allowed)
     */
    void move(int minutes);

    /**
     * the end time of this time span will be moved up with [minutes] minutes
     * @param minutes  minutes + length of this period must be positive  
     */
    void changeLengthWith(int minutes);

    /**
     * 
     * @param timeSpan
     * @return true if all moments within this time span are included within [timeSpan], 
     * otherwise false
     */
    boolean isPartOf(ITimeSpan timeSpan);

    /**
     * 
     * @param timeSpan
     * @return if this time span and [timeSpan] are consecutive or possess a
     * common intersection, then the smallest time span ts will be returned, 
     * whereby this time span and [timeSpan] are part of ts, 
     * otherwise null will be returned 
     */
    ITimeSpan unionWith(ITimeSpan timeSpan);

    /**
     * 
     * @param timeSpan
     * @return the largest time span which is part of this time span 
     * and [timeSpan] will be returned; if the intersection is empty null will 
     * be returned
     */
    ITimeSpan intersectionWith(ITimeSpan timeSpan);
}
