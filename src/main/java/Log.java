import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private String timestamp;
    private String creator;
    private String logText;
    private String logType;

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

    public void setTimestamp(String newTimestamp) {
        this.timestamp = newTimestamp;
    }
    public void setCreator(String  newCreator) {
        this.creator = newCreator;
    }
    public void setLogText(String newLogText) {
        this.logText =  newLogText;
    }
    public void setLogType(String newLogType) {
        this.logType = newLogType;
    }
}
