package Day_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CampCleanup {
    static String filePath = "Day_4/input.txt";

    public static void main(String[] args){
        System.out.println(getResult());
        //System.out.println(getResults_part2());
    }

    public static int getResult(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int result = 0;

            while ( (line=br.readLine()) != null) {
                //if ( isPartOf_1( convertInput(line) ) )
                if ( isPartOf_2( convertInput(line) ) )
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
/*--------------------------------Part 1------------------------------------ */
    public static boolean isPartOf_1(int[][] id){
        //Example: { {34,82}, {33,81} }
        if ( ( (id[0][0] >= id[1][0]) && (id[0][1] <= id[1][1]) )           // 34>=33 && 82<=81
                || ( (id[0][0] <= id[1][0]) && (id[0][1] >= id[1][1]) ) ) { // 34<=33 && 82>=81
            return true;
        }else{
            return false;
        }
    }

/*--------------------------------Part 2---------------------------- */
    public static boolean isPartOf_2(int[][] id){
        //Example: { {34,82}, {33,81} }
        if ( ( (id[0][0] >= id[1][0]) && (id[0][0] <= id[1][1]) )           // 34 between 33 and 81
                || ( (id[0][1] >= id[1][0]) && (id[0][1] <= id[1][1]) )     // 82 between 33 and 81
                || ( (id[1][0] >= id[0][0]) && (id[1][0] <= id[0][1]) )     // 33 between 34 and 82
                || ( (id[1][1] >= id[0][0]) && (id[1][1] <= id[0][1]) ) ){  // 81 between 34 and 82
            return true;
        }else{
            return false;
        }
    }
}