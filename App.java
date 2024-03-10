import Login.LoginSImple.MainUI;

public class App {
    public static void main(String[] args) {
        UsersData usersData = new UsersData();
        // System.out.println(usersData.getUsers());

        LoginUI loginUI = new LoginUI(usersData.getUsers());
        // MainUI mainUI = new MainUI("ZiberX");
        
    }
}