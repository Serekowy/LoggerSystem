import java.util.ArrayList;

public class UserManager extends User {

    public UserManager(String username, AccessType access) {
        super(username, access);
    }
    public void addUser(UserManager user) {
        getUsers().add(user);
    }


}
