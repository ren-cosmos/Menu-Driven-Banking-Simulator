// Abstract Base Class
// Parent of SavingsAccount and CheckingAccount
// The abstract methods of this class are implemented in the child classes

public abstract class Account{

    // Fields/Attributes
    protected double balance;
    protected int acc_number;

    // Contructor 1
    public Account(){

    }

    // Constructor 2
    public Account(int acc_number){
        this.acc_number = acc_number;
        this.balance = 0;
    }

    // Accessor Methods
    public double getBalance(){
        return this.balance;
    }

    public int getAccountNumber(){
        return this.acc_number;
    }

    // Abstract Methods
    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}
