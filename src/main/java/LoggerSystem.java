import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LoggerSystem {

    private final ArrayList<LogSystem> allLogs;
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

    public void removeLog(String userDeletingLog, String userToDeleteLog, int logNumber) {
        ArrayList<LogSystem> userLogs;
        LogSystem log;

        if (userToDeleteLog.isEmpty() && checkUserExist(userDeletingLog)) {
            userLogs = getUserLogs(userDeletingLog, "");
            if (logNumber < userLogs.size() && logNumber >= 0) {
                log = userLogs.get(logNumber);
                String logOwner = log.getCreator();
                AccessType access = checkUserAccess(userDeletingLog);

                if (logOwner.equals(userDeletingLog) && accessManage.checkLogAccess(access)) {
                    finalRemoveLog(log);
                }
            }
        } else {
            userLogs = getUserLogs(userDeletingLog, userToDeleteLog);
            if (logNumber < userLogs.size() && logNumber >= 0) {
                log = userLogs.get(logNumber);
                finalRemoveLog(log);
            }
        }
    }

    public ArrayList<LogSystem> getUserLogs(String checkingUser, String userToCheck) {

        if (checkUserExist(checkingUser) && userToCheck.isEmpty()) {
            if (accessManage.checkLogAccess(checkUserAccess(checkingUser))) {
                return getLogs(checkingUser);
            }
        }

        if (!checkingUser.isEmpty() && !userToCheck.isEmpty()) {
            if (checkUserExist(checkingUser) && checkUserExist(userToCheck)) {
                if (accessManage.checkAccess(checkUserAccess(checkingUser), checkUserAccess(userToCheck))) {
                    return getLogs(userToCheck);
                }
            } else {
                System.out.println("Użytkownik " + checkingUser + " lub " + userToCheck + " nie istnieje!");
            }
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
        return users.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    private AccessType checkUserAccess(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user.getAccess();
            }
        }
        return AccessType.BASIC;
    }

    private ArrayList<LogSystem> getLogs(String username) {
        ArrayList<LogSystem> userLogs = new ArrayList<>();
        for (LogSystem log : allLogs) {
            if (log.getCreator().equals(username)) {
                userLogs.add(log);
            }
        }
        return userLogs;
    }

    private void finalRemoveLog(LogSystem log) {
        deletedLogs.add(log);
        allLogs.remove(log);
        System.out.println("Log usunięty pomyślnie.");
    }
}
