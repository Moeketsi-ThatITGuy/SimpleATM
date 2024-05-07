package atm2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UserInformationClass extends JFrame implements ActionListener {

 private String accountNumber;
 private String userPin;
 private int accountBalance = 0;

 UserInformationClass(String accountNumberRecieved , String Pin){
    
    
  
       if(this.accountNumber ==null){
           this.accountNumber = accountNumberRecieved;
           this.userPin = Pin;
       }
       else
       JOptionPane.showMessageDialog(this ,"Cant give user accounts" , "Error" , JOptionPane.INFORMATION_MESSAGE );

   }



   public int getAccountBalance(){

    return accountBalance;
   }

   public void setAccountBalance(int amount){
     
      this.accountBalance = amount;

   }

   public String getPin(){

      return this.userPin;
   }

   public String getAccountNumber(){

      return this.accountNumber;
   }





 }






