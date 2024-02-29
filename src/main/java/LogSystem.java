public class LogSystem extends Log {


    LogSystem() {

    }

    public LogSystem(String creator, String timestamp, String logText, String logType) {
        super(creator, timestamp, logText, logType);
    }

    public void showLog() {
        System.out.println(
                "Użytkownik: " + getCreator() +
                "\nTreść: " + getLogText() +
                "\nUtworzono: " + getTimestamp() +
                "\nTyp:" + getLogType()
        );
    }
}
