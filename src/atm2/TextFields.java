package atm2;

import javax.swing.*;
import java.awt.*;

public class TextFields extends JTextField {



    TextFields(String text){


        this.setText(text);
        this.setBounds(630 , 300, 350 , 50);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setFont(new Font("Arial Black" , Font.PLAIN , 15));
        this.setCaretColor(new Color(0,0,0));
    }
}
