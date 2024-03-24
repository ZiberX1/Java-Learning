import java.security.MessageDigest;
import java.util.ArrayList;

public class User {
    /*
     * ชื่อจริง - นามสกุล
     */
    private String firstName;
    private String lastName;

    /*
     * user id
     */
    private String uuid;

    /*
     * pin รหัสผ่าน
     */
    private byte pinHash[];

    /*
     * ข้อมูล บัญชี (saving , checking)
     */
    private ArrayList<Account> accounts;

    /*
     * @param fistname  ชื่อจริง
     * @param lastname  นามสกุล
     * @param pin       รหัสผ่าน
     * @param theBank   ธนาคาร
     */
    public User(String firstname, String lastname, String pin, Bank theBank) {
        // ชื่อ นามสกุล
        this.firstName = firstname;
        this.lastName = lastname;

        // เก็บ pin with md5
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (Exception e) {
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        // สร้าง new user id
        this.uuid = theBank.getNewUserUUID();

        // สร้าง list บัญชี เปล่าๆ
        this.accounts = new ArrayList<Account>();

        // print log
        System.out.printf("New user %s %s with ID %s created.\n", firstname, lastname, this.uuid);
    }

    public void addAccount(Account onAccount) {
        this.accounts.add(onAccount);
    }

    public String getUUID() {
        return this.uuid;
    }

    // รหัสผ่าน Pin
    public boolean validatePin(String aPin) {
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
        } catch (Exception e) {
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        
        return false;
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public void printAccountSummary() {

        System.out.printf("\n\n%s's accounts summary\n", this.firstName);
        for (int a = 0; a < this.accounts.size(); a++) {
            System.out.printf("%d) %s\n", a+1, this.accounts.get(a).getSummaryLine());
        }
        System.out.println();
    }

    public int numAccount() {
        return this.accounts.size();
    }

    public void printAcctTransHistory(int acctIdx) {
        this.accounts.get(acctIdx).printTransHistory();
    }

    public double getAcctBalance(int acctIdx) {
        return this.accounts.get(acctIdx).getBalance();
    }

    public String getAcctUUID(int acctIdx) {
        return this.accounts.get(acctIdx).getUUID();
    }

    public void addAcctTransaction(int acctIdx, double amount, String memo) {
        this.accounts.get(acctIdx).addTransaction(amount, memo);
    }
}
