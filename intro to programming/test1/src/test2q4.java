//Laurian Staicu 1696177 Final

import java.util.*;
import java.io.*;

public class test2q4 {

    public static void main(String[] args) {
        String filename;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the file name:");
        filename = input.nextLine();
        File myFile = new File(filename); // path

        int[][] resultArray = new int[6][5];
        try {
            Scanner fileinput = new Scanner(myFile); //object 
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    resultArray[i][j] = fileinput.nextInt();
                }
            }
            fileinput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
