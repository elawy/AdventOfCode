package Day_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TreetopTreeHouse {
    static String filePath = "Day_8/input.txt";
    private ArrayList<ArrayList<Integer>> treeMap;
    
    public int getResult(){
        createMap();
        return countEdgeTrees() + countInteriorVisibles();
    }

    public void createMap(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = "";

        while ( (line = br.readLine().trim()) != null ) {
            for (int i = 0; i < line.length(); i++) {
                // TODO
            }
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
        //TODO
        return edgeTrees;
    }
}
