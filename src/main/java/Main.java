public class Main {
    public static void main(String[] args) {
        LoggerSystem loggerSystem = new LoggerSystem();

        loggerSystem.addUser("Basic", AccessType.BASIC);
        loggerSystem.addUser("Admin", AccessType.ADMIN);
        loggerSystem.addUser("Owner", AccessType.OWNER);

        for (int i = 0; i < loggerSystem.getUsers().size(); i++) {
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

        System.out.println();

        checkAccess(0, 0, loggerSystem);
        checkAccess(0, 1, loggerSystem);
        checkAccess(0, 2, loggerSystem);
        System.out.println("-----------------------------------");
        checkAccess(1, 0, loggerSystem);
        checkAccess(1, 1, loggerSystem);
        checkAccess(1, 2, loggerSystem);
        System.out.println("-----------------------------------");
        checkAccess(2, 0, loggerSystem);
        checkAccess(2, 1, loggerSystem);
        checkAccess(2, 2, loggerSystem);


    }

    public static boolean checkAccess(int checkingUserId, int userToCheckId, LoggerSystem loggerSystem) {
        AccessType checkingUserAccess = loggerSystem.getUsers().get(checkingUserId).getAccess();
        AccessType userToCheckAccess = loggerSystem.getUsers().get(userToCheckId).getAccess();

        if (checkingUserAccess.equals(userToCheckAccess)) {
            System.out.println("Brak uprawnień");
            return false;
        } else if (checkingUserAccess.equals(AccessType.BASIC)) {
            System.out.println("Brak uprawnień");
            return false;
        } else if (checkingUserAccess.equals(AccessType.ADMIN) && userToCheckAccess.equals(AccessType.BASIC)) {
            System.out.println("Odpowiednie uprawnienia");
            return true;
        } else if (checkingUserAccess.equals(AccessType.ADMIN) && userToCheckAccess.equals(AccessType.OWNER)) {
            System.out.println("Brak uprawnień");
            return true;
        }else {
            System.out.println("Odpowiednie uprawnienia");
            return true;
        }
    }
}
