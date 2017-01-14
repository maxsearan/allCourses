// Write to a file integers

import java.util.*;
import java.io.*;

public class q2 {

    public static void main(String[] args) {
        int number;
        Scanner input = new Scanner(System.in);

        File myFile1 = new File("myintergers.txt");

        try {
            PrintWriter fileoutput = new PrintWriter(myFile1);
            for (int i = 0; i < 10; i++) {
                System.out.println("Enter number :");
                number = input.nextInt();
                fileoutput.println(number);
            }
            fileoutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nMyintergers.txt was created. \n10 numbers were entered.");

    }

}
