package Day_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissors {

    static String filePath = "Day_2/input.txt";
    static String[] inputLine = new String[2];


    public static void main(String[] args){
        System.out.println(getTotalScore());
    }

    public static int getTotalScore(){

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)) ){
            String line;
            int totalScore = 0;

            while ( (line = br.readLine()) != null) {
                // get seperated values
                inputLine = line.split(" ");
                //totalScore += getRoundScore_1(inputLine);
                totalScore += getRoundScore_2(inputLine);

            }
            return totalScore;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getShapeScoure(String shape){
        if(shape.equals("A")) return 1;
        else if(shape.equals("B")) return 2;
        else if (shape.equals("C"))return 3;        
        else return 0;
    }

    public static int getOutputScore(String output){
        if(output.equals("X")) return 0;
        else if(output.equals("Y")) return 3;
        else if (output.equals("Z"))return 6;        
        else return 0;
    }

    public static int calculateRoundScore(String shape, String output){
        return getOutputScore(output) + getShapeScoure(shape);
    }

    public static int getRoundScore_2(String[] inputLine){
        
        switch (inputLine[0]) {
            case "A":
                switch (inputLine[1]) {
                    case "X": return calculateRoundScore("C", inputLine[1]);
                    case "Y": return calculateRoundScore("A", inputLine[1]);
                    case "Z": return calculateRoundScore("B", inputLine[1]);
                }
            case "B":
                switch (inputLine[1]) {
                    case "X": return calculateRoundScore("A", inputLine[1]);
                    case "Y": return calculateRoundScore("B", inputLine[1]);
                    case "Z": return calculateRoundScore("C", inputLine[1]);
                }
            case "C":
                switch (inputLine[1]) {
                    case "X": return calculateRoundScore("B", inputLine[1]);
                    case "Y": return calculateRoundScore("C", inputLine[1]);
                    case "Z": return calculateRoundScore("A", inputLine[1]);
                }
            default:
                 return 0;
        }
    }

    public static int getRoundScore_1(String[] handShapes){
        if (handShapes[1].equals("X")) return outCome_1(handShapes) + 1;
        else if (handShapes[1].equals("Y")) return outCome_1(handShapes) + 2;
        else if (handShapes[1].equals("Z")) return outCome_1(handShapes) + 3; 
        else return 0;
    }

    public static int outCome_1(String[] handShapes){
        
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
