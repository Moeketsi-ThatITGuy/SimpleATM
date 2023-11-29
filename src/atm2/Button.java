package atm2;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton{

    //JButton button;

    Button(String text)
    {
       // button = new JButton();
        this.setFocusable(false);
        this.setText(text);
        this.setFont(new Font("Arial Black" , Font.PLAIN , 20));
        //button.setBounds(605 , 350, 200 , 155);
        //button.setHorizontalAlignment(JButton.CENTER);
        //button.setVerticalAlignment(JButton.CENTER);
        this.setBackground( Color.lightGray);
    }

}
