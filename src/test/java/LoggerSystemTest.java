import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerSystemTest {
    @Test
    void removeLogShouldRemoveLog() {
        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.addUser(new User("User", AccessType.BASIC));
        loggerSystem.addLog(new LogSystem("User", "now", "jakis tekst log", "text"));
        loggerSystem.removeLog("User", "", 0);

        assertTrue(loggerSystem.getUserLogs("User", "").isEmpty());

    }
    @Test
    void addLogShouldNotAddWhenUserNotExist() {
        LoggerSystem loggerSystem = new LoggerSystem();

        loggerSystem.addLog(new LogSystem("User", "now", "jakis tekst log", "text"));

        assertTrue(loggerSystem.getUserLogs("User", "").isEmpty());

    }
    @Test
    void addLogShouldAddWhenUserExist() {
        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.addUser(new User("User", AccessType.BASIC));
        loggerSystem.addLog(new LogSystem("User", "now", "jakis tekst log", "text"));

        assertFalse(loggerSystem.getUserLogs("User", "").isEmpty());

    }
}