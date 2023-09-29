package Day_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class NoSpaceLeftOnDevice {

    static String filePath = "Day_7/input.txt";
    HashMap<String, Integer> directory = new HashMap<String,Integer>();
    String line = "";
    int sameName = 0;

    public NoSpaceLeftOnDevice(){
    }


    public int getResult()throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        line = br.readLine();
        String[] lineArray = line.split(" ");
        
        int newSize = rekursionFunc(br, lineArray[2], 0);
        directory.replace(lineArray[2], directory.get(lineArray[2]), newSize);
        
        // -----------------Part_1---------------
        //return findFoulder();
        // -----------------Part_2---------------
        return directoryToDelete();
    }



    public int rekursionFunc(BufferedReader br, String name, int size)throws IOException{

        if (directory.containsKey(name)){
            sameName++;
            name += Integer.toString(sameName);
        }
        this.directory.put(name, size);  //add foulder to map


        int newSize;
        br.readLine();// it is the line "ls" -> we don't need it

        while ( ( line = br.readLine() ) != null) {
            String[] stringParts = line.split(" ");
            
            if (isNumeric(stringParts[0])) {    //if the line shows a file to count
                newSize = this.directory.get(name) + Integer.parseInt(stringParts[0]);
                this.directory.replace(name, this.directory.get(name), newSize);    // update size
            } else if( stringParts[0].equals("$")){
                if ( (stringParts[1].equals("cd")) && (!stringParts[2].equals("..")) ) {  //it is another  sub-directory 
                    newSize = this.directory.get(name) + rekursionFunc(br, stringParts[2], 0);
                    this.directory.replace(name, this.directory.get(name), newSize);    // update size
                }else{
                    return this.directory.get(name);
                }
            }
        }  
        return this.directory.get(name);
    } 


    public int findFoulder(){
        int sum = 0;
        for (HashMap.Entry<String, Integer> set : directory.entrySet()){
            if (set.getValue() <= 100000) sum += set.getValue();
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


    public int directoryToDelete(){
        int dirToDelete = directory.get("/");

        for (Integer value : directory.values()) {
            if (value >= calcNeededSpace()) {
                if (dirToDelete > value) dirToDelete = value;
            }
        }
        return dirToDelete;
    }

    public int calcNeededSpace(){
        int diskSpace = 70000000;
        int neededSpace = 30000000;

        return directory.get("/") - (diskSpace - neededSpace);
    }
}
