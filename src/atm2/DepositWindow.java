package atm2;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DepositWindow extends JFrame implements ActionListener {


    Frames frame;
    private  TextFields depositField;

    private JButton depositButton;

    private static String accountNumber;

    private String amount;

    private static  int verifiedAmount;

   



    private int getAccountValue;

    private static int newAmount = 0;

    private JButton goBack;

    






    DepositWindow() {


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
        if(e.getSource() == depositButton){
        amount =depositField.getText();
      

        if(amount.isEmpty() ){
            JOptionPane.showMessageDialog( this , "Enter amount you wish to deposit" , "Error" , JOptionPane.ERROR_MESSAGE);
        }
        else if(!amount.isEmpty()){
            verifiedAmount = Integer.parseInt(amount);
            int getAccountValue = LoginWindow.userInfo.getAccountBalance();
             getAccountValue = getAccountValue + verifiedAmount;
             LoginWindow.userInfo.setAccountBalance(getAccountValue);
            JOptionPane.showMessageDialog(this , "Deposit complete" , "Success" , JOptionPane.PLAIN_MESSAGE);
            new NewWindow();
        }

    }
    else{
        this.dispose();
        new NewWindow();

    } 
        



    }

   


    


}
