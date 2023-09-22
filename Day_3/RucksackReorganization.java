package Day_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RucksackReorganization {
    static String filePath = "Day_3/input.txt";

    public static void main(String[] args){
        //System.out.println(getSumOfPriorities_part1());
        System.out.println(getSumOfPriorities_part2());
    }


/*----------------------------for Part 1 and Part 2 ------------------------*/

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

/*--------------------------------Part 2----------------------------------- */
    public static int getSumOfPriorities_part2(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String[] lines = new String[3];
            int sumOfPriorities= 0;

            while ( (lines[0]=br.readLine()) != null) {
                for (int i = 1; i < 3; i++) lines[i] = br.readLine();
                sumOfPriorities += findPrioritieValue(findItemType_part2(lines));
            }
            return sumOfPriorities;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    
    public static char findItemType_part2(String[] rucksack){
        //find item that  exist in both elements
        for (int i = 0; i < rucksack[0].length(); i++) {
            if (rucksack[1].contains(rucksack[0].charAt(i)+"")
                    && rucksack[2].contains(rucksack[0].charAt(i)+"") ) {
                return rucksack[0].charAt(i);
            }
        }
        return '0';
    }
/*---------------------------Part 1------------------------------------------------------ */
    public static int getSumOfPriorities_part1(){

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int sumOfPriorities = 0;

            while ((line = br.readLine()) != null) {
                char item = findItemType_part1(divideInput(line));
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

    public static char findItemType_part1(String[] rucksack){
        //find item that  exist in both elements
        for (int i = 0; i < rucksack[0].length(); i++) {
            if (rucksack[1].contains(rucksack[0].charAt(i)+"")) {
                return rucksack[0].charAt(i);
            }
        }
        return '0';
    }

}
