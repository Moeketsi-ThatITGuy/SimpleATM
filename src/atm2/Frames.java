package atm2;

import javax.swing.*;
import java.awt.*;


public class Frames extends JFrame{


        Frames() {
            //frame = new JFrame();
            this.setSize(1500, 750);
            this.getContentPane().setBackground(new Color(135, 206, 235));
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //this.setLayout(new GridLayout(3, 2, 5, 5));
            this.setVisible(true);

        }


}
