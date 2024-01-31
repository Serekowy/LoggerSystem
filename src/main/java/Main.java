import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        User basic = new User("Test", AccessType.BASIC);
        Log log1 = new Log(getActualTime(), basic.getUsername(), "utworzono użytkownika", "text");
        Log log2 = new Log(getActualTime(), basic.getUsername(), "utworzono log", "text");
        LoggerSystem loggerSystem = new LoggerSystem();

//        loggerSystem.basic.getUsername();

    }
    public static String getActualTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
