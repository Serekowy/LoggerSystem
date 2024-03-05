import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LoggerSystem {

    private ArrayList<LogSystem> allLogs;
    private final ArrayList<LogSystem> deletedLogs;
    private final Set<User> users;

    private final AccessManage accessManage = new AccessManage();

    public LoggerSystem() {
        this.allLogs = new ArrayList<>();
        this.deletedLogs = new ArrayList<>();
        this.users = new HashSet<>();
    }

    public void addLog(LogSystem log) {
        allLogs.add(log);
    }

    public void removeLog(int logNumber, String username) {
        ArrayList<LogSystem> userLogs = getLogsForUser(username);
        LogSystem log;

        if (logNumber < userLogs.size()) {
            log = userLogs.get(logNumber);
            String logOwner = log.getCreator();

            if (logOwner.equals(username) && checkUserExist(username)) {
                deletedLogs.add(log);
                allLogs.remove(log);
                System.out.println("Log usunięty pomyślnie.");
            }
        }


//        else if (accessManage.checkAccess(checkUserAccess(username), checkUserAccess(logOwner))) {
//            deletedLogs.add(log);
//            allLogs.remove(log);
//            System.out.println("Log usunięty pomyślnie.");
//        } else {
//            System.out.println("Brak uprawnień do usunięcia loga innego użytkownika.");
//        }
    }

    public ArrayList<LogSystem> getLogsForUser(String username) { //username jako nazwa zalogowanego użytkownika

        ArrayList<LogSystem> userLogs = new ArrayList<>();

        if (!checkUserExist(username)) {
            System.out.println("Użytkownik " + username + " nie istnieje!");
            return new ArrayList<>();
        }

        for (LogSystem log : allLogs) {
            if (log.getCreator().equals(username)) {
                userLogs.add(log);
            }
        }

        return userLogs;
    }

    public ArrayList<LogSystem> getUserLogs(String checkingUser, String userToCheck) {

        if (checkingUser.equals(userToCheck)) {
            System.out.println("Za pomocą tej metody nie można sprawdzić swoich logów, użyj metody getLogsForUser()");
            return new ArrayList<>();
        } else if (!checkUserExist(checkingUser) || !checkUserExist(userToCheck)) {
            System.out.println("Użytkownik " + checkingUser + " lub " + userToCheck + " nie istnieje!");
            return new ArrayList<>();
        }

        if (accessManage.checkAccess(checkUserAccess(checkingUser), checkUserAccess(userToCheck))) {
            return getLogsForUser(userToCheck);
        }

        return new ArrayList<>();
    }

    public boolean addUser(User user) {
        String newUser = user.getUsername();
        for (User username : users) {
            if (username.getUsername().equals(newUser)) {
                System.out.println("Użytkownik o takiej nazwie już istnieje");
                return false;
            }
        }
        users.add(user);
        System.out.println("Użytkownik " + newUser + " został dodany");
        return true;
    }

    private boolean checkUserExist(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private AccessType checkUserAccess(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user.getAccess();
            }
        }
        return AccessType.BASIC;
    }
}
