import java.util.ArrayList;

public class User
{
    private final String username;
    private final AccessType access;

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

}

