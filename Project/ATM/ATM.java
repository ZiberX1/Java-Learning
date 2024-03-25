import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Bank krungthaiBank = new Bank("Krungthai");

        User aUser = krungthaiBank.addUser("Teeramat", "Chanthod", "1234");

        // create Checking account
        Account newAccount = new Account("Checking", aUser, krungthaiBank);
        aUser.addAccount(newAccount);
        krungthaiBank.addAccount(newAccount);
        
        User curUser;
        while (true) {
            
            // main menu
            curUser = ATM.printMainMenu(krungthaiBank, sc);

            // after login succesful -> user menu
            ATM.printUserMenu(curUser, sc);
        }

    }

    public static User printMainMenu(Bank theBank, Scanner sc) {

        String userID;
        String pin;
        User authUser;

        do {
            System.out.printf("\nWelcome to %s\n\n", theBank.getName());

            // login
            System.out.print("Enter user ID: ");
            userID = sc.nextLine();
            System.out.print("Enter a pin: ");
            pin = sc.nextLine();

            authUser = theBank.userLogin(userID, pin);

            if (authUser == null) {
                System.out.println("Incorrect user ID/PIN. Please try again.");
            }
        } while (authUser == null); // loop จนกว่าจะใส่ user/pin ถูก

        return authUser;
    }


    public static void printUserMenu(User theUser, Scanner sc) {

        // ประวัติ โอน ถอน ฝาก quit
        int choice;
        
        // print accounts summary.
        theUser.printAccountSummary();

        do {
            System.out.printf("Welcome %s, what would you like to do?\n", theUser.getFirstName());
            System.out.println("  1) Show account transaction history");
            System.out.println("  2) Withdraw");
            System.out.println("  3) Deposit");
            System.out.println("  4) Transfer");
            System.out.println("  5) Quit");
            System.out.println();
            System.out.print("Enter a choice: ");
            choice = sc.nextInt();

            if (choice <= 0 || choice > 5) {
                System.out.println("Invalid choice. Please choose 1-5");
            }

        } while (choice <= 0 || choice > 5);

        switch (choice) {
            case 1:
                ATM.showTransHistory(theUser, sc);
                break;
            case 2:
                ATM.withdrawFunds(theUser, sc);
                break;
            case 3:
                ATM.depositFunds(theUser, sc);
                break;
            case 4:
                ATM.transferFunds(theUser, sc);
                break;
            case 5:
                sc.nextLine();
                break;
        }

        if (choice != 5) {
            ATM.printUserMenu(theUser, sc);
        }
    }

    public static void showTransHistory(User theUser, Scanner sc) {
        
        // account index
        int acctIdx;

        do {
            System.out.printf("Enter the number (1-%d) of the account\nwhose transaction you want to see: ", theUser.numAccount());
            acctIdx = sc.nextInt() - 1;

            if (acctIdx < 0 || acctIdx >= theUser.numAccount()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (acctIdx < 0 || acctIdx >= theUser.numAccount()); // loop จนกว่าจะเลือก account ถูก

        // print transaction history
        theUser.printAccountTransHistory(acctIdx);
    }

    public static void transferFunds(User theUser, Scanner sc) {

        // inits
        int fromAcct;
        int toAcct;
        double amount;
        double acctBalance;

        do {
            System.out.printf("Enter the number (1-%d) of the account\nto transfer from: ", theUser.numAccount());
            fromAcct = sc.nextInt() - 1;

            if (fromAcct < 0 || fromAcct >= theUser.numAccount()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (fromAcct < 0 || fromAcct >= theUser.numAccount()); // loop จนกว่าจะเลือก account ถูก
        acctBalance = theUser.getAccountBalance(fromAcct);
        
        do {
            System.out.printf("Enter the number (1-%d) of the account\nto transfer to: ", theUser.numAccount());
            toAcct = sc.nextInt() - 1;

            if (toAcct < 0 || toAcct >= theUser.numAccount() || toAcct == fromAcct) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccount() || toAcct == fromAcct); // loop จนกว่าจะเลือก account ถูก

        do {
            System.out.printf("Enter the amount to transfer (max $%.02f) : $", acctBalance);
            amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Amount must be greater than zero.");
            } else if (amount > acctBalance) {
                System.out.printf("Amount must not be greater than\nbalance of $%.02f.\n", acctBalance);
            }
        } while (amount <= 0 || amount > acctBalance);

        // transfers
        // from Account
        theUser.addTransaction(fromAcct, -1*amount, String.format("Transfer to account %s", theUser.getAccountUUID(toAcct)));

        // to Account
        theUser.addTransaction(toAcct, amount, String.format("Transfer from account %s", theUser.getAccountUUID(fromAcct)));
        
    }

    public static void withdrawFunds(User theUser, Scanner sc) {

        // inits
        int fromAcct;
        String memo;
        double amount;
        double acctBalance;

        do {
            System.out.printf("Enter the number (1-%d) of the account\nto withdraw from: ", theUser.numAccount());
            fromAcct = sc.nextInt() - 1;

            if (fromAcct < 0 || fromAcct >= theUser.numAccount()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (fromAcct < 0 || fromAcct >= theUser.numAccount()); // loop จนกว่าจะเลือก account ถูก
        acctBalance = theUser.getAccountBalance(fromAcct);

        do {
            System.out.printf("Enter the amount to withdraw (max $%.02f) : $", acctBalance);
            amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Amount must be greater than zero.");
            } else if (amount > acctBalance) {
                System.out.printf("Amount must not be greater than\nbalance of $%.02f.\n", acctBalance);
            }
        } while (amount <= 0 || amount > acctBalance);

        // reset
        sc.nextLine();

        System.out.print("Enter a memo: ");
        memo = sc.nextLine();

        // trans
        theUser.addTransaction(fromAcct, -1*amount, memo);
    }

    public static void depositFunds(User theUser, Scanner sc) {

        // inits
        int inAcct;
        String memo;
        double amount;

        do {
            System.out.printf("Enter the number (1-%d) of the account\nto deposit in: ", theUser.numAccount());
            inAcct = sc.nextInt() - 1;

            if (inAcct < 0 || inAcct >= theUser.numAccount()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (inAcct < 0 || inAcct >= theUser.numAccount()); // loop จนกว่าจะเลือก account ถูก

        do {
            System.out.print("Enter the amount to deposit : $");
            amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Amount must be greater than zero.");
            }
        } while (amount <= 0);

        // reset
        sc.nextLine();

        System.out.print("Enter a memo: ");
        memo = sc.nextLine();

        // trans
        theUser.addTransaction(inAcct, amount, memo);
    }

}
