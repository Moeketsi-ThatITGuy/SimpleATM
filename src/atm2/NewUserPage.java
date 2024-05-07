package atm2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewUserPage extends JFrame implements ActionListener {


    
    private TextFields textField1;

    private JPasswordField textField2;


    private JButton button;
    private JButton button2;

 
    private static UserInformationClass[] userInfoArray =  new UserInformationClass[10];

    static  String accountNumber;
    static String password;

    static UserInformationClass userInfo;
     

  

    NewUserPage() {



        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("1.jpeg"));
        Image image2 = image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel label1 = new JLabel(image3);
        label1.setBounds(0 , 0 , 900 , 900);

        JLabel text = new JLabel("Your new Account Number:");

        text.setBounds(300 , 220 , 700 , 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        label1.add(text);



        textField1 = new TextFields("");
        textField1.setVisible(true);
        textField1.setText(LoginWindow.accountNumberGenerated);
        textField1.setBounds(300, 270, 350, 50);
        textField1.setEditable(false);
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
        button.setText("Create");
        button.setVisible(true);
        button.setFocusable(false);
        button.setFont(new Font("Arial Black" , Font.BOLD , 20));
        button.setBounds(300, 430, 150, 50);
        button.addActionListener(this);
        label1.add(button);
        this.add(button);

        

        button2 = new JButton();
        button2.setText("Back");
        button2.setVisible(true);
        button2.setFocusable(false);
        button2.setFont(new Font("Arial Black" , Font.BOLD , 20));
        button2.setBounds(520, 430, 150, 50);
        button2.addActionListener(this);
        label1.add(button);
        this.add(button);





        this.setSize(900 , 900);
        this.setLocation(300 , 0);
         this.getContentPane().setBackground(new Color(0,0,0));
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.add(label1);







    }



    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
        accountNumber = textField1.getText();
        password = String.valueOf(textField2.getPassword());
        if( password.isEmpty()){
            JOptionPane.showMessageDialog(this ,"Please enter your pin" , "Error" , JOptionPane.ERROR_MESSAGE );

        }
        else if(password.length() > 4 ){

            JOptionPane.showMessageDialog(this ,"Pin must be 4 characters" , "Error" , JOptionPane.ERROR_MESSAGE );
        }
        else{
            getUsersInformation(accountNumber, password);
            this.dispose();
            new NewWindow();

        }
    }





        }


private void getUsersInformation(String accountNumber , String pin){
           
         userInfo = new UserInformationClass(accountNumber, pin);

         for(int i = 0;  i <  userInfoArray.length; i++){

            if(userInfoArray[i] == null){
            userInfoArray[i] = userInfo;
            LoginWindow.userInfo = userInfo;
            break;
                
            }
            
         }

        }

public static UserInformationClass[] getUserArray(){

    return userInfoArray;
}
  
}
