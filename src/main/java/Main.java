import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        User basic = new User("Basic", AccessType.BASIC);
        User admin = new User("Admin", AccessType.ADMIN);
        User owner = new User("Owner", AccessType.OWNER);

        LogSystem log1 = new LogSystem("basic");


        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.createLog(new LogSystem("ziom")); //dodanie nowego loga

        UserManager user1 = loggerSystem.addUser("Basic", AccessType.BASIC);

        System.out.println(loggerSystem.getLogs().get(0).getCreator());

        loggerSystem.removeLog(log1);

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
