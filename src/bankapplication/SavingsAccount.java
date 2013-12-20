/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;


public class SavingsAccount extends Account{
    
static final double dailyInterest = .01;



    public SavingsAccount(String name, double balance){
        super(name, balance);
    }
    
    /*if the the amount left in the account is invalid after the transaction,
     * return -1 to signify a failed transaction
     */
    
    public double editBalance(double change) {
        if (this.getBalance() + change > 0) {
            this.setBalance(this.getBalance() + change);
            this.setBalance(this.getBalance() + (this.getBalance() * dailyInterest));
            return 1;       
    }
        return -1;
}
}
