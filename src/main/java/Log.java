import java.util.ArrayList;

public class Log extends LogHandler {

    public Log(String creator) {
        super(creator);
    }

    public void showLog() {
        System.out.println("Użytkownik: " + getCreator() + "\nTreść: " + getLogText());
    }
}
