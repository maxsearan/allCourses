
//Laurian Staicu  1696177 Final
import java.util.*;
import java.io.*;

public class test2q2 {

    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner input = new Scanner(System.in);

        int entries = 10;  
        System.out.println("Input array of 10 elements one by one.\n");
        for (int i = 0; i < 10; i++) {
            System.out.println("Please input elment :" + (i + 1) + " of array. ");
            array[i] = input.nextInt();
        }

        System.out.println("\nDisplay elements\n");
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
        System.out.println("\nthe array has :" + entries + " elements.");
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
