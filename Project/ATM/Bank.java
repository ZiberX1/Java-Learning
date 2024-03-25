import java.util.ArrayList;
import java.util.Random;

public class Bank {

    // ชื่อธนาคาร
    private String name;

    // list data > users account
    private ArrayList<User> users;

    private ArrayList<Account> accounts;

    public String generateUserID() {

        String uuid;
        int len = 6;
        Random random = new Random();
        boolean nonUnique;

        do {
            
            uuid = "";
            // สุ่มเลข 0-9 : len ครั้ง
            for (int i = 0; i < len; i++) {
                uuid += (Integer)random.nextInt(10);
            }

            // check ซ้ำ
            nonUnique = false;
            for (User theUser : users) {
                if (uuid.equals(theUser.getUUID())) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique); // loop จนกว่าจะได้ uuid


        return uuid;
    }

    public String generateAccountID() {

        String uuid;
        int len = 10;
        Random random = new Random();
        boolean nonUnique;

        do {
            
            uuid = "";
            // สุ่มเลข 0-9 : len ครั้ง
            for (int i = 0; i < len; i++) {
                uuid += (Integer)random.nextInt(10);
            }

            // check ซ้ำ
            nonUnique = false;
            for (Account theAccount : accounts) {
                if (uuid.equals(theAccount.getUUID())) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique); // loop จนกว่าจะได้ uuid


        return uuid;
    }

    public void addAccount(Account anAccount) {
        this.accounts.add(anAccount);
    }

    public Bank(String name) {

        this.name = name;

        // data list
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    // create user
    public User addUser(String firstName, String lastName, String pin) {

        User newUser = new User(firstName, lastName, pin, this);
        // save new user to list
        this.users.add(newUser);
        
        // create account saving
        Account newAccount = new Account("Saving", newUser, this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;
    }

    // login
    public User userLogin(String userID, String aPin) {

        for (User theUser : users) {
            
            // เช็ค user id and pin
            if (theUser.getUUID().equals(userID) && theUser.validatePin(aPin)) {
                return theUser;
            }
        }

        // หากไม่พบ user หรือ pin ไม่ถูกต้อง
        return null;
    }

    public String getName() {
        return this.name;
    }
}
