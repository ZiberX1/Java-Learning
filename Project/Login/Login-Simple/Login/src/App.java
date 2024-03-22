public class App {
    public static void main(String[] args) throws Exception {
        // Simple login ui with JFrame
        // สร้าง class Users ไว้เก็บข้อมูล
        Users users = new Users();
        // System.out.println(users.getUsersData());

        // สร้าง class login ui
        new LoginUI(users.getUsersData());

    }
}
