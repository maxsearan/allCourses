/*
 HOMEWORK - REVIEW:
* conditional expressions
* 3 types of loop (including break and continue)
* single-dimensional arrays
* two-dimensional arrays
* method parameters and return types (signature)
* if-else, if-else-if-else chains
* switch-case
* Scanner user
 */
package training01;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Training01 {

    public static void main(String[] args) {
        long n = 461012;
        System.out.format("%d%n", n);      //  -->  "461012"
        System.out.format("%18d%n", n);    //  -->  "00461012"
        System.out.format("%+18d%n", n);    //  -->  " +461012"
        System.out.format("%,8d%n", n);    // -->  " 461,012"
        System.out.format("%+,18d%n%n", n); //  -->  "+461,012"

        double pi = Math.PI;

        System.out.format("%f%n", pi);       // -->  "3.141593"
        System.out.format("%.3f%n", pi);     // -->  "3.142"
        System.out.format("%15.4f%n", pi);   // -->  "     3.142"
        System.out.format("%-10.3f%n", pi);  // -->  "3.142"
        System.out.format(Locale.FRANCE,
                "%-10.4f%n%n", pi); // -->  "3,1416"

        Calendar c = Calendar.getInstance();
        System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"

        System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"

        System.out.format("%tD%n", c);    // -->  "05/29/06"

        //My program
        Scanner input = new Scanner(System.in);
        String[] arrayNames = new String[3];
        int[][] intArray = new int[10][10];
        int sizeDoubleArray;
        System.out.println("Input size of array:\n");
        sizeDoubleArray = input.nextInt();
        double[] doubleArray = new double[sizeDoubleArray];
        int[] intFromDouble = new int[sizeDoubleArray];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Math.random() * 1000 - (int) (Math.random() * 100);
        }
        for (int i = 0; i < doubleArray.length; i++) {
            System.out.printf("%.3f%n", doubleArray[i]);
            intFromDouble[i] = (int) doubleArray[i];
            System.out.printf("%15d%n", intFromDouble[i]);
        }
        Scanner inforname = new Scanner(System.in);
        System.out.println("input file name to save int array");
        String file = inforname.nextLine();
        File myfilename = new File(file);
        try {
            try (PrintWriter print = new PrintWriter(myfilename)) {
                print.println("test");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Training01.class.getName()).log(Level.SEVERE, null, ex);
        }
        File file1 = new File("Gia");
       try{ 
        PrintWriter p1 = new PrintWriter(file1);
        p1.println("BS");
        p1.close();
       }catch(Exception e){
           
       }
        while (true) {
            System.out.println("Array Prime numbers");
            System.out.println("1) while loop matrice ");
            System.out.println("2) print the array ");
            System.out.println("3) write Array To File ");
            System.out.println("0) exit ");

            int choice = input.nextInt();

            if ((choice < 0) || (choice > 3)) {

                System.out.println("Invalide choice:");
                continue;
            }
            if (choice == 0) {
                System.out.println("exit option :" + choice);
                return;
            }

            switch (choice) {
                case 1:
                    arrayNames[0] = whileLoopArray(intArray);
                    break;
                case 2:
                    printArray(intArray);
                    break;
                case 3:
                    writeArrayToFile(intArray);
                    break;
                default: {
                    System.out.println("Fatal error");
                    System.exit(1);
                }
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("\n" + arrayNames[i]);
            }
        }
    }

    static String whileLoopArray(int array[][]) {
        String name;
        Scanner input = new Scanner(System.in);
        {
            int i = 0, j = 0;
            Random rn = new Random();
            while (i < array.length) {

                while (j < array[0].length) {
                    array[i][j] = rn.nextInt(100) + 1;
                    j++;
                }
                i++;
                j = 0;
            }
        }
        printArray(array);
        System.out.println("");
        int countPrime = 0;
        for (int[] array1 : array) {
            for (int j = 0; j < array[0].length; j++) {

                array1[j] = nunmberIsPrime(array1[j]);
                if ((array1[j]) == 1) {
                    countPrime++;
                }

            }
        }
        System.out.println("\nNumber of prime numbers: " + countPrime);
        printArray(array);
        name = input.nextLine();
        return name;
    }

    static void printArray(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static int nunmberIsPrime(int n) {
        int prime = 1;
        for (int i = 2; i < n; i++) {
            if ((n % 2) == 0) {
                prime = 0;
            }
        }
        return prime;
    }

    static void writeArrayToFile(int array[][]) {
        printArray(array);
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        File myfile = new File(filename);
        try {
            PrintWriter write = new PrintWriter(myfile);
            for (int[] array1 : array) {
                for (int j = 0; j < array[0].length; j++) {
                    write.println(array1[j]);
                }
            }
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
