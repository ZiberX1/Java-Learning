import java.security.MessageDigest;
import java.util.ArrayList;

public class User {

    // user จะเก็บตัวแปร ชื่อ สกุล id บัญชี pin
    private String firstName;
    private String lastName;

    private String uuid;

    // pin -> md5
    private byte pinHash[];

    // list Accounts
    private ArrayList<Account> accounts;

    public User(String firstName, String lastName, String pin, Bank theBank) {

        this.firstName = firstName;
        this.lastName = lastName;

        // String pin --> md5
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            pinHash = md.digest(pin.getBytes());
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Error");
            System.exit(1);
        }

        // generate user id from bank
        this.uuid = theBank.generateUserID();

        // create list บัญชี
        this.accounts = new ArrayList<Account>();

        // print logs
        System.out.printf("New user %s %s with ID %s created.\n", firstName, lastName, this.uuid);
    }

    public void addAccount(Account anAccount) {
        this.accounts.add(anAccount);
    }

    // get user id
    public String getUUID() {
        return this.uuid;
    }

    // check pin
    public boolean validatePin(String aPin) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Error");
            System.exit(1);
        }

        return false;
    }

    public void printAccountSummary() {
        System.out.printf("\n\n%s's accounts summary.\n", this.firstName);
        for (int i = 0; i < this.accounts.size(); i++) {
            System.out.printf("%d) %s\n", i+1, this.accounts.get(i).getAccountSummary());
        }
        System.out.println();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int numAccount() {
        return this.accounts.size();
    }

    public void printAccountTransHistory(int acctIdx) {
        this.accounts.get(acctIdx).printTransHistory();
    }

    public double getAccountBalance(int acctIdx) {
        return this.accounts.get(acctIdx).getBalance();
    }

    public String getAccountUUID(int acctIdx) {
        return this.accounts.get(acctIdx).getUUID();
    }

    public void addTransaction(int acctIdx, double amount, String memo) {
        this.accounts.get(acctIdx).addTransHistory(amount, memo);
    }
}
