public class LogSystem extends Log {

    public LogSystem(String creator) {
        super(creator);
    }

    public void showLog() {
        System.out.println("Użytkownik: " + getCreator() + "\nTreść: " + getLogText());
    }
}
