package Day_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SupplyStacks {
    static String filePath = "Day_5/input.txt";

    public static void main(String[] args){
        System.out.println(getResult());
        //System.out.println(getResults_part2());
    }

    public static String getResult(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            ArrayList <String> stackInString = new ArrayList<String>();
            String result = "";

            // read stacks of marked crates
            while (!(line=br.readLine()).isEmpty()) {
                stackInString.add(line);
            }
            convertInput(stackInString);

            // read rearrangement procedure
            while ((line=br.readLine()) != null) {
                
            }


            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*--------------------------------Part 1------------------------------------ */

    public static ArrayList<Character>[] convertInput(ArrayList<String> stackInString){
       // initializing Array of ArrayList
        ArrayList<Character>[] stackOfCrates = new ArrayList[stackInString.size()];
        for (int i = 0; i < stackInString.size(); i++) {
            stackOfCrates[i] = new ArrayList<Character>();
        }

        for (int i = stackInString.size()-1; i >= 0; i--) {     // each line of the input.txt
            for (int k = 0, j = 0; k < stackOfCrates.length; k+=4, j++) {
                char creates = stackInString.get(i).charAt(k);
                if ( creates != ' ') {
                    stackOfCrates[j].add(creates);
                }
            }
            
        }
        return stackOfCrates;
    }

    public static void rearrangementProcedure(ArrayList<Character>[] stackOfCreates){

    }

    public static String getResult(ArrayList<Character>[] stackOfCreates){
        String result = "";
        return result;
    }
/*--------------------------------Part 2------------------------------------ */

}
