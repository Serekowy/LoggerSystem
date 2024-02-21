import java.util.ArrayList;

public class User
{
    private String username;
    private AccessType access;

    public User(String username, AccessType access) {
        this.username = username;
        this.access = access;
    }

    public AccessType getAccess() {
        return access;
    }

    public String getUsername() {
        return username;
    }

    public void setAccess(AccessType newAccess) {
        this.access = newAccess;
    }
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }
}

