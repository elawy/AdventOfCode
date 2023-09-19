package AdventOfCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * CalorieCounting
 */
public class CalorieCounting {


    public static void main (String[] args){
        getMostCalories();
    }
    
    public static void getMostCalories(){

        String filePath = "AdventOfCode/elfCalories.txt";
        int mostCalories = 0;
        int secondMost = 0;
        int thirdMost = 0;
        int tempCalories = 0;


        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while( ( line = br.readLine() )  != null){
                if ( line.trim().isEmpty() ) {
                    
                    if (tempCalories > mostCalories){
                        thirdMost = secondMost;
                        secondMost = mostCalories;
                        mostCalories = tempCalories;
                    } 
                    else if (tempCalories > secondMost){
                        thirdMost = secondMost;
                        secondMost = tempCalories;
                    }    
                    else if (tempCalories > thirdMost) thirdMost = tempCalories;
                    tempCalories=0;
                } else {
                    tempCalories += Integer.parseInt( line.trim() );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Ung;ltiges Format in der Datei");
            e.printStackTrace();
        }
        
        int sum = mostCalories+secondMost+thirdMost;
        System.out.println("Calories: "+ sum);
    }

}