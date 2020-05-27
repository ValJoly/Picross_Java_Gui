package Picross;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    private JButton hard;
    private JButton medium;
    private JButton easy;
    private JButton edition;
    private JLabel difficulty;

    MainMenu(Gui listener) {

        this.setLayout(null);
        this.setSize(700, 700);

        hard = new JButton("Hard");
        medium = new JButton("Medium");
        easy = new JButton("Easy");
        edition = new JButton("Lvl editor");
        difficulty = new JLabel("Choose your level of difficulty :");

        difficulty.setBounds(this.getBounds().width / 2 - 85, this.getBounds().height * 1 / 7, 200, 50);
        easy.setBounds(this.getBounds().width / 2 - 75, this.getBounds().height * 2 / 7, 150, 50);
        medium.setBounds(this.getBounds().width / 2 - 75, this.getBounds().height * 3 / 7, 150, 50);
        hard.setBounds(this.getBounds().width / 2 - 75, this.getBounds().height * 4 / 7, 150, 50);
        edition.setBounds(this.getBounds().width / 2 - 75, this.getBounds().height * 5 / 7, 150, 50);

        easy.addActionListener(listener);
        medium.addActionListener(listener);
        hard.addActionListener(listener);
        edition.addActionListener(listener);

        this.add(difficulty);
        this.add(easy);
        this.add(medium);
        this.add(hard);
        this.add(edition);
        this.setBackground(Color.darkGray);

    }

    public JButton getHard() {
        return hard;
    }

    public JButton getMedium() {
        return medium;
    }

    public JButton getEasy() {
        return easy;
    }

    public JButton getEdition() {
        return edition;
    }
}
