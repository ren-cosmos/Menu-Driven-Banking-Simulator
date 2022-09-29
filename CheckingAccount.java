// Checking Account is a child class of Account.
// Implements the abstract methods of the parent class Account
// A transaction fee is applied whenever a deposit or withdrawal happens
public class CheckingAccount extends Account{

    // Fields/Attributes
    private double trans_fee = 2.5;

    // Contructor 1
    public CheckingAccount(){
        super();
    }

    // Contructor 2
    public CheckingAccount(int acc_number){
        super(acc_number);
    }

    // Contructor 3
    public CheckingAccount(int acc_number, double trans_fee){
        super(acc_number);
        this.trans_fee = trans_fee;
    }

    // Accessor Methods
    public double getTransactionFee(){
        return this.trans_fee;
    }
    
    public int getAccountNumber(){
        return this.acc_number;
    }

    // Abstract Methods
    public void deposit(double amount){
        if(amount > 0){
            this.balance += amount;
            System.out.printf("Amount Deposited: %.2f%n: ", amount);

            // Apply Transaction Fee
            this.balance -= trans_fee;
            System.out.printf("Transaction Fee Applied: %.2f%n", this.trans_fee);
            System.out.printf("Current Balance: %.2f%n", this.balance);
        }
        else{
            System.out.println("Please enter a postive amount for deposit");
        }
    }

    public void withdraw(double amount){

        if(amount > 0){
            if((amount+this.trans_fee) <= this.balance){
                this.balance -= amount;
                System.out.printf("Amount Withdrawn: %.2f%n", amount);
                // Apply Transaction Fee
                this.balance -= trans_fee;
                System.out.printf("Transaction Fee Applied: %.2f%n", this.trans_fee);
                System.out.printf("Current Balance: %.2f%n", this.balance);
            }
        }
    }
}