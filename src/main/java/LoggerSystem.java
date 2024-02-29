import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LoggerSystem  {

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

    public void removeOwnLog(Log log, User user) {
        //sprawdzenie czy uzytkownik moze usunac tego loga

        //zrobic sprawdzenie czy istnieje log

        //usunac loga

    }
    public ArrayList<LogSystem> getLogsForUser(String username) {

        ArrayList<LogSystem> userLogs = new ArrayList<>();

        for(LogSystem log : allLogs ) {
            if(log.getCreator().equals(username)) {
                userLogs.add(log);
            }
        }

        return userLogs;
    }

    public ArrayList<LogSystem> getUserLogs(String checkingUser, String userToCheck) {
        //dodac sprawdzanie czy uzytkownik istnieje to samo w getlogsforuser

        if(checkingUser.equals(userToCheck)) {
            System.out.println("Aby sprawdzić swoje logi użyj metody getLogsForUser()");
            return new ArrayList<>();
        }

        AccessType checkingUserAccess = AccessType.BASIC;
        AccessType userToCheckAccess = AccessType.BASIC;

        for(User user : users) {
            if(user.getUsername().equals(checkingUser)) {
                checkingUserAccess = user.getAccess();
            } else if (user.getUsername().equals(userToCheck)) {
                userToCheckAccess = user.getAccess();
            }
        }

        AccessManage accessManage = new AccessManage();

        if(accessManage.checkAccess(checkingUserAccess, userToCheckAccess)) {
            return getLogsForUser(userToCheck);
        }

        return new ArrayList<>();
    }

    public boolean addUser(User user) {// ogarnac co z tym zrobic
        String newUser  = user.getUsername();
        for(User username : users) {
            if(username.getUsername().equals(newUser)) {
                System.out.println("Użytkownik o takiej nazwie już istnieje");
                return false;
            }
        }
        users.add(user);
        System.out.println("Użytkownik został dodany");
        return true;
    }
}
