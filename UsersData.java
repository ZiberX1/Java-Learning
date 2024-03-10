import java.util.HashMap;

public class UsersData {
    private HashMap<String, String> usersData = new HashMap<String, String>();

    UsersData() {
        usersData.put("admin", "test");
        usersData.put("ZiberX", "admin");
    }

    public HashMap<String, String> getUsers() {
        return usersData;
    }
}
