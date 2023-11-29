package atm2;


import atm2.Button;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class NewWindow extends JFrame implements ActionListener {



    JButton button1;
    JButton button2;
    JButton button3;

    JButton button4;
    JButton button5;
    JButton button6;

    NewWindow() {



        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("1.jpeg"));
        Image image2 = image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel label1 = new JLabel(image3);
        label1.setBounds(0 , 0 , 900 , 900);


        JLabel text = new JLabel("Select what you want to do");

        text.setBounds(300 , 200 , 700 , 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        label1.add(text);



        button1 = new JButton("Transfer");
        button1.addActionListener(this);
        button1.setBounds(230 , 250 ,130,30);
        button1.setFocusable(false);
        label1.add(button1);

        button2 = new JButton("Withdrawal");
        button2.addActionListener(this);
        button2.setBounds(230 , 320 ,130,30);
        button2.setFocusable(false);
        label1.add(button2);


        button3 = new JButton("Deposit");
        button3.addActionListener(this);
        button3.setBounds(230 , 380 ,130,30);
        button3.setFocusable(false);
        label1.add(button3);


        button5 = new JButton("Statement");
        button5.addActionListener(this);
        button5.setBounds(450 , 250 ,130,30);
        button5.setFocusable(false);
        label1.add(button5);

        button6 = new JButton("Check Balance");
        button6.addActionListener(this);
        button6.setBounds(450 , 320 ,130,30);
        button6.setFocusable(false);
        label1.add(button6);


        button4 = new JButton("Back");
        button4.addActionListener(this);
        button4.setBounds(450 , 380 ,130,30);
        button4.setFocusable(false);
        label1.add(button4);





        this.setLayout(null);
        this.setSize(900 , 900);
        this.setLocation(300 , 0);
        this.getContentPane().setBackground(new Color(0,0,0));
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(text);
        this.add(label1);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            this.dispose();
              new TransferWindow();

        } else if (e.getSource() == button2) {
            this.dispose();
             new WithdrawalWindow();

        }else if(e.getSource() == button3) {
            this.dispose();
              new DepositWindow();

        }else if (e.getSource() == button4){
            this.dispose();
            new LoginWindow();

        }else if(e.getSource() == button5){
            this.dispose();
             new StatementWindow();

        }else if(e.getSource() == button6)
            this.dispose();
          //  CheckBalanceWindow checkBalanceWindow = new CheckBalanceWindow();





    }


}
