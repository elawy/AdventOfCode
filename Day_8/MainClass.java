package Day_8;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args){
        try {
            TreetopTreeHouse obj = new TreetopTreeHouse();
            System.out.println(obj.getResult());
        } catch (IOException e) {
             e.printStackTrace();
        }
    }
}
