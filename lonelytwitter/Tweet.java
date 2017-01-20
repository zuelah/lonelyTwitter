package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kathy on 2017-01-20.
 */

public abstract class Tweet {
    private String message;
    private Date date;
    private ArrayList<CurrentMood> moods;

    public ArrayList<CurrentMood> getMoods(){
        return moods;
    }
    public void setMoods(ArrayList<CurrentMood> moods){
        this.moods = moods;
    }
}
//Wasn't able to copy the work done in the lab section due to
//problems with Android studios, so I remade what I could
//from memory and just followed the exercise.