package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Kathy on 2017-01-19.
 */
import java.util.Date;

public abstract class CurrentMood {
    private Date date;
    public CurrentMood(Date inDate){
        date = inDate;
    }
    public CurrentMood(){
        date.setHours(0);
    }

                public void setDate(Date date) {
                this.date = date;
            }

                public Date getDate() {
                return date;
            }

    public abstract String MyMood();
}
