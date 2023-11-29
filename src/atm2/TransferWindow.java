package atm2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferWindow extends JFrame implements ActionListener {
    Frames frame;
    JTextField textField1;

    JTextField textField2;


    JButton button;



    String firstAmount;
    String password;

    String secondAccount;

    String r;

    int getValueofAccount;

    int getGetValueOfAccount2;

    int finalValueOfAccount2;

    static int getFinalValueOfAccount1;
     int verifiedAmountToSubtract;


    TransferWindow(){

            try{
                getValueofAccount = WithdrawalWindow.getAccountValue(LoginWindow.accountNumber);
                System.out.println(getValueofAccount);
            }catch(Exception ex){

                System.out.println("Couldnt get First account value");
                JOptionPane.showMessageDialog( this , "Unuccessful Transfer" , "Error" , JOptionPane.ERROR_MESSAGE);
            }

            ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("1.jpeg"));
            Image image2 = image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
            ImageIcon image3 = new ImageIcon(image2);
            JLabel label1 = new JLabel(image3);
            label1.setBounds(0 , 0 , 900 , 900);


            JLabel text = new JLabel("Amount you want to transfer from   " +LoginWindow.accountNumber );

            text.setBounds(300 , 220 , 700 , 35);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("System" , Font.BOLD , 16));
            label1.add(text);


            textField1 = new JTextField("");
            textField1.setBounds(300, 270, 350, 50);
            label1.add(textField1);
            this.add(textField1);

          JLabel text2 = new JLabel("Account to transfer to   " +LoginWindow.accountNumber );

         text2.setBounds(300 , 330 , 700 , 35);
         text2.setForeground(Color.WHITE);
         text2.setFont(new Font("System" , Font.BOLD , 16));
         label1.add(text2);


          textField2 = new JTextField();
          textField2.setBounds(300, 370, 350, 50);
          label1.add(textField2);
          this.add(textField2);



            button = new JButton();
            button.setText("Transfer");
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
                    firstAmount = textField1.getText();
                    secondAccount = textField2.getText();
                    verifiedAmountToSubtract = Integer.parseInt(firstAmount) ;
                    if(firstAmount.isEmpty() || secondAccount.isEmpty()){
                        JOptionPane.showMessageDialog(this , "Enter all fields to finish transfer" , "Error" , JOptionPane.ERROR_MESSAGE );
                    }
                    else
                        try {
                            getFinalValueOfAccount1 = getValueofAccount - verifiedAmountToSubtract;
                            WithdrawalWindow.newUpdatedAmount(getFinalValueOfAccount1);
                            System.out.println("updated first");
                        }catch(Exception e2){
                            System.out.println("Couldnt get Cash from first Account");
                        }
                        try {
                            getGetValueOfAccount2 = WithdrawalWindow.getAccountValue(secondAccount);
                            System.out.println(getGetValueOfAccount2);
                            finalValueOfAccount2 = getGetValueOfAccount2 + verifiedAmountToSubtract;
                            System.out.println(finalValueOfAccount2);
                            WithdrawalWindow.newUpdatedAmount(finalValueOfAccount2);
                            System.out.println("updated second");
                            JOptionPane.showMessageDialog(this , "Successful Transfer" , "Success" , JOptionPane.PLAIN_MESSAGE);
                            this.dispose();
                            new NewWindow();

                        }catch(Exception e3){
                            System.out.println("Couldnt get Value of second Account");
                            JOptionPane.showMessageDialog(this , "UnSuccessful Transfer" , "Erorr" , JOptionPane.ERROR_MESSAGE);

                        }







        }

    }


