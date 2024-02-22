import java.util.ArrayList;

public class LoggerSystem  {

    private ArrayList<LogSystem> allLogs;
    private ArrayList<LogSystem> deletedLogs;
    private ArrayList<User> users;

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

    public ArrayList<LogSystem> getLogs() {
        return allLogs;
    }

    public ArrayList<LogSystem> getDeletedLogs() {
        return deletedLogs;
    }

    public void addUser(String username, AccessType access) {
        User user = new User(username, access);
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
