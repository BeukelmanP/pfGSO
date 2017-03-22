/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author Frank Peeters, Nico Kuijpers
 * 
 * LET OP: De klasse TimeSpan bevat enkele fouten.
 * 
 */
public class TimeSpan2 implements ITimeSpan {

    /* class invariant: 
     * A stretch of time with a begin time and end time.
     * The end time is always later then the begin time; the length of the time span is
     * always positive
     * 
     */
    private ITime bt;
    private long duration;
    
    /**
     * 
     * @param bt must be earlier than et
     * @param et 
     */
    public TimeSpan2(ITime bt, ITime et) {
        if (bt.compareTo(et) <= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }
        this.bt = bt;
        this.duration = et.difference(bt);
    }

    @Override
    public ITime getBeginTime() {
        return bt;
    }

    @Override
    public ITime getEndTime() {
        return bt.plus((int)duration);
    }

    @Override
    public int length() {
        return (int)duration;
    }

    @Override
    public void setBeginTime(ITime beginTime) {
    /*if (beginTime.compareTo(et) <= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }
*/
        bt = beginTime;
    }

    @Override
    public void setEndTime(ITime endTime) {
        if (endTime.compareTo(bt) >= 0) {
            throw new IllegalArgumentException("end time "
                    + endTime + " must be later then begin time " + bt);
        }
        duration = endTime.difference(bt);
        //et = endTime;
    }

    @Override
    public void move(int minutes) {
        bt = bt.plus(minutes);
        
    }

    @Override
    public void changeLengthWith(int minutes) {
        if (minutes <= 0) {
            throw new IllegalArgumentException("length of period must be positive");
        }
        duration = duration + minutes;
    }

    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        return (timeSpan.getBeginTime().compareTo(getBeginTime()) >= 0
                && timeSpan.getEndTime().compareTo(getEndTime()) <= 0) ;
    }

    @Override
    public TimeSpan2 unionWith(ITimeSpan timeSpan) {
        ITime et = bt.plus((int)duration);
        if (bt.compareTo(timeSpan.getEndTime()) < 0 || et.compareTo(timeSpan.getBeginTime()) > 0) {
            return null;
        }
        
        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) < 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) < 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }

        return new TimeSpan2(begintime, endtime);

    }

    @Override
    public TimeSpan2 intersectionWith(ITimeSpan timeSpan) {

        ITime et = bt.plus((int)duration);
        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) < 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }
        if (et.compareTo(timeSpan.getEndTime()) > 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }
        
        if (begintime.compareTo(endtime) <= 0) {
            return null;
        }
        
        return new TimeSpan2(begintime, endtime);
    }
    
    @Override
    public boolean equals(Object obj){
        TimeSpan2 ts = (TimeSpan2)obj;
        if(ts.getBeginTime().equals(this.getBeginTime()) && ts.getEndTime().equals(this.getEndTime())){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "BeginTime:" + getBeginTime()+ "     EndTime" + getEndTime();
    }

}
