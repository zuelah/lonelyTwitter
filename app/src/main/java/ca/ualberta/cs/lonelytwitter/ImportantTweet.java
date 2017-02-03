package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * The type ImportantTweet
 * This type is an extension of Tweet, with the addition of the bool isImportant being True
 * @Author Shida
 * @see Tweet
 * @see NormalTweet
 * @version 1.0
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportant(){
        return true;
    }
}
