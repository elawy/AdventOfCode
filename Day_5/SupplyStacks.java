package Day_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SupplyStacks {
    static String filePath = "Day_5/input.txt";
    ArrayList<Character>[] stackOfCrates;

    public SupplyStacks(){

    }

    public String getResult(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            ArrayList <String> stackInString = new ArrayList<String>();
            
            // read stacks of marked crates
            while (!(line=br.readLine()).isEmpty()) {
                stackInString.add(line);
            }
            convertInputStack(stackInString);

            // read rearrangement procedure
            while ((line=br.readLine()) != null) {
                //rearrangementProcedure_1(convertInputProcedure(line));
                rearrangementProcedure_2(convertInputProcedure(line));
            }

            return readResultFromStack();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void convertInputStack(ArrayList<String> stackInLines){

        //how many stacks are there?
        int lastIndex = stackInLines.size()-1;
        String lastLine= stackInLines.get(lastIndex).trim();
        stackInLines.remove(lastIndex);
        int numOfStacks = Integer.parseInt(lastLine.substring(lastLine.length() - 1));

        // initializing Array of ArrayList
        this.stackOfCrates = new ArrayList[numOfStacks];
        for (int i = 0; i < numOfStacks; i++) {
            this.stackOfCrates[i] = new ArrayList<Character>();
        }

        for (int i = stackInLines.size()-1; i >= 0; i--) {     // each line of the input.txt
            for (int k = 1, j = 0; k < stackInLines.get(i).length(); k+=4, j++) { //importand character in line                 
                Character creates = stackInLines.get(i).charAt(k); //find each char in line
                if ( creates != ' ') {
                    this.stackOfCrates[j].add(creates);
                }
            }
        }
    }

    public int[] convertInputProcedure(String line){
        int[] procedureSteps = new int[3];
        // Replacing every non-digit number with a space(" ")
        line = line.replaceAll("[^0-9]", " "); // regular expression
        // Replace all the consecutive white spaces with a single space
        line = line.replaceAll(" +", " ").trim();
        String[] num = line.split(" ");
        for (int i = 0; i < num.length; i++) {
            procedureSteps[i] = Integer.parseInt(num[i]);
        }
        return procedureSteps;
    }

    public String readResultFromStack(){
        String result = "";
        for (ArrayList<Character> stack : this.stackOfCrates) {
            if (!stack.isEmpty()) result += stack.get(stack.size()-1);
        }
        return result;
    }

    /*--------------------------------Part 1------------------------------------ */

    public void rearrangementProcedure_1(int[] orders){
        /*orders[0] => number of crates that will be moved
        * orders[1] => from which stack it will be moved
        * ordres[2] => to which stack will be moved
        */
        int fromStack = orders[1]-1;
        int toStack= orders[2]-1;

        for (int i = 0; i < orders[0]; i++) {
            int lastIndex = this.stackOfCrates[fromStack].size()-1;
            char cratesToMove = this.stackOfCrates[fromStack].get( lastIndex );
            this.stackOfCrates[fromStack].remove(lastIndex);
            this.stackOfCrates[toStack].add(cratesToMove);
        }
    }


    /*--------------------------------Part 2------------------------------------ */

        public void rearrangementProcedure_2(int[] orders){
        /*orders[0] => number of crates that will be moved
        * orders[1] => from which stack it will be moved
        * ordres[2] => to which stack will be moved
        */
        int numToMove = orders[0];
        int fromStack = orders[1]-1;
        int toStack= orders[2]-1;

        int index = this.stackOfCrates[fromStack].size() - numToMove;
        for (int i = 0; i < numToMove; i++) {
            char cratesToMove = this.stackOfCrates[fromStack].get( index );
            this.stackOfCrates[fromStack].remove(index);
            this.stackOfCrates[toStack].add(cratesToMove);
        }
    }
}
