package Day_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RucksackReorganization {
    static String filePath = "Day_3/input.txt";

    public static void main(String[] args){
        System.out.println(getSumOfPriorities());
    }

    public static int getSumOfPriorities(){

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int sumOfPriorities = 0;

            while ((line = br.readLine()) != null) {
                char item = findItemType(divideInput(line));
                sumOfPriorities = findPrioritieValue(item);
            }
            return sumOfPriorities;       
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String[] divideInput(String input){
        String rucksack[] = new String[2];
        // split Input in half
        return rucksack;
    }

    public static char findItemType(String[] rucksack){
        char item;
        //find item that  exist in both elements
        return item;
    }

    public static int findPrioritieValue(char item){

    }

}
