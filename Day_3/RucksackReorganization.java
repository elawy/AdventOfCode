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
                sumOfPriorities += findPrioritieValue(item);
            }
            return sumOfPriorities;       
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String[] divideInput(String input){
        // split Input in half
        int mid = input.length()/2;
        String[] rucksack = {input.substring(0, mid), input.substring(mid)};
        return rucksack;
    }

    public static char findItemType(String[] rucksack){
        //find item that  exist in both elements
        for (int i = 0; i < rucksack[0].length(); i++) {
            if (rucksack[1].contains(rucksack[0].charAt(i)+"")) {
                return rucksack[0].charAt(i);
            }
        }
        return '0';
    }

    public static int findPrioritieValue(char item){

        String alphabetLow = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpper = alphabetLow.toUpperCase();
        String prioritie = alphabetLow + alphabetUpper;
        for (int i = 0; i < prioritie.length(); i++) {
            if (prioritie.charAt(i) == item) {
                return i+1;
            }
        }
        return 0;
    }

}
