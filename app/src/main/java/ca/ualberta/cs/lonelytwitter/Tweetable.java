package ca.ualberta.cs.lonelytwitter;

/**
 * This interface is implemented by the class Tweet
 * Includes getter and setter methods for the Tweets
 * @author Shida
 * @see Tweet
 * @version 1.0
 */

public interface Tweetable {
    public String getMessage();
    public void setMessage(String string) throws TweetTooLongException;
}
