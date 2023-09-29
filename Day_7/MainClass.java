package Day_7;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args){
        NoSpaceLeftOnDevice obj = new NoSpaceLeftOnDevice();
        try {
            System.out.println(obj.getResult());
        } catch (IOException e) {
             e.printStackTrace();
        }
    }
}
