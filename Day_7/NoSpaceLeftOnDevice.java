package Day_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class NoSpaceLeftOnDevice {

    static String filePath = "Day_7/inputTest.txt";
    HashMap<String, Integer> foulders = new HashMap<String,Integer>();
    String line = "";


    public NoSpaceLeftOnDevice(){
    }

    public int getResult()throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        line = br.readLine();
        String[] lineArray = line.split(" ");
        
        int newSize = rekursionFunc(br, lineArray[2], 0);
        foulders.replace(lineArray[2], foulders.get(lineArray[2]), newSize);
        return findFoulder();
    }

    public int rekursionFunc_x(BufferedReader br, String name, int size)throws IOException{

        this.foulders.put(name, size);   //add foulder to map
        int newSize;
         // it is the line "ls" -> we don't need it, TODO could we jump over the line?
        line = br.readLine();

        while ( ( line = br.readLine() ).charAt(0) != '$') {
            String[] stringParts = line.split(" ");     //TODO line twice in this function
            
            if (isNumeric(stringParts[0])) {    //if the line shows a file to count
                newSize = this.foulders.get(name) + Integer.parseInt(stringParts[0]);
                this.foulders.replace(name, this.foulders.get(name), newSize);    // update size
            }
        }
        String[] stringParts = line.split(" ");

        if ( (stringParts[1].equals("cd")) && (!stringParts[2].equals("..")) ) {   //it is another foulder 
            newSize = this.foulders.get(name) + rekursionFunc(br, stringParts[2], 0);
            this.foulders.replace(name, this.foulders.get(name), newSize);    // update size

        }

        return this.foulders.get(name);
    }

    public int findFoulder(){
        int sum = 0;

        for (int size  : this.foulders.values()) {
            if (size <= 100000) {
                sum += size;
            }
        }

        return sum;
    }

    public static boolean isNumeric(String str) { 
        try {  
          Integer.parseInt(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }

      public int rekursionFunc(BufferedReader br, String name, int size)throws IOException{

        this.foulders.put(name, size);   //add foulder to map
        int newSize;
         // it is the line "ls" -> we don't need it, TODO could we jump over the line?
        line = br.readLine();

        while ( ( line = br.readLine() ) != null) {
            String[] stringParts = line.split(" ");     //TODO line twice in this function
            
            if (isNumeric(stringParts[0])) {    //if the line shows a file to count
                newSize = this.foulders.get(name) + Integer.parseInt(stringParts[0]);
                this.foulders.replace(name, this.foulders.get(name), newSize);    // update size
            } else if(( line = br.readLine() ).charAt(0) != '$'){
                if ( (stringParts[1].equals("cd")) && (!stringParts[2].equals("..")) ) {   //it is another foulder 
                    newSize = this.foulders.get(name) + rekursionFunc(br, stringParts[2], 0);
                    this.foulders.replace(name, this.foulders.get(name), newSize);    // update size
                }else{
                    return this.foulders.get(name);
                }
            }
        }  
        return 0;    
    }
}
