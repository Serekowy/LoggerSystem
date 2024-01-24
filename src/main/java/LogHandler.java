import java.util.ArrayList;
import java.util.List;

public class LogHandler {
    private String timestamp;
    private String creator;
    private String logText;
    private String logType;
    private List<Log> allLogs = new ArrayList<Log>();
    private List<Log> deletedLogs = new ArrayList<Log>();

    public LogHandler(String timestamp, String creator, String logText, String logType) {
        this.timestamp = timestamp;
        this.creator = creator;
        this.logText = logText;
        this.logType = logType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getCreator() {
        return creator;
    }

    public String getLogText() {
        return logText;
    }

    public String getLogType() {
        return logType;
    }

    public List<Log> getLogList() {
        return allLogs;
    }

    public List<Log> getDeletedLogs() {
        return deletedLogs;
    }

    public void addLogToList(Log newLog) {
        allLogs.add(newLog);
    }
    public void deleteLogFromList(Log logToDelete) {
        allLogs.remove(logToDelete);
        deletedLogs.add(logToDelete);
    }
}
