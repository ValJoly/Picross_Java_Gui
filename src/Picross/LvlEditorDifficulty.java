package Picross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LvlEditorDifficulty extends JPanel {

    private JButton hard;
    private JButton medium;
    private JButton easy;
    private JButton back;
    private JLabel difficulty;



    LvlEditorDifficulty(ActionListener listener){

        this.setLayout(null);
        this.setSize(700, 700);

        hard = new JButton("20x20 Hard");
        hard.setBackground(Color.white);

        medium = new JButton("15x15 Medium");
        medium.setBackground(Color.white);

        easy = new JButton("10x10 Easy");
        easy.setBackground(Color.white);

        back = new JButton("Back");
        back.setBackground(Color.white);

        difficulty = new JLabel("Choose the size of your creation:");
        difficulty.setForeground(Color.white);

        difficulty.setBounds(this.getBounds().width / 2 - 85, this.getBounds().height * 1 / 7, 200, 50);
        easy.setBounds(this.getBounds().width / 2 - 75, this.getBounds().height * 2 / 7, 150, 50);
        medium.setBounds(this.getBounds().width / 2 - 75, this.getBounds().height * 3 / 7, 150, 50);
        hard.setBounds(this.getBounds().width / 2 - 75, this.getBounds().height * 4 / 7, 150, 50);
        back.setBounds(this.getBounds().width / 2 - 75, this.getBounds().height * 5 / 7, 150, 50);

        easy.addActionListener(listener);
        medium.addActionListener(listener);
        hard.addActionListener(listener);
        back.addActionListener(listener);

        this.add(difficulty);
        this.add(easy);
        this.add(medium);
        this.add(hard);
        this.add(back);
        this.setBackground(Color.darkGray);
    }

    public JButton getHard() {
        return hard;
    }

    public void setHard(JButton hard) {
        this.hard = hard;
    }

    public JButton getMedium() {
        return medium;
    }

    public void setMedium(JButton medium) {
        this.medium = medium;
    }

    public JButton getEasy() {
        return easy;
    }

    public void setEasy(JButton easy) {
        this.easy = easy;
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }
}
