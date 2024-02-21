import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LoggerSystem loggerSystem = new LoggerSystem();

        loggerSystem.addUser("Basic", AccessType.BASIC);
        loggerSystem.addUser("Admin", AccessType.ADMIN);
        loggerSystem.addUser("Owner", AccessType.OWNER);

        for(int i = 0; i < loggerSystem.getUsers().size(); i++) {
            loggerSystem.createLog(loggerSystem.getUsers().get(i).getUsername());
            loggerSystem.getLogs().get(i).setLogText("Log " + i);
            loggerSystem.getLogs().get(i).showLog();
        }

        System.out.println();

        System.out.println("Liczba logów");
        System.out.println(loggerSystem.getLogs().size());
        System.out.println("Liczba logów usuniętych");
        System.out.println(loggerSystem.getDeletedLogs().size());
        System.out.println("Liczba logów po usunięciu");
        loggerSystem.removeLog(loggerSystem.getLogs(), 0);
        System.out.println(loggerSystem.getLogs().size());
        System.out.println("Liczba logów usuniętych po usunięciu");
        System.out.println(loggerSystem.getDeletedLogs().size());

        //do zrobienia zarządzanie logami

    }

    public static String getActualTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}
