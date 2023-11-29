package atm2;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DepositWindow extends JFrame implements ActionListener {


    Frames frame;
    TextFields depositField;




    JButton depositButton;


    static String accountNumber;

    String ammount;

    static  int verifiedAmmount;

    Resultset rs;

    int rsValue = 0;

    int getAccountValue;

    static int newAmount;

    JButton goBack;




    DepositWindow() {

        getAccountValue = getAccountValue(LoginWindow.accountNumber);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("1.jpeg"));
        Image image2 = image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel label1 = new JLabel(image3);
        label1.setBounds(0 , 0 , 900 , 900);



        JLabel text = new JLabel("Amount you want to deposit");

        text.setBounds(300 , 250 , 700 , 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        label1.add(text);

        depositField = new TextFields("");
        depositField.setBounds(300, 300, 350, 50);
        label1.add(depositField);
        this.add(depositField);






        depositButton = new JButton();
        depositButton.setText("Deposit");
        depositButton.setVisible(true);
        depositButton.setFocusable(false);
        depositButton.setFont(new Font("Arial Black" , Font.BOLD , 20));
        depositButton.setBounds(300, 370, 150, 50);
        depositButton.addActionListener(this);
        label1.add(depositButton);
        this.add(depositButton);

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




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ammount =depositField.getText();
        verifiedAmmount = Integer.parseInt(ammount);

        if(ammount.isEmpty()){
            JOptionPane.showMessageDialog( this , "Enter amount you wish to deposit" , "Error" , JOptionPane.ERROR_MESSAGE);
        }
        else if(!ammount.isEmpty()){
            newAmount = getAccountValue + verifiedAmmount;
            newUpdatedAmount(newAmount);
            JOptionPane.showMessageDialog(this , "Deposit complete" , "Success" , JOptionPane.PLAIN_MESSAGE);
            new Transactions("Deposit");
            new NewWindow();
        }





    }

    public int getAccountValue(  String accountNumberLoggedinWith){
        accountNumber = accountNumberLoggedinWith;
        Connection dbcon =  DatabaseConnection.dbConnection();
        Connection con = DatabaseConnection.conn;
        String sql = "select balance from accounts where  client_account_number = '"+DepositWindow.accountNumber+"' ";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);



            while( rs.next()) {
                rsValue = rs.getInt("balance");
            }
            return rsValue;


        } catch (Exception e) {
            System.out.println("Cant find connection for deposit");
        }

        return 0;
    }

    public void newUpdatedAmount( int newAmount){
        Connection getConnection = DatabaseConnection.dbConnection();
        Connection connection = DatabaseConnection.conn;

        String sql = "update accounts set balance = '"+  newAmount +"' where client_account_number = '"+ LoginWindow.accountNumber +"' ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            int count = st.executeUpdate();

            System.out.println(count + " rows affected");






        } catch (Exception e) {
            System.out.println("Couldnt update Balance");
            JOptionPane.showMessageDialog(this , "Couldnt update balance ","Error " , JOptionPane.ERROR_MESSAGE);
        }


    }


}