package Picross;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PicrossBoard {

    private int squareSize;
    private ArrayList<ArrayList<Integer>> coefX;
    private ArrayList<ArrayList<Integer>> coefY;
    private ArrayList<ArrayList<Integer>> solMap;

    PicrossBoard(String path){
        solMap = new ArrayList<>();
        coefX = new ArrayList<>();
        coefY = new ArrayList<>();
        squareSize = 0;

        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);

            int it = 0;
            while (sc.hasNext()) {

                String iter = sc.nextLine();

                if (it == 0){
                    squareSize = Integer.parseInt(iter);
                }else if (it > 0 && it <= squareSize) {
                    String tmp = iter;
                    String[] rowString = tmp.split(" ");
                    ArrayList<Integer> num = new ArrayList<>();
                    for (String a : rowString) {
                        num.add(Integer.parseInt(a));
                    }
                    solMap.add(num);
                } else if (it > squareSize && it <= squareSize * 2) {
                    String tmp = iter;
                    String[] rowString = tmp.split(" ");
                    ArrayList<Integer> num = new ArrayList<>();
                    for (String a : rowString)
                        num.add(Integer.parseInt(a));

                    coefY.add(num);
                } else if (it > squareSize * 2 && it <= squareSize * 3) {
                    String tmp = iter;
                    String[] rowString = tmp.split(" ");
                    ArrayList<Integer> num = new ArrayList<>();
                    for (String a : rowString)
                        num.add(Integer.parseInt(a));

                    coefX.add(num);
                } else if (it >= squareSize){
                    break;
                }

                it++;
            }
        }catch (Exception exept){
            System.out.println(exept);
        }
    }

    PicrossBoard(){
        solMap = new ArrayList<>();
        coefX = new ArrayList<>();
        coefY = new ArrayList<>();
        squareSize = 10;

        for (int i = 0; i < squareSize; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < squareSize; j++) {
                tmp.add(0);
            }
            solMap.add(tmp);
            tmp.clear();
            tmp.add(0);
            coefX.add(tmp);
            coefY.add(tmp);
        }

        /*try {
            File file = new File("picrossFiles/easy/house.picross");
            Scanner sc = new Scanner(file);

            int it = 0;
            while (sc.hasNext()) {

                String iter = sc.nextLine();

                if (it == 0){
                    squareSize = Integer.parseInt(iter);
                }else if (it > 0 && it <= squareSize) {
                    String tmp = iter;
                    String[] rowString = tmp.split(" ");
                    ArrayList<Integer> num = new ArrayList<>();
                    for (String a : rowString) {
                        num.add(Integer.parseInt(a));
                    }
                    solMap.add(num);
                } else if (it > squareSize && it <= squareSize * 2) {
                    String tmp = iter;
                    String[] rowString = tmp.split(" ");
                    ArrayList<Integer> num = new ArrayList<>();
                    for (String a : rowString)
                        num.add(Integer.parseInt(a));

                    coefY.add(num);
                } else if (it > squareSize * 2 && it <= squareSize * 3) {
                    String tmp = iter;
                    String[] rowString = tmp.split(" ");
                    ArrayList<Integer> num = new ArrayList<>();
                    for (String a : rowString)
                        num.add(Integer.parseInt(a));

                    coefX.add(num);
                } else if (it >= squareSize){
                    break;
                }

                it++;
            }
        }catch (Exception exept){
            System.out.println(exept);
        }*/

    }



    public void setSquareSize(int squareSize) {
        this.squareSize = squareSize;
    }

    public void setCoefX(ArrayList<ArrayList<Integer>> coefX) {
        this.coefX = coefX;
    }

    public void setCoefY(ArrayList<ArrayList<Integer>> coefY) {
        this.coefY = coefY;
    }

    public void setSolMap(ArrayList<ArrayList<Integer>> solMap) {
        this.solMap = solMap;
    }

    public int getSquareSize() {
        return squareSize;
    }

    public ArrayList<ArrayList<Integer>> getCoefX() {
        return coefX;
    }

    public ArrayList<ArrayList<Integer>> getCoefY() {
        return coefY;
    }

    public ArrayList<ArrayList<Integer>> getMap() {
        return solMap;
    }

    public boolean isResolve(ArrayList<ArrayList<Integer>> current) {
        for (int i = 0; i < current.size(); i++) {
            for (int j = 0; j < current.size(); j++) {
                if (current.get(i).get(j) != solMap.get(i).get(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "not yet implemented";
    }
}
