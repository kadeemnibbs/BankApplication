/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;
import java.util.*;
/**
 *
 * @author kanibbs
 */
public class ListOfAccounts {
    
    public ArrayList<Account> accounts;
    private String currentName;
    private double currentBalance;
    
    public ListOfAccounts(){
        accounts = new ArrayList<Account>();
        initializeAccountList();
    }
    
    public void initializeAccountList(){
        accounts.add(new SavingsAccount("Kadeem", 10000)); 
        accounts.add(new CheckingAccount("Charles", 545)); 
        accounts.add(new SavingsAccount("Kris", 820)); 
        accounts.add(new CheckingAccount("Dilip", 1064)); 
        accounts.add(new SavingsAccount("Emma", 659)); 
        accounts.add(new CheckingAccount("Ben", 8)); 
        accounts.add(new SavingsAccount("Ralph", 2286)); 
        accounts.add(new CheckingAccount("Watson", 0)); 
        accounts.add(new SavingsAccount("Frederick", 87)); 
        accounts.add(new CheckingAccount("T-Pain", 8032)); 
        accounts.add(new SavingsAccount("Johnson", 10000)); 
    }
    
    /*search through the list of accounts to find one with a matching name
     * when one is found, set the Current Balance to the balance of that 
     * account, return that account.  If there is no account with a matching name, 
     * return null.
     */
    public Account findAccount(){
        for (Account a: accounts) {
            if (a.getName().equals(this.currentName)) { 
                currentBalance = a.getBalance();
                return a;
            }                           
        }
        return null; 
    }
    
    public double editAccount(double change){
        if (findAccount().editBalance(change) > 0) {              
                return 1;                 
         }
        else return -1;
    }
    
    
    
    
    public void setCurrentName(String name){
        currentName = name;
    }
    
    public String getCurrentName(){
        return this.currentName;
    }
    
    public double getCurrentBalance(){
        return currentBalance;
    }
    
}      
    
