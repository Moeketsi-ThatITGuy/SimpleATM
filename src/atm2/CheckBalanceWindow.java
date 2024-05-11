package atm2;



import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CheckBalanceWindow extends JFrame implements ActionListener {

    private JButton backButton;

    private TextFields textField1;









    CheckBalanceWindow() {

        

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("1.jpeg"));
        Image image2 = image.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel label1 = new JLabel(image3);
        label1.setBounds(0, 0, 900, 900);


        JLabel text = new JLabel("Your current balance is");

        text.setBounds(300, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        label1.add(text);

        textField1 = new TextFields("R " + LoginWindow.userInfo.getAccountBalance());
        textField1.setEditable(false);
        textField1.setBounds(300, 300, 350, 50);
        label1.add(textField1);
        this.add(textField1);


        backButton = new JButton();
        backButton.setText("Back");
        backButton.setVisible(true);
        backButton.setFocusable(false);
        backButton.setFont(new Font("Arial Black", Font.BOLD, 20));
        backButton.setBounds(300, 370, 150, 50);
        backButton.addActionListener(this);
        label1.add(backButton);
        this.add(backButton);


        this.setLayout(null);
        this.setSize(900, 900);
        this.setLocation(300, 0);
        this.getContentPane().setBackground(new Color(0, 0, 0));
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(label1);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton)
            new NewWindow();
    }


}