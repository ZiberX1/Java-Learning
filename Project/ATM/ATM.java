import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // create Bank
        Bank krungthaiBank = new Bank("Krungthai");
        
        // create user
        User aUser = krungthaiBank.addUser("Teeramat", "Chanthod", "1234");

        // create checking account and add to data
        Account newAccount = new Account("Checking", aUser, krungthaiBank);
        aUser.addAccount(newAccount);
        krungthaiBank.addAccount(newAccount);
        
        User curUser;
        while (true) {
            
            // stay in login prompt until succesful login.
            curUser = ATM.mainPrompt(krungthaiBank, sc);

            // stay in main menu until user quit.
            ATM.printUserMenu(curUser, sc);
        }
        
    }

    public static User mainPrompt(Bank theBank, Scanner sc) {
        // inits
        String userID;
        String pin;
        User authUser;

        // prompt the user for user ID/pin combo until a correct one is reached.
        do {
            
            System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
            System.out.print("Enter user ID: ");
            userID = sc.nextLine();
            System.out.print("Enter PIN: ");
            pin = sc.nextLine();

            // login
            authUser = theBank.userLogin(userID, pin);
            if (authUser == null) {
                System.out.println("Incorrect user ID/PIN. Please try again.");
            }

        } while (authUser == null); // continue looping until succesful login.

        return authUser;
    }

    public static void printUserMenu(User theUser, Scanner sc) {

        // print summary of the user's account
        theUser.printAccountSummary();

        // inits
        int choice;

        // user menu
        do {
            System.out.printf("Welcome %s, what would you like to do?\n", theUser.getFirstName());
            System.out.println("  1) Show account transaction history");
            System.out.println("  2) Withdraw");
            System.out.println("  3) Deposit");
            System.out.println("  4) Transfer");
            System.out.println("  5) Quit");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please choose 1-5");
            }
        } while (choice < 1 || choice > 5);

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

        // redisplay this menu unless the user wants to quit
        if (choice != 5) {
            ATM.printUserMenu(theUser, sc);
        }
    }

    /*
     * Show the transaction history for an account
     * @param theUser   the logged-in User object
     * @param sc        the Scanner object used for user input
     */
    public static void showTransHistory(User theUser, Scanner sc) {

        int theAcct;

        // get account whose transaction history to look at
        do {
            System.out.printf("Enter the number (1-%d) of the account\nwhose transactions you want to see: ", theUser.numAccount());
            theAcct = sc.nextInt()-1;
            if (theAcct < 0 || theAcct >= theUser.numAccount()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (theAcct < 0 || theAcct >= theUser.numAccount());

        // print the transaction history.
        theUser.printAcctTransHistory(theAcct);
    }

    /**
     * Process transfering funds from one account to another
     * @param theUser   the logged-in User object
     * @param sc        the Scanner object used for user input
     */
    public static void transferFunds(User theUser, Scanner sc) {

        // inits
        int fromAcct;
        int toAcct;
        double amount;
        double acctBal;

        // get the account to transfer from
        do {
            System.out.printf("Enter the number (1-%d) of the account\nto transfer from: ", theUser.numAccount());
            fromAcct = sc.nextInt()-1;
            if (fromAcct < 0 || fromAcct >= theUser.numAccount()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (fromAcct < 0 || fromAcct >= theUser.numAccount());

        acctBal = theUser.getAcctBalance(fromAcct);

        // get the account to transfer to
        do {
            System.out.printf("Enter the number (1-%d) of the account\nto transfer to: ", theUser.numAccount());
            toAcct = sc.nextInt()-1;
            if (toAcct < 0 || toAcct >= theUser.numAccount()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccount());


        // get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $", acctBal);
            amount = sc.nextDouble();
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero");
            } else if (amount > acctBal) {
                System.out.printf("Amount must not be greater than\nbalance of $%.02f.\n", acctBal);
            }
        } while (amount <= 0 || amount > acctBal);

        // finally, do the transfer
        theUser.addAcctTransaction(fromAcct, -1*amount, String.format("Transfer to account %s", theUser.getAcctUUID(toAcct)));
        theUser.addAcctTransaction(toAcct, amount, String.format("Transfer from account %s", theUser.getAcctUUID(fromAcct)));
    }

    /**
     * Process a fund withdraw from an account
     * @param theUser   the logged-in User object
     * @param sc        the Scanner object used for user input
     */
    public static void withdrawFunds(User theUser, Scanner sc) {
        
        // inits
        int fromAcct;
        double amount;
        double acctBal;
        String memo;

        // get the account to transfer from
        do {
            System.out.printf("Enter the number (1-%d) of the account\nto withdraw from: ", theUser.numAccount());
            fromAcct = sc.nextInt()-1;
            if (fromAcct < 0 || fromAcct >= theUser.numAccount()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (fromAcct < 0 || fromAcct >= theUser.numAccount());

        acctBal = theUser.getAcctBalance(fromAcct);

        // get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $", acctBal);
            amount = sc.nextDouble();
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero");
            } else if (amount > acctBal) {
                System.out.printf("Amount must not be greater than\nbalance of $%.02f.\n", acctBal);
            }
        } while (amount <= 0 || amount > acctBal);

        // gobble up rest of previous input
        sc.nextLine();

        // get a memo
        System.out.print("Enter a memo: ");
        memo = sc.nextLine();

        // do the withdraw
        theUser.addAcctTransaction(fromAcct, -1*amount, memo);
    }

    /**
     * Process a fund deposite to an account
     * @param theUser   the logged-in User object
     * @param sc        the Scanner object used for user input
     */
    public static void depositFunds(User theUser, Scanner sc) {
        
        // inits
        int toAcct;
        double amount;
        double acctBal;
        String memo;

        // get the account to transfer from
        do {
            System.out.printf("Enter the number (1-%d) of the account\nto deposit in: ", theUser.numAccount());
            toAcct = sc.nextInt()-1;
            if (toAcct < 0 || toAcct >= theUser.numAccount()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccount());

        acctBal = theUser.getAcctBalance(toAcct);

        // get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $", acctBal);
            amount = sc.nextDouble();
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero");
            }
        } while (amount <= 0);

        // gobble up rest of previous input
        sc.nextLine();

        // get a memo
        System.out.print("Enter a memo: ");
        memo = sc.nextLine();

        // do the withdraw
        theUser.addAcctTransaction(toAcct, amount, memo);
    }

}
