import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;

    private ArrayList<User> users;

    private ArrayList<Account> accounts;

    // Create a new Bank with empty data
    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    public String getNewUserUUID() {
        // inits
        String uuid;
        Random rd = new Random();
        int len = 6;
        boolean nonUnique;

        // loop จนกว่าจะได้ uuid
        do {
            // generate number
            uuid = "";
            for (int i = 0; i < len; i++) {
                uuid += (Integer)rd.nextInt(10);
            }

            // check in bank
            nonUnique = false;
            for (User u : users) {
                if (uuid.compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);

        return uuid;
    }

    public String getNewAccountUUID() {
        // inits
        String uuid;
        Random rd = new Random();
        int len = 10;
        boolean nonUnique;

        // loop จนกว่าจะได้ uuid
        do {
            // generate number
            uuid = "";
            for (int i = 0; i < len; i++) {
                uuid += (Integer)rd.nextInt(10);
            }

            // check in bank
            nonUnique = false;
            for (Account a : accounts) {
                if (uuid.compareTo(a.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);

        return uuid;
    }
    
    public void addAccount(Account onAccount) {
        this.accounts.add(onAccount);
    }

    // Create user
    public User addUser(String firstname, String lastname, String pin) {

        // create a new User object and add to list
        User newUser = new User(firstname, lastname, pin, this);
        this.users.add(newUser);

        // create a saving account and add to list
        Account newAccount = new Account("Saving", newUser, this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);
        

        return newUser;
    }

    public User userLogin(String userID, String pin) {

        for (User u : users) {
            
            // if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
            if (u.getUUID().equals(userID) && u.validatePin(pin)) {
                return u;
            }
        }

        // ถ้าไม่พบ user จะ return null
        return null;
    }

    public String getName() {
        return this.name;
    }
}