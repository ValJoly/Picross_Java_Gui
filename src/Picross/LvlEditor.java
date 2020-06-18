package Picross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LvlEditor extends JPanel {

	private ArrayList<ArrayList<Tile>> buttons;
	private ActionListener listener;
	private JButton back;
	private JButton write;
	private PicrossBoard picross;
	private JTextField textField;
	private String writePath;


	LvlEditor(ActionListener listener) {

		this.buttons = new ArrayList<>();
		this.listener = listener;
		this.picross = new PicrossBoard();
		this.writePath = new String();

		this.textField = new JTextField("Name");
		//this.textField.setColumns(10); //On lui donne un nombre de colonnes à afficher
		this.textField.setBounds(250, 580, 150, 25);

		this.back = new JButton("Back");
		this.back.setBounds(550, 550, 100, 100);
		this.back.addActionListener(listener);
		this.back.setBackground(Color.white);

		this.write = new JButton("write");
		this.write.setBounds(30, 550, 100, 100);
		this.write.addActionListener(listener);
		this.write.setBackground(Color.white);

		this.setLayout(null);
		this.setBackground(Color.darkGray);

	}

	public void setDifficulty(String path) {
		this.buttons.clear();
		this.writePath = "assets/picrossFiles/";
		for (int i = this.getComponentCount() - 1; i >= 0; i--) {
			this.remove(i);
		}
		this.textField.setText("Name");
		this.add(textField);
		this.add(back);
		this.add(write);
		writePath += (path + "/");

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

	public void writeToFile() throws IOException {

		File file = new File(this.writePath + this.textField.getText() + ".picross");
		System.out.println(file.getPath());
		FileWriter fileWriter = new FileWriter(file.getPath());
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(this.picross);
		printWriter.close();

	}

	public JButton getBack() {
		return back;
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
