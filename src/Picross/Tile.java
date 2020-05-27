package Picross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tile extends JButton {

    private int state;

    Tile(AListener listener){
        state = 0;
        this.setBackground(Color.white);
        this.setBounds(10, 10, 10, 10);
        this.addActionListener(listener);
    }

    Tile(int x, int y, int w, int h, AListener listener){
        state = 0;
        this.setBackground(Color.white);
        this.setBounds(x, y, w, h);
        this.addActionListener(listener);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
