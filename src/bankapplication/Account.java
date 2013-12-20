/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

/**
 *
 * @author kanibbs
 */
public class Account {
    private String name;
    private double balance;
    
    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getBalance(){
        return this.balance;
    }
    
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    /*if the the amount left in the account is invalid after the transaction,
     * return -1 to signify a failed transaction
     */
    public double editBalance(double change) {
        if ((balance + change) > 0) {
            balance += change;
            return 1;
        }
        else return -1;
    }
    
}
