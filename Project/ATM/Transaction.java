import java.util.Date;

public class Transaction {
    
    // transaction ภายใน จะมี จำนวนเงิน ข้อความ เวลา เจ้าของบัญชี
    private double amount;

    private String memo;

    private Date timestamp;

    private Account inAccount;

    public Transaction(double amount, Account inAccount) {
        
        this.amount = amount;
        this.inAccount = inAccount;

        this.timestamp = new Date();

        this.memo = "";
    }

    public Transaction(double amount, String memo, Account inAccount) {
        
        this(amount, inAccount);
        this.memo = memo;

    }

    public double getAmount() {
        return this.amount;
    }

    public String getSummaryLine() {

        // หากน้อยกว่า 0 => ติดลบ
        if (this.amount >= 0) {
            return String.format("%s : $%.02f : %s", this.timestamp, this.amount, this.memo);
        } else {
            return String.format("%s : $(%.02f) : %s", this.timestamp, this.amount, this.memo);
        }
    }
}
