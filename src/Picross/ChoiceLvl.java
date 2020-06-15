package Picross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ChoiceLvl extends JPanel {

	private ArrayList<String> fileNames;
	private ArrayList<JButton> lvls;
	private ActionListener listener;
	private String folderPath;

	ChoiceLvl(Gui Guilistener) {

		listener = Guilistener;
		lvls = new ArrayList<>();
		fileNames = new ArrayList<>();
		folderPath = new String();
		this.setLayout(null);
		this.setBackground(Color.darkGray);

	}



	public void setPath(String path) {

		// Creates a new File instance by converting the given pathname string
		// into an abstract pathname
		folderPath = path;
		String[] pathnames;
		File f = new File(path);


		// Populates the array with names of files and directories
		pathnames = f.list();

		// Conversion of the basic array into an ArrayList because we will need
		// the size of the Array with the method .size()
		fileNames = new ArrayList<String>(Arrays.asList(pathnames));

		// Cleaning the tab for new lvls
		lvls.clear();
		for (int i = this.getComponentCount() - 1; i >= 0; i--) {
			this.remove(i);
		}

		JButton back = new JButton("Back");
		back.setBackground(Color.white);
		back.addActionListener(listener);
		this.add(back);
		lvls.add(back);
		// We create a grid that the size depends on the number of file in the given folder
		this.setLayout(new GridLayout((int) (Math.ceil((double) fileNames.size() / 4)), 4));
		for (
				String iter : pathnames) {

			// Create and add a new JButton for each file in the folder
			JButton tmp = new JButton(iter);
			tmp.setBackground(Color.white);
			tmp.addActionListener(listener);
			lvls.add(tmp);
			this.add(tmp);
		}

	}

	public ArrayList<String> getFileNames() {
		return fileNames;
	}

	public ArrayList<JButton> getLvls() {
		return lvls;
	}

	public String getFolderPath() {
		return folderPath;
	}

}
