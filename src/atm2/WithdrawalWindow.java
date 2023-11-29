package atm2;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class WithdrawalWindow extends JFrame implements ActionListener {

    JButton withdrawalButton;

    TextFields textField1;

     static String accountNumber;


    String ammount;

   static  int verifiedAmmount;


    static int rsValue = 0;

    int getAccountValue;

   static int newAmount;

   JButton goBack;






    WithdrawalWindow() {

         getAccountValue = getAccountValue(LoginWindow.accountNumber);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("1.jpeg"));
        Image image2 = image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel label1 = new JLabel(image3);
        label1.setBounds(0 , 0 , 900 , 900);



        JLabel text = new JLabel("Amount you want to withdraw");

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

     ;





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

            ammount = textField1.getText();
            verifiedAmmount = Integer.parseInt(ammount);



         if(ammount.isEmpty()){
               JOptionPane.showMessageDialog( this , "Enter amount you with to withdraw" , "Error" , JOptionPane.ERROR_MESSAGE);
           }



           else if(!ammount.isEmpty() && getAccountValue > verifiedAmmount){

                  newAmount = getAccountValue - verifiedAmmount;
                  newUpdatedAmount(newAmount);
                  new Transactions("Withdrawal");
                  JOptionPane.showMessageDialog(this , "Successful Withdrawal" , "Success" , JOptionPane.PLAIN_MESSAGE);
                  this.dispose();
                  new NewWindow();
           }


           else if (verifiedAmmount > getAccountValue )
               JOptionPane.showMessageDialog(this , "Insufficient funds , Check your balance" , "Error" , JOptionPane.ERROR_MESSAGE);





    }

    public static int getAccountValue(  String accountNumberLoggedinWith){
        accountNumber = accountNumberLoggedinWith;
         Connection dbcon =  DatabaseConnection.dbConnection();
         Connection con = DatabaseConnection.conn;
         String sql = "select balance from accounts where  client_account_number = '"+accountNumber+"' ";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);



            while( rs.next()) {
                rsValue = rs.getInt("balance");
            }
                return rsValue;


        } catch (Exception e) {
            System.out.println("Cant find connection");
        }

      return 0;
    }

    public static void newUpdatedAmount( int newAmount){
        Connection getConnection = DatabaseConnection.dbConnection();
        Connection connection = DatabaseConnection.conn;

        String sql = "update accounts set balance = '"+  newAmount +"' where client_account_number = '"+ WithdrawalWindow.accountNumber +"' ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
             int count = st.executeUpdate();




        } catch (Exception e) {
            System.out.println("Couldnt update Balance");
        }


    }


}


