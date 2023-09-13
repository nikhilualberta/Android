import java.util.Date;
public class ImportantTweet extends Tweet {
    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(Date date, String message) {
        super(message, date);
    }
    @Override
    public boolean isImportant() {
        return  Boolean.TRUE;
    };

}
