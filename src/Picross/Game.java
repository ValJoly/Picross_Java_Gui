package Picross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game extends JPanel {

    private ArrayList<ArrayList<Tile>> buttons;
    private ActionListener listener;
    private JButton back;

    Game(Gui guiListener) {

        //game panel setup
        listener = guiListener;
        buttons = new ArrayList<>();

        back = new JButton("Back");
        back.setBounds(600, 600, 50, 50);
        back.addActionListener(listener);

        this.setLayout(null);
        this.setBackground(Color.darkGray);

    }

    public void setPath(String path) {

        PicrossBoard picross = new PicrossBoard(path);

        buttons.clear();
        for (int i = this.getComponentCount() - 1; i >= 0; i--) {
            this.remove(i);
        }

        this.add(back);

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
    public ArrayList<ArrayList<Tile>> getButtons() {
        return buttons;
    }

    public void setButtons(ArrayList<ArrayList<Tile>> buttons) {
        this.buttons = buttons;
    }

    public JButton getBack() {
        return back;
    }

    public Boolean isFinish() {
        //not yet implemented
        return false;
    }
    public static String convertToMultiline(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}
