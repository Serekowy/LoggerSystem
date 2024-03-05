import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LoggerSystem {

    private final ArrayList<LogSystem> allLogs;
    private final ArrayList<LogSystem> deletedLogs;
    private final Set<User> users;

    public LoggerSystem() {
        this.allLogs = new ArrayList<>();
        this.deletedLogs = new ArrayList<>();
        this.users = new HashSet<>();
    }

    public void addLog(LogSystem log) {
        allLogs.add(log);
    }

    public void removeLog(LogSystem log, User user) {
        //sprawdzenie czy uzytkownik moze usunac tego loga
        String logOwner = log.getCreator();
        String username = user.getUsername();

        if (checkLogExist(log)) {
            System.out.println("Log nie istnieje");
        } else if(!logOwner.equals(username)) {
            deletedLogs.add(log);
            allLogs.remove(log);
            System.out.println("Log usunięty pomyślnie.");
        } else {
            AccessManage accessManage = new AccessManage();

            //tu dac sprawdzenie jakby czy ten uztykownik moze loga usunac
        }






        //zrobic sprawdzenie czy istnieje log

        //usunac loga

    }

    public ArrayList<LogSystem> getLogsForUser(String username) { //username jako nazwa zalogowanego użytkownika

        ArrayList<LogSystem> userLogs = new ArrayList<>();

        if (!checkUserExist(username)) {
            System.out.println("Użytkownik " + username + " nie istnieje!");
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
        }

        AccessType checkingUserAccess = AccessType.BASIC;
        AccessType userToCheckAccess = AccessType.BASIC;

        for (User user : users) { //przydalo by sie w funkcje jakos wrzucic, zeby uzyc tego w removeOwnLog
            if (user.getUsername().equals(checkingUser)) {
                checkingUserAccess = user.getAccess();
            } else if (user.getUsername().equals(userToCheck)) {
                userToCheckAccess = user.getAccess();
            }
        }

        if (!checkUserExist(checkingUser) || !checkUserExist(userToCheck)) {
            System.out.println("Użytkownik " + checkingUser + " lub " + userToCheck + " nie istnieje!");
            return new ArrayList<>();
        }

        AccessManage accessManage = new AccessManage();

        if (accessManage.checkAccess(checkingUserAccess, userToCheckAccess)) {
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

    private boolean checkLogExist(Log log) {
        if (allLogs.contains(log)) {
            return true;
        }
        return false;
    }

    private boolean checkUserExist(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
