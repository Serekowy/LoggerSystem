import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerSystemTest {
    @Test
    void addUserShouldAddNewUser() {
        LoggerSystem loggerSystem = new LoggerSystem();
        assertTrue(loggerSystem.addUser(new User("User", AccessType.BASIC)));
    }
    @Test
    void addUserShouldNotAddTheSameUserName() {
        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.addUser(new User("User", AccessType.ADMIN));
        assertFalse(loggerSystem.addUser(new User("User", AccessType.BASIC)));
    }
    @Test
    void getUserLogsShouldNotShowWhenUserNotExist() {
        LoggerSystem loggerSystem = new LoggerSystem();

        loggerSystem.addLog(new LogSystem("User", "now", "jakis tekst log", "text"));

        assertTrue(loggerSystem.getUserLogs("User", "").isEmpty());

    }
    @Test
    void getUserLogsShouldShowWhenUserExist() {
        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.addUser(new User("User", AccessType.BASIC));
        loggerSystem.addLog(new LogSystem("User", "now", "jakis tekst log", "text"));

        assertFalse(loggerSystem.getUserLogs("User", "").isEmpty());

    }
    @Test
    void removeLogShouldRemoveLog() {
        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.addUser(new User("User", AccessType.BASIC));
        loggerSystem.addLog(new LogSystem("User", "now", "jakis tekst log", "text"));
        loggerSystem.removeLog("User", "", 0);

        assertTrue(loggerSystem.getUserLogs("User", "").isEmpty());

    }
    @Test
    void removeLogShouldNotRemoveLogWhenEmpty() {
        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.addUser(new User("User", AccessType.BASIC));
        loggerSystem.addLog(new LogSystem("User", "now", "jakis tekst log", "text"));
        loggerSystem.removeLog("", "", 0);

        assertFalse(loggerSystem.getUserLogs("User", "").isEmpty());
    }
    @Test
    void removeLogShouldNotRemoveLogWhenWrongNumberGiven() {
        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.addUser(new User("User", AccessType.BASIC));
        loggerSystem.addLog(new LogSystem("User", "now", "jakis tekst log", "text"));
        loggerSystem.removeLog("User", "", 5);

        assertFalse(loggerSystem.getUserLogs("User", "").isEmpty());

    }
    @Test
    void removeLogShouldNotRemoveLogWhenMinusNumberGiven() {
        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.addUser(new User("User", AccessType.BASIC));
        loggerSystem.addLog(new LogSystem("User", "now", "jakis tekst log", "text"));
        loggerSystem.removeLog("User", "", -5);

        assertFalse(loggerSystem.getUserLogs("User", "").isEmpty());

    }
    @Test
    void removeLogShouldNotRemoveLogWhenOnlyUserToDeleteGiven() {
        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.addUser(new User("User", AccessType.BASIC));
        loggerSystem.addLog(new LogSystem("User", "now", "jakis tekst log", "text"));
        loggerSystem.removeLog("", "User", 0);

        assertFalse(loggerSystem.getUserLogs("User", "").isEmpty());

    }
    @Test
    void removeLogShouldRemoveOtherUserLog() {
        LoggerSystem loggerSystem = new LoggerSystem();
        loggerSystem.addUser(new User("User", AccessType.BASIC));
        loggerSystem.addUser(new User("User2", AccessType.ADMIN));
        loggerSystem.addLog(new LogSystem("User", "now", "jakis tekst log", "text"));
        loggerSystem.removeLog("User2", "User", 0);

        assertTrue(loggerSystem.getUserLogs("User", "").isEmpty());

    }

}