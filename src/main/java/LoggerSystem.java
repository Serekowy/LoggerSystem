import java.util.ArrayList;

public class LoggerSystem  {

    private ArrayList<LogSystem> allLogs;
    private ArrayList<LogSystem> deletedLogs;

    UserManager user;

    public LoggerSystem() {
        this.allLogs = new ArrayList<>();
        this.deletedLogs = new ArrayList<>();
    }

    public void createLog(LogSystem log) {
        allLogs.add(log);
    }

    public void removeLog(LogSystem log) {
        deletedLogs.add(log);
        allLogs.remove(log);
    }
    public UserManager addUser(String username, AccessType access) {
        UserManager user = new UserManager(username, access);
        user.addUser(user);
        return user;
    }

    public ArrayList<LogSystem> getLogs() {
        return allLogs;
    }

    public ArrayList<LogSystem> getDeletedLogs() {
        return deletedLogs;
    }
}
