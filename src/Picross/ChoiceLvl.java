package Picross;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ChoiceLvl extends JPanel {

    private ArrayList<String> fileNames;
    private ArrayList<JButton> lvls;


    ChoiceLvl(String path, Gui listener) {

        lvls = new ArrayList<>();
        String[] pathnames;

        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        File f = new File(path);

        // Populates the array with names of files and directories
        pathnames = f.list();

        // Conversion of the basic array into an ArrayList because we will need
        // the size of the Array with the method .size()
        fileNames = new ArrayList<String>(Arrays.asList(pathnames));

        JButton back = new JButton("Back");
        back.addActionListener(listener);
        this.add(back);
        lvls.add(back);
        // We create a grid that the size depends on the number of file in the given folder
        this.setLayout(new GridLayout((int)(Math.ceil((double) fileNames.size() / 4)), 4));
        for (String iter : pathnames) {

            // Create and add a new JButton for each file in the folder
            JButton tmp = new JButton(iter);
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

}
