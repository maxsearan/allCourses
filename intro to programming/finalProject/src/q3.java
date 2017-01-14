//read from file the integers

import java.util.*;
import java.io.*;

public class q3 {

    public static void main(String[] args) {
        System.out.println("We read lines from text mytextfile1.txt and "
                + "display it on the screen. ");

        File myFile = new File("myintergers.txt"); // path
        Scanner input = new Scanner(System.in);
        int num;
        int totalNumbers = 0;
        try {
            Scanner fileinput = new Scanner(myFile); //object 

            while (fileinput.hasNext()) {
                num = fileinput.nextInt();
                System.out.println(num);
                totalNumbers++;
            }

            fileinput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nTotal number of elements: " + totalNumbers);
    }

}
