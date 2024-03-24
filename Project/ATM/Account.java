import java.util.ArrayList;

public class Account {
    // ชื่อบัญชี (saving , checking)
    private String name;

    // จำนวนเงินในบัญชี
    private double balance;

    // account id
    private String uuid;

    // เจ้าของ บัญชี
    private User holder;

    // ประวัติ การเงิน
    private ArrayList<Transaction> transactions;

    public Account(String name, User holder, Bank theBank) {

        // set account and holder
        this.name = name;
        this.holder = holder;

        // create account id
        this.uuid = theBank.getNewAccountUUID();

        // init transaction
        this.transactions = new ArrayList<Transaction>();

        // save data
        // holder.addAccount(this);
        // theBank.addAccount(this);
    }

    public String getUUID() {
        return this.uuid;
    }

    public String getSummaryLine() {
        // get the account's balance
        double balance = this.getBalance();

        // format the summary line, depending on the whether the balance is negative.
        if (balance >= 0) {
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        } else {
            return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
    }

    /**
     * Get the balance of this account by adding the amounts of the transactions
     * @return  the balance value
     */
    public double getBalance() {

        double balance = 0;
        for (Transaction t : this.transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    /*
     * Print the transaction history of the account.
     */
    public void printTransHistory() {
        System.out.printf("\nTransaction history for account %s\n", this.uuid);
        for (int t = this.transactions.size()-1 ; t >= 0; t--) {
            System.out.println(this.transactions.get(t).getSummaryLine());
        }
        System.out.println();
    }

    /**
     * Add a new transaction in this account.
     * @param amount    the ammount transacted
     * @param memo      the transaction memo
     */
    public void addTransaction(double amount, String memo) {

        // create new transaction object and add it to our list.
        Transaction newTrans = new Transaction(amount, memo, this);
        this.transactions.add(newTrans);
        
    }
}
