//Laurian Staicu 1696177 Final
// Write to a file integers

import java.util.*;
import java.io.*;

public class test2q3 {

    public static void main(String[] args) {
        int[][] array = new int[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = (int) (Math.random() * 20 + 1);
            }
        }

        File myFile1 = new File("myintegers.txt");

        try {
            PrintWriter fileoutput = new PrintWriter(myFile1);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    {
                        fileoutput.println(array[i][j]);
                    }
                }
            }
            fileoutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nmyintergers.txt was created.");

    }

}
