/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

/**
 *
 * @author kanibbs
 */
public class CheckingAccount extends Account{
    
   
    
    
    public CheckingAccount(String name, double balance){
        super(name, balance);
    }
    
    /*if the the amount left in the account is invalid after the transaction,
     * return -1 to signify a failed transaction
     */
    
     public double editBalance(double change) {
         if (this.getBalance() + change > 0) {
            this.setBalance(this.getBalance() + change);
            this.setBalance(this.getBalance() - transactionFee);
            return 1;      
    }
         return -1;
     }

static final double transactionFee = .10;


}
