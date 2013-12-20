/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

/**
 *
 * @author kanibbs
 */
public class BankApplication {
    
    private BankAppGui gui;

   public void run()
    {
        gui = new BankAppGui();
    }
   
   
    public static void main(String[] args) {
        new BankApplication().run();
    }
}

