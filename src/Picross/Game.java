package Picross;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JPanel {

    ArrayList<ArrayList<Tile>> buttons;
    PicrossBoard picross;

    Game(AListener listener) {
        buttons = new ArrayList<>();
        this.setLayout(null);
        this.setBackground(Color.darkGray);


        //game panel setup

        buttons = new ArrayList<>();
        this.setLayout(null);
        this.setBackground(Color.darkGray);

        buttons.clear();

        for (int i = 0; i < picross.getSquareSize(); i++) {
            ArrayList<Tile> tmp = new ArrayList<>();
            for (int j = 0; j < picross.getSquareSize(); j++) {

                Tile jb = new Tile(j * (40 - picross.getSquareSize()), i * (40 - picross.getSquareSize()), (40 - picross.getSquareSize()), (40 - picross.getSquareSize()), listener);
                jb.addActionListener(listener);
                tmp.add(jb);

                this.add(jb);
            }
            JLabel labelX = new JLabel("");
            JLabel labelY = new JLabel("");

            for (Integer coef : picross.getCoefX().get(i)) {
                labelX.setText(labelX.getText() + coef.toString() + '\n');
            }
            for (Integer coef : picross.getCoefY().get(i)) {
                labelY.setText(labelY.getText() + "  " + coef.toString());
            }

            labelX.setBackground(Color.gray);
            labelY.setBackground(Color.gray);

            labelX.setBounds(i * (40 - picross.getSquareSize()) + (40 - picross.getSquareSize()) / 2, picross.getSquareSize() * (40 - picross.getSquareSize()), (40 - picross.getSquareSize()), 110);
            labelX.setText(convertToMultiline(labelX.getText()));
            this.add(labelX);

            labelY.setBounds(picross.getSquareSize() * (40 - picross.getSquareSize()), i * (40 - picross.getSquareSize()), 2000, (40 - picross.getSquareSize()));
            this.add(labelY);

            buttons.add(tmp);
        }
    }

    public static String convertToMultiline(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}
