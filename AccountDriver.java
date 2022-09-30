import java.util.Scanner;

public class AccountDriver{

    public static void main(String [] args){

        Scanner keyboard = new Scanner(System.in);

        //Create an Array of 10 Accounts
        Account accounts[] = new Account[10];

        int num_accs = 0;
        int choice;

        do{
            choice = displayMenu(keyboard);
            System.out.println();
            if (choice == 1){
                accounts[num_accs++] = createAccount(keyboard);
            }
            else if (choice == 2){
                doDeposit(accounts, num_accs, keyboard);
            }
            else if (choice == 3){
                doWithdrawal(accounts, num_accs, keyboard);
            }
            else if(choice == 4){
                applyInterest(accounts, num_accs, keyboard);
            }
            else{
                System.out.println("GoodBye, See you again");
            }
            System.out.println();
        }while(choice != 5);
    }

    /**
     * Function to display the main menu displayed at the home screen
     * @param keyboard
     * @return choice
     */
    public static int displayMenu(Scanner keyboard){
        System.out.println("Home Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;

        do{
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        }while(choice < 1 || choice > 5);

        return choice;
    }

    /**
     * A function to create a particular type of account. It displays the account menu, asks the user to choose an account type (by means of displayAccountMenu), enter the account number, and create the appropriate account
     * @param keyboard
     * @return
     */
    public static Account createAccount(Scanner keyboard){
    
        Account account;
        int choice = displayAccountMenu(keyboard);
        System.out.print("Enter Account Number: ");
        int acc_num = keyboard.nextInt();

        if (choice == 1){
            System.out.print("Enter Transaction Fee: ");
            double trans_fee = keyboard.nextDouble();
            account = new CheckingAccount(acc_num, trans_fee);
        }
        else{
            System.out.print("Enter Interest Rate: ");
            double rate = keyboard.nextDouble();
            account = new SavingsAccount(acc_num, rate);
        }
        return account;
    }

    /**
     * Function to display the type of account menu displayed in Create Account Page
     * @param keyboard
     * @return choice
     */
    public static int displayAccountMenu(Scanner keyboard){
        System.out.println("Account Menu");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do{
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        }while(!(choice == 1 || choice == 2));

        return choice;
    }

    public static int searchAccount(Account accounts[], int count, int acc_num){
        for (int i=0; i<count; i++){
            if (accounts[i].getAccountNumber() == acc_num){
                return i;
            }
        }
        return -1;
    }
    public static void doDeposit(Account accounts[], int count, Scanner keyboard){
        System.out.print("Enter the account number: ");
        int acc_num = keyboard.nextInt();

        //search for account from the list of accounts
        int index = searchAccount(accounts, count, acc_num);

        if (index != -1){
            System.out.print("Enter the amount: ");
            double amount = keyboard.nextInt();
            accounts[index].deposit(amount);
        }
        else{
            System.out.println("Account Number " + acc_num + " not found!");
            System.out.println();
        }
    }

    public static void doWithdrawal(Account accounts[], int count, Scanner keyboard){
        System.out.print("Enter the account number: ");
        int acc_num = keyboard.nextInt();

        //search for account from the list of accounts
        int index = searchAccount(accounts, count, acc_num);

        if (index != -1){
            System.out.print("Enter the amount: ");
            double amount = keyboard.nextInt();
            accounts[index].withdraw(amount);
        }
        else{
            System.out.printf("Account Number", acc_num, "not found!");
        }
    }

    public static void applyInterest(Account accounts[], int count, Scanner keyboard){
        System.out.print("Enter the account number: ");
        int acc_num = keyboard.nextInt();

        //search for account from the list of accounts
        int index = searchAccount(accounts, count, acc_num);

        if (index != -1){
    
            if (accounts[index] instanceof SavingsAccount){
                ((SavingsAccount)accounts[index]).applyInterest();
            }
            
        }
        else{
            System.out.printf("Account Number", acc_num, "not found!");
        }
    }
}