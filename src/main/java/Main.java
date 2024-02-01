import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        User basic = new User("Basic", AccessType.BASIC);
        User admin = new User("Admin", AccessType.ADMIN);
        User owner = new User("Owner", AccessType.OWNER);

        Log log1 = new Log("basic");

        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.create(new Log("ziom")); //dodanie nowego loga

        System.out.println(loggerSystem.getLogs().get(0).getCreator());

        loggerSystem.remove(log1);

        System.out.println(loggerSystem.getLogs());

        System.out.println("Lista z usuniętymi:");
        System.out.println(loggerSystem.getDeletedLogs());


    }
    public static String getActualTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}
