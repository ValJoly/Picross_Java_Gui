package Picross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game extends JPanel {

    private ArrayList<ArrayList<Tile>> buttons;
    private ActionListener listener;
    private JButton back;
    private PicrossBoard picross;

    Game(Gui guiListener) {

        //game panel setup
        listener = guiListener;
        buttons = new ArrayList<>();

        back = new JButton("Back");
        back.setBounds(550, 550, 100, 100);
        back.addActionListener(listener);

        this.setLayout(null);
        this.setBackground(Color.darkGray);
        this.picross = new PicrossBoard();
    }

    public void setPath(String path) {
        //Creation a new pricrossB object
        picross = new PicrossBoard(path);

        buttons.clear();
        for (int i = this.getComponentCount() - 1; i >= 0; i--) {
            this.remove(i);
        }

        //add the back button in game page
        this.add(back);

        //add all the button and label to draw the board game
        for (int i = 0; i < picross.getSquareSize(); i++) {
            ArrayList<Tile> tmp = new ArrayList<>();
            //add the buttons
            for (int j = 0; j < picross.getSquareSize(); j++) {

                Tile jb = new Tile(j * (40 - picross.getSquareSize()), i * (40 - picross.getSquareSize()), (40 - picross.getSquareSize()), (40 - picross.getSquareSize()), listener);
                jb.addActionListener(listener);
                tmp.add(jb);

                this.add(jb);
            }
            //add the labels
            JLabel labelX = new JLabel("");
            JLabel labelY = new JLabel("");

            for (Integer coef : picross.getCoefX().get(i)) {
                labelX.setText(labelX.getText() + coef.toString() + '\n');
            }
            for (Integer coef : picross.getCoefY().get(i)) {
                labelY.setText(labelY.getText() + "  " + coef.toString());
            }

            labelX.setForeground(Color.white);
            labelY.setForeground(Color.white);

            labelX.setBounds(i * (40 - picross.getSquareSize()) + (40 - picross.getSquareSize()) / 2, picross.getSquareSize() * (40 - picross.getSquareSize()), (40 - picross.getSquareSize()), 110);
            labelX.setText(convertToMultiline(labelX.getText()));
            this.add(labelX);

            labelY.setBounds(picross.getSquareSize() * (40 - picross.getSquareSize()), i * (40 - picross.getSquareSize()), 2000, (40 - picross.getSquareSize()));
            this.add(labelY);

            buttons.add(tmp);
        }
    }

    //Getter and setter
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
        //creation of a new array list to convert the buttons to a matrix of 1 and 0
        ArrayList<ArrayList<Integer>> verif = new ArrayList<>();
        //filling the matrix
        for (int i = 0; i < buttons.size(); i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < buttons.get(0).size(); j++) {

                if (buttons.get(i).get(j).getState() == 2 || buttons.get(i).get(j).getState() == 0) {
                    tmp.add(0);
                }else {
                    tmp.add(1);
                }
            }
            verif.add(tmp);
        }
        //testing if both, the solution and the current map are the same
        for(int i = 0; i < picross.getMap().size(); i++) {
            for (int j = 0; j < picross.getMap().size(); j++) {
                if (verif.get(i).get(j) != picross.getMap().get(i).get(j)) {
                    return false;
                }
            }
        }

        return true;
    }
    //Function to transform the text of the label in multiline using HTML tags (cause \n don't work)
    public static String convertToMultiline(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}
