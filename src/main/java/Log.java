public class Log {
    private final String timestamp;
    private final String creator;
    private final String logText;
    private final String logType;

    Log() {
        timestamp = null;
        creator = null;
        logText = null;
        logType = null;
    }
    public Log(String creator, String timestamp, String logText, String logType) {
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

}
