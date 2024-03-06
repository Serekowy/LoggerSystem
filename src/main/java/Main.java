import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LoggerSystem loggerSystem = new LoggerSystem();

        loggerSystem.addUser(new User("Basic", AccessType.BASIC));
        loggerSystem.addUser(new User("Basic1", AccessType.BASIC));
        loggerSystem.addUser(new User("Admin", AccessType.ADMIN));
        loggerSystem.addUser(new User("Admin1", AccessType.ADMIN));
        loggerSystem.addUser(new User("Owner", AccessType.OWNER));
        loggerSystem.addUser(new User("Owner1", AccessType.OWNER));

        loggerSystem.addLog(new LogSystem("Basic", getActualTime(), "Pierwszy log", "text"));
        loggerSystem.addLog(new LogSystem("Basic", getActualTime(), "Drugi log", "text"));
        loggerSystem.addLog(new LogSystem("Basic", getActualTime(), "Trzeci log", "text"));
        loggerSystem.addLog(new LogSystem("Basic", getActualTime(), "Czwarty log", "text"));
        loggerSystem.addLog(new LogSystem("Admin", getActualTime(), "Pierwszy log admin", "text"));

        loggerSystem.removeOwnLog("Owner", 0);
        loggerSystem.removeUserLog("Admin", "Owner", 0);

        ArrayList<LogSystem> logs = loggerSystem.getUserLogs("Basic");
        System.out.println("Basic wyświetla wszystkie swoje logi");
        showLogs(logs);
        System.out.println("Logi po usunięciu swojego loga przez Basic");
        loggerSystem.removeOwnLog("Basic", 0);
        showLogs(logs);
        System.out.println("Usunięty log i wyświetlone logi użytkownika Basic przez Admin");
        loggerSystem.removeUserLog("Admin", "Basic", 0);
        logs = loggerSystem.getUserLogs("Admin", "Basic");
        showLogs(logs);

//        loggerSystem.showUserLogs("Basi");
//        loggerSystem.showUsers();
//        loggerSystem.showUsers();
//        loggerSystem.showDeletedLogs();
    }

    public static void showLogs(ArrayList<LogSystem> logs) {
        int i = 1;
        if (!logs.isEmpty()) {
            for (LogSystem log : logs) {
                System.out.println(i + ". ");
                i++;
                log.showLog();
            }
        }
    }

    public static String getActualTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
