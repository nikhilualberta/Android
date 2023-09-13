import java.util.Date;

public class HappyMood extends CurrentMood {
    public HappyMood() {
        super();
    }

    public HappyMood(Date date) {
        super(date);
    }

    @Override
    public String getMood() {
        return "I am happy";
    }

}
