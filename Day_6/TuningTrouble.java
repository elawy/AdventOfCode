package Day_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TuningTrouble {
    static String filePath = "Day_6/input.txt";
    char[] marker = new char[4];
    int index = 0;

    public TuningTrouble(){
    }
    
    public int getResult(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            boolean firstTime = true;
            
            while (br.ready()) {
                if (firstTime) {
                    for (int i = 0; i < this.marker.length; i++) {
                        this.marker[i] = (char)br.read();
                    }
                    index = 4;
                    firstTime = false;
                } else {
                    setCharacter((char)br.read());
                    index++;
                }
                if( detectMarker() ) return index;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void setCharacter(char newChar){
        // remove first, move array and add new char at the last index
    }

    public boolean detectMarker(){
        //check if any char is double in array?
        return true;
    }
    
}
