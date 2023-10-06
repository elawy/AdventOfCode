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
        return countEdgeTrees() + countInteriorVisibles();
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

    public int countInteriorVisibles(){
        int interiorVisible = 0;
        //TODO
        return interiorVisible;
    }
    public int countEdgeTrees(){
        int edgeTrees = 0;
        int rows = this.treeMap.size();
        int colums = this.treeMap.get(0).size();
        edgeTrees = 2*rows + 2* (colums -2);
        return edgeTrees;
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
