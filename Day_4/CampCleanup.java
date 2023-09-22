package Day_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CampCleanup {
    static String filePath = "Day_4/input.txt";

    public static void main(String[] args){
        System.out.println(getResult_part1());
        //System.out.println(getResults_part2());
    }


/*--------------------------------Part 1------------------------------------ */
    public static int getResult_part1(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int result = 0;

            while ( (line=br.readLine()) != null) {
                if ( isPartOf( convertInput(line) ) )
                    result++;
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int[][] convertInput(String line){
        //example: "34-82,33-81"
        String[] bothIds = line.split(",");         // {34-82 ,33-81}
        String[] idsElf1 = bothIds[0].split("-");  // {34, 82}
        String[] idsElf2 = bothIds[1].split("-"); // {33, 81}

        int[][] startEnd = { {Integer.parseInt(idsElf1[0]),Integer.parseInt(idsElf1[1]) },
                                 {Integer.parseInt(idsElf2[0]), Integer.parseInt(idsElf2[1])} };
        
        return startEnd;
    }

    public static boolean isPartOf(int[][] id){

        if ( ( (id[0][0] >= id[1][0]) && (id[0][1] <= id[1][1]) )
                || ( (id[0][0] <= id[1][0]) && (id[0][1] >= id[1][1]) ) ) {
            return true;
        }else{
            return false;
        }
    }

/*--------------------------------Part 2---------------------------- */
    public static int getResult_part2(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int result = 0;

            while ( (line=br.readLine()) != null) {

            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
