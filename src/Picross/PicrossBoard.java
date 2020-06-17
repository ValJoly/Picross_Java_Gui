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
        this.solMap.clear();
        for (int i = 0; i < this.squareSize; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < this.squareSize; j++) {
                tmp.add(0);
            }
            solMap.add(tmp);
        }
    }

    public void calculateCoefX() {
        this.coefX.clear();
        for (int i = 0; i < this.squareSize; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int coef = 0;
            for (int j = 0; j < this.squareSize - 1; j++) {
                if (solMap.get(i).get(j) == 1 && j == 0) {
                    coef++;
                    if (solMap.get(i).get(j + 1) == 1) {
                        coef++;
                    }
                }else if (solMap.get(i).get(j) == 0 && solMap.get(i).get(j + 1) == 1) {
                    coef++;
                    if (j == squareSize - 1) {
                        tmp.add(coef);
                    }
                }else if ((solMap.get(i).get(j) == 1 && solMap.get(i).get(j + 1) == 1) && j != squareSize - 2) {
                    coef++;
                }else if (solMap.get(i).get(j) == 1 && solMap.get(i).get(j + 1) == 0) {
                    tmp.add(coef);
                    coef = 0;
                }else if ((solMap.get(i).get(j) == 1 && solMap.get(i).get(j + 1) == 1) && j == squareSize - 2) {
                    coef++;
                    tmp.add(coef);
                    coef = 0;
                }
            }
            if (tmp.isEmpty()) {
                tmp.add(0);
            }
            coefX.add(tmp);
        }
    }

    public void calculateCoefY() {
        this.coefY.clear();
        for (int j = 0; j < this.squareSize; j++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int coef = 0;
            for (int i = 0; i < this.squareSize - 1; i++) {
                if (solMap.get(i).get(j) == 1 && i == 0) {
                    coef++;
                    if (solMap.get(i + 1).get(j) == 1) {
                        coef++;
                    }
                }else if (solMap.get(i).get(j) == 0 && solMap.get(i + 1).get(j) == 1) {
                    coef++;
                    if (i == squareSize - 1) {
                        tmp.add(coef);
                    }
                }else if ((solMap.get(i).get(j) == 1 && solMap.get(i + 1).get(j) == 1) && i != squareSize - 2) {
                    coef++;
                }else if (solMap.get(i).get(j) == 1 && solMap.get(i + 1).get(j) == 0) {
                    tmp.add(coef);
                    coef = 0;
                }else if ((solMap.get(i).get(j) == 1 && solMap.get(i + 1).get(j) == 1) && i == squareSize - 2) {
                    coef++;
                    tmp.add(coef);
                    coef = 0;
                }
            }
            if (tmp.isEmpty()) {
                tmp.add(0);
            }
            coefY.add(tmp);
        }
    }

    public void setMap(ArrayList<ArrayList<Integer>> solMap) {
        this.solMap = solMap;
    }

    public void setIndex(int i, int j, int value) {
        solMap.get(i).set(j, value);
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

        calculateCoefX();
        calculateCoefY();

        String tmp = new String(Integer.toString(squareSize) + '\n');
        for (ArrayList<Integer> iterI : solMap) {
            for (Integer iterJ : iterI) {
                tmp += Integer.toString(iterJ) + " ";
            }
            tmp += '\n';
        }
        for (ArrayList<Integer> x : coefX) {
            for (Integer integer : x) {
                tmp += integer + " ";
            }
            tmp += '\n';
        }
        for (ArrayList<Integer> x : coefY) {
            for (Integer integer : x) {
                tmp += integer + " ";
            }
            tmp += '\n';
        }
        return tmp;
    }
}
