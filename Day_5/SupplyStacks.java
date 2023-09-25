package Day_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SupplyStacks {
    static String filePath = "Day_5/input.txt";

    public static void main(String[] args){
        System.out.println(getResult());
        //System.out.println(getResults_part2());
    }

    public static String getResult(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            String result = "";

            while ( (line=br.readLine()) != null) {
 
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void convertInput(String line){
        
    }
/*--------------------------------Part 1------------------------------------ */


/*--------------------------------Part 2---------------------------- */

}
