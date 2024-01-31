public class LogHandler {
    private String timestamp;
    private String creator;
    private String logText;
    private String logType;

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
}
