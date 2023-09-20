package Day_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissors {

    static String filePath = "Day_2/input.txt";
    static String[] handShapes = new String[2];

    public static void main(String[] args){
        System.out.println(getTotalScore());
    }

    public static int getTotalScore(){

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)) ){
            String line;
            int totalScore = 0;

            while ( (line = br.readLine()) != null) {
                // get seperated values
                handShapes = line.split(" ");
                totalScore += getRoundScore(handShapes);

            }
            return totalScore;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getRoundScore(String[] handShapes){
        if (handShapes[1].equals("X")) return outCome(handShapes) + 1;
        else if (handShapes[1].equals("Y")) return outCome(handShapes) + 2;
        else if (handShapes[1].equals("Z")) return outCome(handShapes) + 3; 
        else return 0;
    }

    public static int outCome(String[] handShapes){
        
        switch (handShapes[0]) {
            case "A":
                switch (handShapes[1]) {
                    case "X": return 3;
                    case "Y": return 6;
                    case "Z": return 0;
                    default:
                        break;
                }
            
            case "B":
                switch (handShapes[1]) {
                    case "X": return 0;
                    case "Y": return 3;
                    case "Z": return 6;
                    default:
                        break;
                }
            
            case "C":
                switch (handShapes[1]) {
                    case "X": return 6;
                    case "Y": return 0;
                    case "Z": return 3;
                    default:
                        break;
                }
            default:
                return 0;
        }
        
        
    }
}
