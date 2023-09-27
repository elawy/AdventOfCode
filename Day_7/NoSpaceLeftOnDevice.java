package Day_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NoSpaceLeftOnDevice {
    static String filePath = "Day_7/input.txt";
    // map{key, value} => {folderName, folderSize}
    String line = "";


    public NoSpaceLeftOnDevice(){
    }

    public int getResult()throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        // add foulder -> "/" -> start
        //
   
        // /.size= rekursionFunc(br, name, 0);
        return 0;
    }

    public int rekursionFunc(BufferedReader br, String name, int size)throws IOException{
        //add foulder to map
       
        while ( ( line = br.readLine() ).charAt(0) != '$') {
            /*
            * if(number)
            *   name.size += theNumber
            */ 
        }
        /*
         * if(cd name)
         *      name.size += rekursionFunc(name, 0);
         * else if(cd ..)
         *      return name.size;
         */
        return 0;
    }

    public int findFoulder(){
        int sum = 0;
        // loop throup map
        //      if (size <= 100000) 
        //          sum += size
        return sum;
    }

}
