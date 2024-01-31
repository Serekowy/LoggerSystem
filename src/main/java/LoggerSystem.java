import java.util.ArrayList;
import java.util.List;

public class LoggerSystem {

    private List<String> allLogs;
    private List<String> deletedLogs;

    public LoggerSystem() {
        this.allLogs = new ArrayList<>();
        this.deletedLogs = new ArrayList<>();
    }

    public void addLogToList(String data) {
        allLogs.add(data);
    }

    public void removeLogFromList(String data) {
        deletedLogs.add(data);
        allLogs.remove(data);
    }

    public List<String> getLogs() {
        return allLogs;
    }

    public List<String> getDeletedLogs() {
        return deletedLogs;
    }
}
