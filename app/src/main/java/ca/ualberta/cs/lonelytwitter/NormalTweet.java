package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This is type NormalTweet
 * It extends the type Tweet, with the addition of the bool isImportant being false
 * @author Shida
 * @see Tweet
 * @see ImportantTweet
 * @version 1.0
 */

public class NormalTweet extends Tweet {
    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportant(){
        return false;
    }
}
