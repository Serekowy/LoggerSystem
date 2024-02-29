import java.util.ArrayList;

public class LoggerSystem  {

    private final ArrayList<LogSystem> allLogs;
    private final ArrayList<LogSystem> deletedLogs;
    private final ArrayList<User> users;

    public LoggerSystem() {
        this.allLogs = new ArrayList<>();
        this.deletedLogs = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void createLog(String username) {
        LogSystem log = new LogSystem(username);
        allLogs.add(log);
    }

    public void removeLog(ArrayList<LogSystem> logs, int index) {
        deletedLogs.add(logs.get(index));
        allLogs.remove(logs.get(index));
    }
//    public void removeLog(LogSystem log) {
//        deletedLogs.add(log);
//        allLogs.remove(log);
//    }

    public void addUser(String username, AccessType access) {
        User user = new User(username, access);
        users.add(user);
    }

    /**
     * public LogSystem getLogForUser(final User user) {
     *     ....
     * }
     */
}
