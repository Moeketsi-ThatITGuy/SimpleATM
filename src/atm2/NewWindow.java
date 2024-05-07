package atm2;



import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class NewWindow extends JFrame implements ActionListener {



   
   private JButton button2;
   private JButton button3;

   private JButton button4;
   
   private JButton button6;

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




        button2 = new JButton("Withdrawal");
        button2.addActionListener(this);
        button2.setBounds(230 , 320 ,130,30);
        button2.setFocusable(false);
        label1.add(button2);


        button3 = new JButton("Deposit");
        button3.addActionListener(this);
        button3.setBounds(500 , 250 ,130,30);
        button3.setFocusable(false);
        label1.add(button3);


      

        button6 = new JButton("Check Balance");
        button6.addActionListener(this);
        button6.setBounds(500 , 320 ,130,30);
        button6.setFocusable(false);
        label1.add(button6);


        button4 = new JButton("Back");
        button4.addActionListener(this);
        button4.setBounds(370 , 400 ,130,30);
        button4.setFocusable(false);
        label1.add(button4);





        this.setLayout(null);
        this.setSize(900 , 900);
        this.setLocation(300 , 0);
        this.getContentPane().setBackground(new Color(0,0,0));
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(text);
        this.add(label1);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

         if (e.getSource() == button2) {
            this.dispose();
             new WithdrawalWindow();

        }else if(e.getSource() == button3) {
            this.dispose();
              new DepositWindow();

        }else if (e.getSource() == button4){
            this.dispose();
            new LoginWindow();






    }

   


    }
}
