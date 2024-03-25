import java.util.ArrayList;

public class Account {

    //  ภายใน บัญชี -> ชื่อ id เงิน transaction User-เจ้าของ
    private String name;

    // เงิน
    private double balance;
    
    // account id
    private String uuid;

    // เจ้าของ
    private User holder;

    // list trans
    private ArrayList<Transaction> transactions;

    public Account(String name, User holder, Bank theBank) {
        
        this.name = name;
        this.holder = holder;

        // account id
        this.uuid = theBank.generateAccountID();

        // create list Transaction
        this.transactions = new ArrayList<Transaction>();
    }

    // get account id
    public String getUUID() {
        return this.uuid;
    }

    public String getAccountSummary() {
        double balance = this.getBalance();

        // หากน้อยกว่า 0 => ติดลบ
        if (balance >= 0) {
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        } else {
            return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
    }

    public double getBalance() {

        double balance = 0;

        for (Transaction theTrans : transactions) {
            balance += theTrans.getAmount();
        }

        return balance;
    }

    public void printTransHistory() {
        System.out.printf("\nTransaction history for account %s\n", this.uuid);

        for (int i = this.transactions.size() - 1; i >= 0; i--) {
            System.out.println(this.transactions.get(i).getSummaryLine());
        }
    }

    public void addTransHistory(double amount, String memo) {

        Transaction newTransaction = new Transaction(amount, memo, this);
        this.transactions.add(newTransaction);
        
    }
}
