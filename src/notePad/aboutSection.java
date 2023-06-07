package notePad;

import javax.swing.*;
import java.awt.*;

public class aboutSection extends JFrame {

    aboutSection()
    {
        setBounds(100,100,500,400);
        setTitle("About NotePad");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon=new ImageIcon(getClass().getResource("notepad.jpg"));
        setIconImage(icon.getImage());
        setLayout(null);


        JLabel txt=new JLabel("""
               <html>
               <body>
               <h3 align="center">NotePad Clone</h3>
               <br>
               <br>
               This is a replica of MicroSoft NotePad.This is done using Java with swing.
               
               <br>
               <br>
               <br>
               <h3 align="center">Thank You </h3>
               </body>
               </html> 
               
                """);
        txt.setBounds(100,50,300,300);
        txt.setFont(new Font(Font.SERIF,Font.PLAIN,14));
        add(txt);
    }


}
