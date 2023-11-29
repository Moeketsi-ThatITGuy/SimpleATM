/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm2;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author moeketsi
 */
public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JFrame frame;

    public MyFrame(){


        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("1.jpeg"));
       Image image2 = image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon image3 = new ImageIcon(image2);
       JLabel label1 = new JLabel(image3);
       label1.setBounds(0 , 0 , 900 , 900);

        JLabel text = new JLabel("Welcome to ATM");

        text.setBounds(300 , 300 , 700 , 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        label1.add(text);
        this.add(text);







        button = new JButton();
        button.addActionListener(this);
        button.setFocusable(false);
        button.setText("PRESS HERE");
        button.setFont(new Font("Arial Black" , Font.BOLD , 20));
        button.setBounds(300 , 350, 300 , 50);
        label1.add(button);
        this.add(button);






        this.setTitle("ATM");
        this.setSize(900 , 900);
        this.setLocation(300 , 0);
        this.getContentPane().setBackground(new Color(0,0,0));
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);

       // this.add(button);
        this.add(label1);






    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            this.dispose();
            new LoginWindow();

        }

    }

}
