public class Log extends LogHandler {

    public Log(String timestamp, String creator, String logText, String logType) {
        super(timestamp, creator, logText, logType);
    }

    public void showLog() {
        System.out.println("Użytkownik: " + getCreator() + "\nTreść: " + getLogText());
    }
}
