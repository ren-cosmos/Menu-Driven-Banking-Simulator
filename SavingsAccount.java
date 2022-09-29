// Checking Account is a child class of Account.
// Implements the abstract methods of the parent class Account
// A transaction fee is applied whenever a deposit or withdrawal happens
public class SavingsAccount extends Account{

    // Fields/Attributes
    private double interest_rate = 2.5;

    // Contructor 1
    public SavingsAccount(){
        super();
    }

    // Contructor 2
    public SavingsAccount(int acc_number){
        super(acc_number);
    }

    // Contructor 3
    public SavingsAccount(int acc_number, double interest_rate){
        super(acc_number);
        this.interest_rate = interest_rate;
    }

    // Accessor Methods
    public double getInterestRate(){
        return this.interest_rate;
    }
    
    public int getAccountNumber(){
        return this.acc_number;
    }

    // Mutator Method
    public void setInterestRate(double rate){
        this.interest_rate = rate;
    }

    // Abstract Methods
    public void deposit(double amount){
        if(amount > 0){
            this.balance += amount;
            System.out.printf("Amount Deposited: %.2f%n: ", amount);
            System.out.printf("Current Balance: %.2f%n", this.balance);
        }
        else{
            System.out.println("Please enter a postive amount for deposit");
        }
    }

    public void withdraw(double amount){

        if(amount > 0){
            if(amount <= this.balance){
                this.balance -= amount;
                System.out.printf("Amount Withdrawn: %.2f%n", amount);
                System.out.printf("Current Balance: %.2f%n", this.balance);
            }
            else{
                System.out.println("Insufficient Balance");
                System.out.printf("Current Balance: %.2f%n", this.balance);
            }
        }
        else{
            System.out.println("Please enter a postive amount to withdraw");
        }
    }

    public double calcInterest(){
        return this.balance * this.interest_rate;
    }

    public void applyInterest(){
        double interest = calcInterest();
        System.out.printf("Interest Added: %.2f%n", interest);
        deposit(interest);
    }
}