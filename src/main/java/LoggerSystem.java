import java.util.ArrayList;

public class LoggerSystem  {

    private ArrayList<Log> allLogs;
    private ArrayList<Log> deletedLogs;

    public LoggerSystem() {
        this.allLogs = new ArrayList<>();
        this.deletedLogs = new ArrayList<>();
    }

    public void create(Log log) {
        allLogs.add(log);
    }

    public void remove(Log log) {
        deletedLogs.add(log);
        allLogs.remove(log);
    }

    public ArrayList<Log> getLogs() {
        return allLogs;
    }

    public ArrayList<Log> getDeletedLogs() {
        return deletedLogs;
    }
}
