import java.util.HashMap;

public class Users {
    // ตัวแปร ข้อมูล users
    private HashMap<String, String> usersData = new HashMap<String, String>();

    Users() {
        // add user to data
        usersData.put("admin", "admin");
        usersData.put("test", "1234test");
        usersData.put("Teeramat", "1234Hahaha");
    }

    // ส่งกลับค่า usersData
    public HashMap<String, String> getUsersData() {
        return usersData;
    }
    
}
