import java.util.Date;

public abstract class Tweet implements Tweetable{
    Date date;
    String message;

    Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public abstract boolean isImportant();
}
