
package atm2;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;




public class LoginWindow extends JFrame implements ActionListener {


    private TextFields textField1;

    private JPasswordField textField2;


    private JButton button;
    private JButton button2;
    

    

    static  String accountNumber;
    static String password;
    static String accountNumberGenerated;
    static UserInformationClass userInfo;
    





  



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

        

        button2 = new JButton();
        button2.setText("New User");
        button2.setVisible(true);
        button2.setFocusable(false);
        button2.setFont(new Font("Arial Black" , Font.BOLD , 20));
        button2.setBounds(520, 430, 150, 50);
        button2.addActionListener(this);
        label1.add(button2);
        this.add(button2);





        this.setSize(900 , 900);
        this.setLocation(300 , 0);
         this.getContentPane().setBackground(new Color(0,0,0));
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.add(label1);







    }


    


        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button){
            accountNumber = textField1.getText();
            password = String.valueOf(textField2.getPassword());
            if(accountNumber.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(this ,"Please enter all fields" , "Error" , JOptionPane.ERROR_MESSAGE );
    
            }
            else
                userLogin(accountNumber , password);
    
        }
        else if(e.getSource() == button2){
               accountNumberGenerated = accountNumberGenerator();
               this.dispose();
               new NewUserPage();

        }
    
    
            }


    private void userLogin(String accountNumber , String password) {
                 UserInformationClass[] userInfoArray = NewUserPage.getUserArray();
                 for(int i = 0; i < userInfoArray.length; i++){
                 userInfo = userInfoArray[i];
                  if(userInfo == null){
                 JOptionPane.showMessageDialog(this , "account array is null" , "Error" , JOptionPane.INFORMATION_MESSAGE);
              
                   break;
                 }
                 String userAccountNumber = userInfo.getAccountNumber();
                 String userPin = userInfo.getPin();
                 if(userAccountNumber.equals(accountNumber) && userPin.equals( password) ){
                this.dispose();
                JOptionPane.showMessageDialog(this , "Login successful" , "Error" , JOptionPane.INFORMATION_MESSAGE);
                 new NewWindow();
                     break;
                 }
                 else if(i == userInfoArray.length - 1){
                    JOptionPane.showMessageDialog(this , "account not found" , "Error" , JOptionPane.INFORMATION_MESSAGE);
                   
                 }
                 }
                

         

    }
    private String accountNumberGenerator(){
        String accountNumber= "";
        Random random = new Random();

        for(int i = 0 ; i < 10 ; i++){

            int getRandom = random.nextInt(10);
            accountNumber = accountNumber + getRandom;
        }

        return accountNumber.trim();
       

    }
    }

