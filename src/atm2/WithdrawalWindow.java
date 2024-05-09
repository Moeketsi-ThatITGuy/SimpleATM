package atm2;



import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WithdrawalWindow extends JFrame implements ActionListener {

    JButton withdrawalButton;

    TextFields textField1;

     static String accountNumber;


    private String amount;

   private static  int verifiedAmount;


    int getAccountValue;

   static int newAmount;

   JButton goBack;






    WithdrawalWindow() {

        getAccountValue = LoginWindow.userInfo.getAccountBalance();


        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("1.jpeg"));
        Image image2 = image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel label1 = new JLabel(image3);
        label1.setBounds(0 , 0 , 900 , 900);



        JLabel text = new JLabel("your available balance is " + getAccountValue);

        text.setBounds(300 , 230 , 700 , 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        label1.add(text);

        textField1 = new TextFields("");
        textField1.setBounds(300, 270, 350, 50);
        label1.add(textField1);
        this.add(textField1);






        withdrawalButton = new JButton();
        withdrawalButton.setText("Withdraw");
        withdrawalButton.setVisible(true);
        withdrawalButton.setFocusable(false);
        withdrawalButton.setFont(new Font("Arial Black" , Font.BOLD , 20));
        withdrawalButton.setBounds(300, 360, 150, 40);
        withdrawalButton.addActionListener(this);
        label1.add(withdrawalButton);
        this.add(withdrawalButton);

        
        goBack = new JButton("Back");
        goBack.addActionListener(this);
        goBack.setBounds(300 , 440 ,130,30);
        goBack.setFocusable(false);
        label1.add(goBack);

 




        this.setLayout(null);
        this.setSize(900 , 900);
        this.setLocation(300 , 0);
        this.getContentPane().setBackground(new Color(0,0,0));
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(label1);
        ;



    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == withdrawalButton){ 
                
            amount = textField1.getText();
           if(amount.isEmpty()){
               JOptionPane.showMessageDialog( this , "Enter amount you with to withdraw" , "Error" , JOptionPane.ERROR_MESSAGE);   
            }

            if(!amount.isEmpty()){
             verifiedAmount = Integer.parseInt(amount);
             if(getAccountValue > verifiedAmount){
                  newAmount = getAccountValue - verifiedAmount;
                  LoginWindow.userInfo.setAccountBalance(newAmount);
                  JOptionPane.showMessageDialog(this , "Successful Withdrawal" , "Success" , JOptionPane.PLAIN_MESSAGE);
                  this.dispose();
                  new NewWindow();
             }
             else if (verifiedAmount > getAccountValue )
               JOptionPane.showMessageDialog(this , "Insufficient funds , Check your balance" , "Error" , JOptionPane.ERROR_MESSAGE);
           }
           
        }
        else
         new NewWindow(); 
    }

}
    






