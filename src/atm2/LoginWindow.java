
package atm2;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginWindow extends JFrame implements ActionListener {


    TextFields textField1;

    JPasswordField textField2;


    JButton button;



     static  String accountNumber;
    static String password;





    static DatabaseConnection databaseConnection;



    LoginWindow() {



        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("1.jpeg"));
        Image image2 = image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel label1 = new JLabel(image3);
        label1.setBounds(0 , 0 , 900 , 900);

        JLabel text = new JLabel("Account Number: " );

        text.setBounds(300 , 220 , 700 , 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        label1.add(text);



        textField1 = new TextFields("");
        textField1.setBounds(300, 270, 350, 50);
        label1.add(textField1);
        this.add(textField1);

        JLabel text2 = new JLabel("Pin" );

        text2.setBounds(300 , 330 , 700 , 35);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System" , Font.BOLD , 16));
        label1.add(text2);





        textField2 = new JPasswordField( "");
        textField2.setBounds(300, 370, 350, 50);
        label1.add(textField2);
        this.add(textField2);


        button = new JButton();
        button.setText("Login");
        button.setVisible(true);
        button.setFocusable(false);
        button.setFont(new Font("Arial Black" , Font.BOLD , 20));
        button.setBounds(300, 430, 150, 50);
        button.addActionListener(this);
        label1.add(button);
        this.add(button);





        this.setSize(900 , 900);
        this.setLocation(300 , 0);
         this.getContentPane().setBackground(new Color(0,0,0));
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.add(label1);







    }


    @Override
    public void actionPerformed(ActionEvent e) {

        accountNumber = textField1.getText();
        password = String.valueOf(textField2.getPassword());
        if(accountNumber.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(this ,"Please enter all fields" , "Error" , JOptionPane.ERROR_MESSAGE );

        }
        else
            userLogin(accountNumber , password);




        }


    private void userLogin(String userName , String password) {
        Connection dbcon = DatabaseConnection.dbConnection();
        Connection con = DatabaseConnection.conn;
        try {
            String sql = "select * from accounts where client_account_number = '"+ userName + "'and client_pin = '"+ password  +"' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()){
                this.dispose();
                 new NewWindow();

            }
            else
                JOptionPane.showMessageDialog(this , "Password or username not found" , "Error" , JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.print("couldnt query database");
        }

    }
    }
