package notePad;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class notePad  extends JFrame implements ActionListener {

    JMenuBar menu=new JMenuBar();
    JMenu file=new JMenu("File");
    JMenu edit=new JMenu("Edit");
    JMenu help=new JMenu("Help");

    //items for File
    JMenuItem newFile=new JMenuItem("New");
    JMenuItem Open=new JMenuItem("Open");
    JMenuItem save=new JMenuItem("Save");
    JMenuItem print=new JMenuItem("Print");
    JMenuItem exit=new JMenuItem("Exit");


    //items for Edit
    JMenuItem copy=new JMenuItem("Copy");
    JMenuItem cut=new JMenuItem("Cut");
    JMenuItem paste=new JMenuItem("Paste");
    JMenuItem selectAll=new JMenuItem("Select All");
    JMenuItem about=new JMenuItem("About");


    //textarea
    JTextArea txtarea=new JTextArea();


    notePad(){
        //title of app
        setTitle("NotePad");

        //setting size of frame
        setBounds(100,100,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Adding menu to top
        setJMenuBar(menu);

        //adding menu items to menu
        menu.add(file);
        menu.add(edit);
        menu.add(help);

        //adding items for File
        file.add(newFile);
        file.add(Open);
        file.add(save);
        file.add(print);
        file.add(exit);

        //adding items for Edit
        edit.add(copy);
        edit.add(cut);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(about);


        JScrollPane scrlpane=new JScrollPane(txtarea);
        add(scrlpane);
        txtarea.setFont(new Font(Font.SERIF,Font.PLAIN,18));
        txtarea.setLineWrap(true);
        txtarea.setWrapStyleWord(true);
        scrlpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrlpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //for single border below menu
        scrlpane.setBorder(BorderFactory.createEmptyBorder());

        newFile.addActionListener(this);
        Open.addActionListener(this);
        save.addActionListener(this);
        print.addActionListener(this);
        paste.addActionListener(this);
        exit.addActionListener(this);
        copy.addActionListener(this);
        cut.addActionListener(this);
        selectAll.addActionListener(this);
        about.addActionListener(this);


            //shortcuts
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_DOWN_MASK));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("new"))
            {
                txtarea.setText(null);
            }
            else if (e.getActionCommand().equalsIgnoreCase("Open")) {

                JFileChooser chooser=new JFileChooser();
                FileNameExtensionFilter filter=new FileNameExtensionFilter("only text files","txt");
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.addChoosableFileFilter(filter);

                int action=chooser.showOpenDialog(null);
                if(action!=JFileChooser.APPROVE_OPTION)
                {
                    return;
                }
                else
                {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                        txtarea.read(reader,null);
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
            else if (e.getActionCommand().equalsIgnoreCase("save")) {
                JFileChooser chooser=new JFileChooser();
                FileNameExtensionFilter filter=new FileNameExtensionFilter("only text files","txt");
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.addChoosableFileFilter(filter);
                int action=chooser.showSaveDialog(null);

                if(action!=JFileChooser.APPROVE_OPTION)
                {
                    return;
                }
                else
                {
                    String fileName=chooser.getSelectedFile().getAbsolutePath().toString();
                    if(fileName.contains(".txt"))
                    {
                        fileName=fileName+".txt";
                    }

                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                        txtarea.write(writer);
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                }


            }
            else if (e.getActionCommand().equalsIgnoreCase("print")) {
                try {
                    txtarea.print();
                }
                catch (PrinterException ex)
                {
                    Logger.getLogger(notePad.class.getName()).log(Level.SEVERE,null,ex);
                }

            }
            else if (e.getActionCommand().equalsIgnoreCase("exit")) {

                System.exit(0);

            }
            else if (e.getActionCommand().equalsIgnoreCase("cut")) {
                txtarea.cut();

            }
            else if (e.getActionCommand().equalsIgnoreCase("copy")) {
                    txtarea.copy();
            }
            else if (e.getActionCommand().equalsIgnoreCase("paste")) {
                    txtarea.paste();
            }
            else if (e.getActionCommand().equalsIgnoreCase("select All")) {
                    txtarea.selectAll();
            }
            else if (e.getActionCommand().equalsIgnoreCase("about")) {
                aboutSection abt=new aboutSection();
                abt.setVisible(true);
            }


    }
}





