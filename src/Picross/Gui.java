package Picross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class AListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        //If Main menu

}

public class Gui extends JFrame {

    Gui(){
        AListener listener = new AListener();

        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Picross game");
        this.setIconImage(new ImageIcon("assets/pic/icon.png").getImage());
        this.setLocationRelativeTo(null);

        MainMenu start = new MainMenu(listener);

        this.setContentPane(start);
        this.setVisible(true);
    }
}

