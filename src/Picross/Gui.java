package Picross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Gui extends JFrame implements ActionListener{

    Gui(){


        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Picross game");
        this.setIconImage(new ImageIcon("assets/pic/icon.png").getImage());
        this.setLocationRelativeTo(null);

        MainMenu start = new MainMenu(this);

        this.setContentPane(start);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

