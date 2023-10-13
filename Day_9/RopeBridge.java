package Day_9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RopeBridge {
    static String filePath = "Day_9/input.txt";
    Set<Position> visitedPositions = new HashSet<Position>();
    
    
    
    public int getResult(){

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)) ){
            String line;

            while ( (line = br.readLine()) != null) {
                motion(line.split(" "));
            }

            return visitedPositions.size();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void motion(String[] input){

    }


}
