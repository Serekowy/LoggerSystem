import java.util.List;

public class Log extends LogHandler {

    public Log(String timestamp, String creator, String logText, String logType) {
        super(timestamp, creator, logText, logType);
    }

    public void listLogs(String userType) {
        List<Log> logs = getLogList();

        if (userType.equals("BASIC")) {

        } else if (userType.equals("ADMIN")) {

        } else if (userType.equals("OWNER")) {

        }
    }

    public void addLog(Log log) {
        addLogToList(log);
    }

    public void removeLog(Log log) {
        deleteLogFromList(log);
    }


}
