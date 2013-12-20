package bankapplication;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kanibbs
 */
public class BankAppGui {

  
private JTextArea userTextWindow; 
private JTextArea systemTextWindow;
private final String submitLabel = "Submit";
private final String enterLabel = "Enter";
private final String invalidAccountString = "The account name that you "
        + "entered was invalid."
        + " Please enter another.";
private final String notEnoughMoneyString = "You do not have "
        + "enough money in your"
        + " account to withdraw that much money.  "
        + "Please enter a different"
        + " number.";
private final String successfulTransactionString = 
        "Your Transaction was successful.  "
        + " Have a nice day!";
private ListOfAccounts accountList;
private String name;
    
    public BankAppGui() {
        /*Initialize accountList with appropriate names and balances*/
        accountList = new ListOfAccounts();
        
        
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel userTextPanel = new JPanel();
        userTextPanel.setLayout(new BorderLayout());
       
        userTextWindow = new JTextArea(5, 10);
        userTextWindow.setEditable(true);
        userTextPanel.add(userTextWindow);
        
        
        JPanel systemTextPanel = new JPanel();
        systemTextPanel.setLayout(new BorderLayout());
        
        systemTextWindow = new JTextArea(5, 10);
        systemTextWindow.setEditable(false);
        systemTextPanel.add(systemTextWindow);
        
         
        
        final JPanel enterButtonPanel = new JPanel();
        enterButtonPanel.setLayout(new GridLayout(3, 2));
        JButton enterButton = new JButton(enterLabel);
        
        
        
        final JPanel submitButtonPanel = new JPanel();
        submitButtonPanel.setLayout(new GridLayout(3, 2));
        /* when the enterButton is pressed, find the account with the name
         *entered in the user's textbox.  if the name is valid, display the balance
         * of that account, if not, prompt the user to enter another account name.
         */
                enterButton.addActionListener(new
                ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                     accountList.setCurrentName(userTextWindow.getText());
                     if (!(accountList.findAccount() == null)){ 
                     displayBalance();
                     frame.add(submitButtonPanel, BorderLayout.SOUTH);
                     frame.remove(enterButtonPanel);
                    
                    }
                     else printInvalidAccount();
                }
                });
        enterButtonPanel.add(enterButton);
        
        /*when the submit button is pressed, store the number entered into
         * the user's textbox as "change."  Attempt to add the money to the current 
         * account.  If the transaction is valid, tell the user that the transaction was successful
         * and show the entire list of accoutns with the updated balances.
         */
        JButton submitButton = new JButton(submitLabel);
            submitButton.addActionListener(new
                ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        double change = Double.parseDouble(userTextWindow.getText()); 
                        System.out.println(change);
                          if (accountList.editAccount(change) == 1) {
                          
                              System.out.println(accountList.findAccount().getBalance());
                              userTextWindow.setText(successfulTransactionString);
                              systemTextWindow.setText("");
                              displayAccounts();
                              askforAccountName();
                              frame.add(enterButtonPanel, BorderLayout.SOUTH);
                              frame.remove(submitButtonPanel);
                          }  
                          else printNotEnoughMoney();
                    }
                });
        submitButtonPanel.add(submitButton);
        
        
        
        frame.add(systemTextPanel, BorderLayout.NORTH);
        frame.add(userTextPanel, BorderLayout.CENTER);
         frame.add(enterButtonPanel, BorderLayout.SOUTH);
         
        
        
        frame.pack();
        frame.setVisible(true);
        
        displayAccounts();
        askforAccountName();
}
    /*concatenate all of the account information, different information for each type,
     * into one string.  put this sting into the systemTextWindow.
     */
    public void displayAccounts(){
        String accountInfo = "";
        for (Account a: this.accountList.accounts){
            if (a instanceof CheckingAccount){           
            accountInfo += "Name: " + a.getName() + "| Balance: " + a.getBalance() 
                    + "| Transaction Fee: " + CheckingAccount.transactionFee + "\n";
        }
            else
                accountInfo += "Name: " + a.getName() + "| Balance: " + a.getBalance() 
                        + "| Daily Interest: " + SavingsAccount.dailyInterest + "\n";
    }
        systemTextWindow.setText(accountInfo);
    }
    
    
    public void askforAccountName(){
        systemTextWindow.setText("Please enter the name of the account you wish to access:" 
                + "\n" + systemTextWindow.getText());
    }
    
    public ListOfAccounts getListOfAccounts(){
        return this.accountList;
    }
    
    public void printInvalidAccount(){
        userTextWindow.setText("");
        displayAccounts();
        systemTextWindow.setText(invalidAccountString + "\n" + systemTextWindow.getText());
    }
    
    public void displayBalance()
    {
        userTextWindow.setText(""); 
        systemTextWindow.setText("Hello " + accountList.getCurrentName() +". Your Balance"
                + " is $" + accountList.getCurrentBalance() + "\n"
                + "Please enter amount of money to add to account.");
    }
       
    
    public void printNotEnoughMoney(){
        systemTextWindow.setText(notEnoughMoneyString);
        userTextWindow.setText("");
    }
}
