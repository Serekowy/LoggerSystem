import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LoggerSystem loggerSystem = new LoggerSystem();

        loggerSystem.addUser(new User("Basic", AccessType.BASIC));
        loggerSystem.addUser(new User("Basic1", AccessType.BASIC));
        loggerSystem.addUser(new User("Admin",AccessType.ADMIN));
        loggerSystem.addUser(new User("Admin1",AccessType.ADMIN));
        loggerSystem.addUser(new User("Owner", AccessType.OWNER));
        loggerSystem.addUser(new User("Owner1", AccessType.OWNER));

        loggerSystem.addLog(new LogSystem("Basic", getActualTime(), "Pierwszy log", "text"));
        loggerSystem.addLog(new LogSystem("Basic", getActualTime(), "Drugi log", "text"));
        loggerSystem.addLog(new LogSystem("Basic", getActualTime(), "Trzeci log", "text"));
        loggerSystem.addLog(new LogSystem("Basic", getActualTime(), "Czwarty log", "text"));

        loggerSystem.removeLog(0, "Admin");

        ArrayList<LogSystem> logs = loggerSystem.getLogsForUser("Basic");

        int i = 1;

        if(!logs.isEmpty()) {
            for(LogSystem log : logs) {
                System.out.println(i + ". ");
                i++;
                log.showLog();
            }
        }



//        for(String user : loggerSystem.getUsers())
//        {
//            System.out.println(user);
//        }

//        coś takiego, tworzenie loga
//        loggerSystem.addLog(new Log());

//        System.out.println();
//
//        System.out.println("Liczba logów");
//        System.out.println(loggerSystem.getLogs().size());
//        System.out.println("Liczba logów usuniętych");
//        System.out.println(loggerSystem.getDeletedLogs().size());
//        System.out.println("Liczba logów po usunięciu");
//        loggerSystem.removeLog(loggerSystem.getLogs(), 0);
//        System.out.println(loggerSystem.getLogs().size());
//        System.out.println("Liczba logów usuniętych po usunięciu");
//        System.out.println(loggerSystem.getDeletedLogs().size());
//
//        System.out.println();
//        nie mozna przekazywac obiektu
//        AccessManage AccessManage = new AccessManage();
//
//        AccessManage.checkAccess(0, 0, loggerSystem);
//        AccessManage.checkAccess(0, 1, loggerSystem);
//        AccessManage.checkAccess(0, 2, loggerSystem);
//        System.out.println("-----------------------------------");
//        AccessManage.checkAccess(1, 0, loggerSystem);
//        AccessManage.checkAccess(1, 1, loggerSystem);
//        AccessManage.checkAccess(1, 2, loggerSystem);
//        System.out.println("-----------------------------------");
//        AccessManage.checkAccess(2, 0, loggerSystem);
//        AccessManage.checkAccess(2, 1, loggerSystem);
//        AccessManage.checkAccess(2, 2, loggerSystem);

    }

    public static String getActualTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
