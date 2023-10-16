package Day_9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RopeBridge {
    static String filePath = "Day_9/input.txt";
    Set<Position> visitedPositions = new HashSet<Position>();
    Position head = new Position(0,0);
    Position tail = new Position(0,0);
    
    public int getResult(){

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)) ){
            String line;

            while ( (line = br.readLine()) != null) {
                motionLine(line.split(" "));
            }

            return visitedPositions.size();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void motionLine(String[] input){
        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            
        }
    }


}
