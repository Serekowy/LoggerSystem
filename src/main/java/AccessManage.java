public class AccessManage {
    //najpierw sprawdzamy uzytkownika, pozniej uprawnienia, i sprawdzamy logi
    public boolean checkAccess(AccessType checkingUserAccess, AccessType userToCheckAccess) {
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
