//read from file the integers

import java.util.*;
import java.io.*;

public class q4 {

    /*Rewrite (refactor) the program in question 4 and read the numbers 
 into an array and then display the numbers, the sum of the numbers, 
 the average, the max and min. */
    public static void main(String[] args) {
        System.out.println("We read entries from the text file \n myintergers.txt into an array");

        File myFile = new File("myintergers.txt"); // path
        Scanner input = new Scanner(System.in);
        int entries = 0;

        int[] array = new int[10];
        try {
            Scanner fileinput = new Scanner(myFile); //object 

            while (fileinput.hasNext()) {
                array[entries] = fileinput.nextInt();
                entries++;
            }
            fileinput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nDiplay elements\n");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }

        //Sum of elements
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += array[i];
        }
        System.out.println("\n\nSum of array elements :" + sum);
        //Average of elements
        float average = 0;
        average = (float) sum / entries;
        System.out.println("the array has :" + entries + " elements.");
        System.out.println("\n\nAverage of array elements :" + average);
        //Min element
        int min = array[0];
        for (int i = 0; i < 10; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("\n\nMin of array elements is:" + min);
        //Max element
        int max = array[0];
        for (int i = 0; i < 10; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("\n\nMax of array elements :" + max + "\n");

    }

}
