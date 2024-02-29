public class Log {
    private final String timestamp;
    private final String creator;
    private final String logText;
    private final String logType;

    public Log(String creator) {
        this.timestamp = "now";
        this.creator = creator;
        this.logText = "przykładowy tekst";
        this.logType = "text";
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
