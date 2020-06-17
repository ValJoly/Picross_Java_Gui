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
    LvlEditorDifficulty lvlEdDiff;
    LvlEditor lvlEditor;

    Gui(){


        this.setSize(700, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Picross game");
        this.setIconImage(new ImageIcon("assets/pic/icon.png").getImage());
        this.setLocationRelativeTo(null);

        lvlEdDiff = new LvlEditorDifficulty(this);
        lvlEditor = new LvlEditor(this);
        lvlSelector = new ChoiceLvl(this);
        game = new Game(this);
        start = new MainMenu(this);
        this.setContentPane(start);
        this.setVisible(true);
    }

    //method where all the action will be treated
    @Override
    public void actionPerformed(ActionEvent e) {

        //case when we are in the main menu
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

            }else if (e.getSource() == start.getEdition()) {
                this.setContentPane(lvlEdDiff);
                this.setVisible(true);
            }
        }

        //case when we are in the level selector
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

        //case when we are in the game
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
            if (this.game.isFinish()) {
                JOptionPane finish;

                //End of the game -> pop up
                finish = new JOptionPane();
                finish.showMessageDialog(null, "You successfully complete this level", "lvl finished", JOptionPane.INFORMATION_MESSAGE);

                this.setContentPane(start);
            }
        }
        if (this.getContentPane() == lvlEdDiff) {
            if (e.getSource() == lvlEdDiff.getBack()) {
                this.setContentPane(start);
                this.setVisible(true);
            } else if (e.getSource() == lvlEdDiff.getEasy()) {
                this.lvlEditor.setDifficulty("easy");
                this.setContentPane(lvlEditor);
                this.setVisible(true);
            } else if (e.getSource() == lvlEdDiff.getMedium()) {
                this.lvlEditor.setDifficulty("medium");
                this.setContentPane(lvlEditor);
                this.setVisible(true);
            } else if (e.getSource() == lvlEdDiff.getHard()) {
                this.lvlEditor.setDifficulty("hard");
                this.setContentPane(lvlEditor);
                this.setVisible(true);
            }
        }
        if (this.getContentPane() == lvlEditor) {
            if (e.getSource() == this.lvlEditor.getBack()) {
                this.setContentPane(lvlEdDiff);
                this.setVisible(true);
            } else if (e.getSource() == this.lvlEditor.getWrite()) {

                System.out.println(this.lvlEditor.getPicross());
                this.setContentPane(lvlEdDiff);
                this.setVisible(true);
            }else {
                for (int i = 0; i < this.lvlEditor.getPicross().getSquareSize(); i++) {
                    for (int j = 0; j < this.lvlEditor.getPicross().getSquareSize(); j++) {
                        if (e.getSource() == this.lvlEditor.getButtons().get(i).get(j)) {

                            this.lvlEditor.getButtons().get(i).get(j).setState((this.lvlEditor.getButtons().get(i).get(j).getState() + 1) % 2);
                            this.lvlEditor.getPicross().setIndex(i, j, this.lvlEditor.getButtons().get(i).get(j).getState());

                        }
                    }
                }
            }
        }
    }
}

