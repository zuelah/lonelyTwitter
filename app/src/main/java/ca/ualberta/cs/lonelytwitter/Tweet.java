package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This is the Tweet type
 * This abstract class
 * @author Shida
 * @version 1.0
 */
public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;

    /**
     * Instantiates a new Tweet where the date is set to a defualt.
     *
     * @param message the message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet, with the date given
     *
     * @param date    the date
     * @param message the message
     */
    public Tweet(Date date, String message){
        this.message = message;
        this.date = date;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the message in the tweet
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message of the tweet, if it is under 140 characters.
     * If it exceeds this limit it throws a TweetTooLongException
     * @param message the message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Is important boolean.
     * Used in the classes NormalTweet and ImportantTweet
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();

    /**
     * @return Returns both the date and message
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }

}
