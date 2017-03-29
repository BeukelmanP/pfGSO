/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.GregorianCalendar;

/**
 *
 * @author Frank Peeters, Nico Kuijpers
 *
 * LET OP: De klasse Time bevat enkele fouten.
 *
 */
public class Time implements ITime {

    private GregorianCalendar gc;

    /**
     * creation of a time-object with year y, month m, day d, hours h and
     * minutes m; if the combination of y-m-d refers to a non-existing date the
     * value of this Time-object will be not guaranteed
     *
     * @param y
     * @param m 1â‰¤mâ‰¤12
     * @param d 1â‰¤dâ‰¤31
     * @param h 0â‰¤hâ‰¤23
     * @param min 0â‰¤mâ‰¤59
     */
    public Time(int y, int m, int d, int h, int min) {
        if (m < 1 || m > 12) {
            throw new IllegalArgumentException("month must be within 1..12");
        }
        if (d < 1 || d > 31) {
            throw new IllegalArgumentException("day must be within 1..31");
        }
        if (h < 0 || h > 23) {
            throw new IllegalArgumentException("hours must be within 0..23");
        }
        if (min < 0 || min > 59) {
            throw new IllegalArgumentException("minutes must be within 0..59");
        }

        gc = new GregorianCalendar(y, m - 1, d, h, min);
    }

    Time(Time t) {
        gc = (GregorianCalendar) t.gc.clone();
    }

    @Override
    public DayInWeek getDayInWeek() {
        int day_of_week = gc.get(GregorianCalendar.DAY_OF_WEEK);
        switch (day_of_week) {
            case GregorianCalendar.SUNDAY:
                return DayInWeek.SUN;
            case GregorianCalendar.MONDAY:
                return DayInWeek.MON;
            case GregorianCalendar.TUESDAY:
                return DayInWeek.TUE;
            case GregorianCalendar.WEDNESDAY:
                return DayInWeek.WED;
            case GregorianCalendar.THURSDAY:
                return DayInWeek.THU;
            case GregorianCalendar.FRIDAY:
                return DayInWeek.FRI;
            case GregorianCalendar.SATURDAY:
                return DayInWeek.SAT;
            default:
                return null;
        }
    }

    @Override
    public int getYear() {
        return gc.get(GregorianCalendar.YEAR);
    }

    @Override
    public int getMonth() {
        return gc.get(GregorianCalendar.MONTH) + 1;
    }

    @Override
    public int getDay() {
        return gc.get(GregorianCalendar.DAY_OF_MONTH);
    }

    @Override
    public int getHours() {
        return gc.get(GregorianCalendar.HOUR_OF_DAY);
    }

    @Override
    public int getMinutes() {
        return gc.get(GregorianCalendar.MINUTE);
    }

    @Override
    public ITime plus(int minutes) {
        Time time = new Time(this);
        time.gc.add(GregorianCalendar.MINUTE, minutes);
        return time;
    }

    @Override
    public int compareTo(ITime t) {
        Time time = (Time) t;
        return time.gc.compareTo(gc);
    }

    @Override
    public int difference(ITime time) {
        Time t = (Time) time;
        return (int) ((this.gc.getTimeInMillis() - t.gc.getTimeInMillis()) / 60000);
    }
}
