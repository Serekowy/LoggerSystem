public class AccessManage {
    public boolean checkAccess(int checkingUserId, int userToCheckId, LoggerSystem loggerSystem) {
        AccessType checkingUserAccess = loggerSystem.getUsers().get(checkingUserId).getAccess();
        AccessType userToCheckAccess = loggerSystem.getUsers().get(userToCheckId).getAccess();

        if (checkingUserAccess.equals(userToCheckAccess)) {
            System.out.println("Brak uprawnień");
            return false;
        } else if (checkingUserAccess.equals(AccessType.BASIC)) {
            System.out.println("Brak uprawnień");
            return false;
        } else if (checkingUserAccess.equals(AccessType.ADMIN) && userToCheckAccess.equals(AccessType.BASIC)) {
            System.out.println("Odpowiednie uprawnienia");
            return true;
        } else if (checkingUserAccess.equals(AccessType.ADMIN) && userToCheckAccess.equals(AccessType.OWNER)) {
            System.out.println("Brak uprawnień");
            return true;
        } else {
            System.out.println("Odpowiednie uprawnienia");
            return true;
        }
    }
}
