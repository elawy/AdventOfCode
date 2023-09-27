package Day_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TuningTrouble {
    static String filePath = "Day_6/input.txt";
    int markerLength = 4;
    ArrayList<Character> marker = new ArrayList<Character>();
    int index = 0;

    public TuningTrouble(){
    }

    public int getResult(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            boolean firstTime = true;
            
            while (br.ready()) {
                if (firstTime) {
                    for (int i = 0; i < markerLength; i++) {
                        this.marker.add(i, (char)br.read());
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
        this.marker.remove(0);
        this.marker.add(newChar);
    }

    public boolean detectMarker(){
        ArrayList<Character> temp = new ArrayList<Character>();
        for (char i : this.marker){
            if (temp.contains(i)){
                return false;
            } else{ 
                temp.add(i);
            }
        }
        return true;
    }
    
}
