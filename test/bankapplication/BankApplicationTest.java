/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author kanibbs
 */

public class BankApplicationTest {
    
    public BankApplicationTest(){
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    ListOfAccounts accountList = new ListOfAccounts();    
    
    @Test public void testEditSavingsBalance(){
        accountList.setCurrentName("Kadeem");
        double startMoney = accountList.findAccount().getBalance();
        accountList.editAccount(100);
        double expResult = startMoney + 100;
        expResult += (expResult * .01);
        double result = accountList.findAccount().getBalance();
        
        assertEquals(expResult, result, .01);
    }
    
    @Test public void testEditCheckingBalance(){
        accountList.setCurrentName("Charles");
        double startMoney = accountList.findAccount().getBalance();
        accountList.editAccount(100);
        double expResult = (startMoney + 100) - .1;
        double result = accountList.findAccount().getBalance();
        
        assertEquals(expResult, result, .01);
    }
    
    
}