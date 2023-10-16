package Day_9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.lang.Math;

public class RopeBridge {
    static String filePath = "Day_9/input.txt";
    Set<Position> visitedPos = new HashSet<Position>();
    Position head = new Position(0,0);
    Position tail = new Position(0,0);
    
    public int getResult(){

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)) ){
            String line;

            while ( (line = br.readLine()) != null) {
                String direction = line.split(" ")[0];
                int steps = Integer.parseInt(line.split(" ")[1]);
                motionLine(direction, steps);
            }

            return visitedPos.size();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0; //TODO error exception
    }

    public void motionLine(String direction, int steps){
        for (int i = 0; i < steps; i++) {
            head = motion(direction, head);
            tail = tailToMove();
            visitedPos.add(tail);

        }
    }

    public Position motion(String direction, Position type){
        switch (direction) {
            case "U":   return new Position(type.x, type.y + 1);
            case "D":   return new Position(type.x, type.y - 1);
            case "R":   return new Position(type.x + 1, type.y);
            case "L":   return new Position(type.x - 1, type.y);            
        }
        return new Position(0,0); //TODO error exception
    }

    public Position tailToMove(){
        int xDif = head.x - tail.x;
        int yDif = head.y - tail.y;

        if (Math.abs(xDif) >=2) {
            if (xDif > 0) tail = motion("R", tail);
            else tail = motion("L", tail);

            if (yDif >= 1) tail = motion("U", tail);
            else if (yDif <= -1) tail = motion("D", tail);
        }
        if (Math.abs(yDif) >=2) {
            if (yDif > 0) tail = motion("U", tail);
            else tail = motion("D", tail);

            if (xDif >= 1) tail = motion("R", tail);
            else if (xDif <= -1) tail = motion("L", tail);
        }
        return tail;
    }
}
