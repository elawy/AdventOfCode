package Day_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TreetopTreeHouse {
    static String filePath = "Day_8/input.txt";
    private ArrayList<ArrayList<Integer>> treeMap = new ArrayList<ArrayList<Integer>>();
    
    public int getResult(){
        createMap();
        //toPrint();

        //return countEdgeTrees() + checkEchInnerTree();        //Part_1
        return checkEchInnerTree();
    }

    public void createMap(){

        ArrayList<Integer> temp;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = "";
            while ((line = br.readLine()) != null ) {
                temp = new ArrayList<Integer>();
                for (int j = 0; j < line.length(); j++) {
                    temp.add( Character.getNumericValue(line.charAt(j)) );
                }
                this.treeMap.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int checkEchInnerTree(){
        int returnValue = 0;
        for (int i = 1; i < this.treeMap.size()-1; i++) {
            for (int j = 1; j < this.treeMap.get(i).size()-1; j++) {
                /*
                // Part_1
                if (visibilFromOutside(this.treeMap.get(i).get(j), i, j)) {
                    returnValue++;
                }
                */
                //Part_2
                int newValue = bestSpot(this.treeMap.get(i).get(j), i, j);
                if ( returnValue < newValue) {
                    returnValue = newValue;
                }

            } 
        }
        return returnValue;
    }

    /*----------------------Part_1----------------------------- */
    // is the tree the highest in the horizontal and vertical lines?
    public boolean visibilFromOutside(int value1, int row1, int colums1){
        int countFalse = 0;

        // for top line
        for (int row2 = 0; row2 < row1; row2++) {
            if (this.treeMap.get(row2).get(colums1) >= value1) {
                countFalse++;
                break;
            }
        }

        // for down line
        for (int row2 = this.treeMap.size()-1; row2 > row1; row2--) {
            if (this.treeMap.get(row2).get(colums1) >= value1) {
                countFalse++;
                break;
            }
        }

        // for left line     
        for (int colums2 = 0; colums2 < colums1; colums2++) {
            if (this.treeMap.get(row1).get(colums2) >= value1) {
                countFalse++;
                break;
            }
        }

        // for right line     
        for (int colums2 = this.treeMap.get(row1).size()-1; colums2 > colums1; colums2--) {
            if (this.treeMap.get(row1).get(colums2) >= value1) {
                countFalse++;
                break;
            }
        }
        
        if (countFalse == 4 ) {
            return false;
        } else {
            return true;
        }
    }

    public int countEdgeTrees(){
        int edgeTrees = 0;
        int rows = this.treeMap.size();
        int colums = this.treeMap.get(0).size();
        edgeTrees = 2*rows + 2* (colums -2);
        return edgeTrees;
    }


    /*----------------------Part_2----------------------------- */
    public int bestSpot(int value1, int row1, int colums1){

        int scenicScore = 1;

        // for top line
        for (int row2 = row1-1; row2 >= 0; row2--) {
            if (this.treeMap.get(row2).get(colums1) >= value1
                    || row2 == 0) {
                scenicScore *= Math.abs(row1-row2);
                break;
            }
        }

        // for down line
        for (int row2 = row1+1; row2 <= this.treeMap.size()-1; row2++) {
            if (this.treeMap.get(row2).get(colums1) >= value1
                    || row2 == this.treeMap.size()-1) {
                scenicScore *= Math.abs(row1-row2);
                break;
            }
        }

        // for left line     
        for (int colums2 = colums1-1; colums2 >= 0; colums2--) {
            if (this.treeMap.get(row1).get(colums2) >= value1
                || colums2 == 0) {
                scenicScore *= Math.abs(colums1 - colums2);
                break;
            }
        }

        // for right line     
        for (int colums2 = colums1+1 ; colums2 <= this.treeMap.get(row1).size()-1; colums2++) {
            if (this.treeMap.get(row1).get(colums2) >= value1
                || colums2 == this.treeMap.get(row1).size()-1 ) {
                scenicScore *= Math.abs(colums1 - colums2);
                break;
            }
        }
        
        return scenicScore;
    }

    public void toPrint(){
        for (int i = 0; i < this.treeMap.size(); i++) {
            for (int j = 0; j < this.treeMap.get(i).size(); j++) {
                System.out.print(this.treeMap.get(i).get(j));
            }
            System.out.print("\n");
        }
    }
}
