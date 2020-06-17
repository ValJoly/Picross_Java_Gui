package Picross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LvlEditor extends JPanel {

	private ArrayList<ArrayList<Tile>> buttons;
	private ActionListener listener;
	private JButton back;
	private JButton write;
	private PicrossBoard picross;
	private String writePath;


	LvlEditor(ActionListener listener) {

		buttons = new ArrayList<>();
		this.listener = listener;
		this.picross = new PicrossBoard();
		this.writePath = new String("assets/picrossFiles/");

		back = new JButton("Back");
		back.setBounds(550, 550, 100, 100);
		back.addActionListener(listener);
		back.setBackground(Color.white);

		write = new JButton("write");
		write.setBounds(30, 550, 100, 100);
		write.addActionListener(listener);
		write.setBackground(Color.white);

		this.setLayout(null);
		this.setBackground(Color.darkGray);

	}

	public JButton getBack() {
		return back;
	}

	public void setDifficulty(String path) {
		buttons.clear();

		for (int i = this.getComponentCount() - 1; i >= 0; i--) {
			this.remove(i);
		}
		this.add(back);
		this.add(write);
		writePath += path;

		switch (path) {
			case "easy" :
				this.picross.setSquareSize(10);
				break;
			case "medium" :
				this.picross.setSquareSize(15);
				break;
			case "hard" :
				this.picross.setSquareSize(20);
				break;
		}

		buttons.clear();
		for (int i = 0; i < this.picross.getSquareSize(); i++) {
			ArrayList<Tile> tmp = new ArrayList<>();
			for (int j = 0; j < this.picross.getSquareSize(); j++) {
				Tile tile = new Tile(j * (40 - this.picross.getSquareSize()), i * (40 - this.picross.getSquareSize()), (40 - this.picross.getSquareSize()), (40 - this.picross.getSquareSize()), listener);
				tmp.add(tile);
				this.add(tile);
			}
			buttons.add(tmp);
		}
	}

	public JButton getWrite() {
		return write;
	}

	public PicrossBoard getPicross() {
		return picross;
	}

	public ArrayList<ArrayList<Tile>> getButtons() {
		return buttons;
	}
}
