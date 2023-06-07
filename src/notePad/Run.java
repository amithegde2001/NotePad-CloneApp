package notePad;

import javax.swing.*;

public class Run {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        notePad note = new notePad();
        note.setVisible(true);

    }
}
