package Picross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Gui extends JFrame implements ActionListener{

    MainMenu start;
    Game game;
    ChoiceLvl lvlSelector;

    Gui(){


        this.setSize(700, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Picross game");
        this.setIconImage(new ImageIcon("assets/pic/icon.png").getImage());
        this.setLocationRelativeTo(null);

        lvlSelector = new ChoiceLvl(this);
        game = new Game(this);
        start = new MainMenu(this);
        this.setContentPane(start);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.getContentPane() == start) {
            if (e.getSource() == start.getHard()){
                lvlSelector.setPath("assets/picrossFiles/hard");
                this.setContentPane(lvlSelector);
                this.setVisible(true);

            }else if (e.getSource() == start.getMedium()) {
                lvlSelector.setPath("assets/picrossFiles/medium");
                this.setContentPane(lvlSelector);
                this.setVisible(true);

            }else if (e.getSource() == start.getEasy()) {
                lvlSelector.setPath("assets/picrossFiles/easy");
                this.setContentPane(lvlSelector);
                this.setVisible(true);

            }
        }

        if (this.getContentPane() == lvlSelector) {

            for (JButton iter : lvlSelector.getLvls()) {

                if (e.getSource() == iter) {

                    if (iter.getText() == "Back"){

                        this.setContentPane(start);
                        this.setVisible(true);
                    } else {

                        game.setPath(lvlSelector.getFolderPath() + "/" + iter.getText());
                        this.setContentPane(game);
                        this.setVisible(true);
                    }
                }
            }
        }

        if (this.getContentPane() == game) {

            if (e.getSource() == game.getBack()) {

                this.setContentPane(lvlSelector);
                this.setVisible(true);
            }
            for (ArrayList<Tile> iterI : game.getButtons()) {

                for (Tile iterJ : iterI ) {

                    if (e.getSource() == iterJ) {

                        iterJ.setState(iterJ.getState() + 1);
                    }
                }
            }
        }
    }
}

