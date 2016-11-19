
import java.util.*;
import java.io.*;

public class q5playthegame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean inMenu = true;
        int menu = 0;

        while (inMenu) {

            System.out.println("PLAY BINGO:");
            System.out.println("");
            System.out.println("****************");
            System.out.println();
            System.out.println("1) Create the bingo card numbers :");
            System.out.println();
            System.out.println("2)  Play Bingo :");
            System.out.println();
            System.out.println("3) Exit :");
            System.out.println();

            while ((menu != 1) && (menu != 2) && (menu != 3)) {
                System.out.println("Please enter your option: ");
                menu = input.nextInt();
            }

            if (menu == 1) {
                bingoNumbers();
                menu = 0;
            } else if (menu == 2) {
                playBingo();
                menu = 0;
            } else if (menu == 3) {
                exit();
                inMenu = false;
            }
        }
    }

    public static void playBingo() {
        //recreates the arrray from reading the file
        int[][] array = new int[5][5];

        File myFile = new File("bingoFile.text"); // path
        Scanner input = new Scanner(System.in);
        try {
            Scanner fileinput = new Scanner(myFile); //object 

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    array[i][j] = fileinput.nextInt();
                }
            }
            fileinput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Your Bingo Card was generated from a file:\n");
        printarray(array);
        System.out.println("\n");
        //checking random extracted against your numbers
        int bingoArray[] = new int[75];
        int random = 0;
        boolean vaidateNo = true;
        int mybingocount = 0;

        System.out.println("You started to play Bingo :\n");

        for (int i = 0; (i < 75) && vaidateNo; i++) {

            while (vaidateNo) {
                random = (int) (Math.random() * 75 + 1);
                vaidateNo = false;//set to false to validate against the array
                //checks all the previous elements to elements i to verify if here is a match
                for (int k = 0; k <= i; k++) {
                    if (random == bingoArray[k]) {
                        //random nunmber found. flag is set to true. random number needed again.
                        vaidateNo = true;
                    }
                }
            }
            vaidateNo = true;
            bingoArray[i] = random;
            for (int k = 0; k < 5; k++) {
                for (int l = 0; l < 5; l++) {
                    if (array[k][l] == bingoArray[i]) {
                        System.out.println("Your Bingo number is :" + bingoArray[i] + "\n");
                        printarray(array);
                        array[k][l] = 0;
                        mybingocount++;

                    }
                    if ((colsum(k, l, array) == 0) || (rowsum(k, l, array) == 0)) {
                        vaidateNo = false;
                        break;
                    }
                }
            }

        }
        int countbingo = 0;
        for (int i = 0; ((i < 75) && (bingoArray[i] != 0)); i++) {
            System.out.print(bingoArray[i] + " ");
            countbingo++;
        }
        System.out.println("\n\nBingo numbers until your BINGO :" + countbingo + "\n");
        System.out.println("Total of your Bingo numbers: " + mybingocount + "\n");
        System.out.println("Your BINGO\n");
        printarray(array);
    }

    public static void printarray(int array[][]) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("\n");
        }
        System.out.println("\n\n");

    }

    public static int colsum(int i, int j, int array[][]) {
        int colsum = 0;
        for (int k = 0; k < 5; k++) {
            colsum = colsum + array[k][j];
        }
        return colsum;
    }

    public static int rowsum(int i, int j, int array[][]) {
        int rowsum = 0;
        for (int k = 0; k < 5; k++) {
            rowsum = rowsum + array[i][k];
        }
        return rowsum;
    }

    public static void bingoNumbers() {
        System.out.println("\nBINGO generating card..");
        System.out.println("*************\n");
        System.out.println("Numbers are saved to bingoFile.text file.\n");

        int[][] bingoArray = new int[5][5];
        int random = 0;
        boolean vaidateNo = true;
        //Insert unique random number per column  
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                while (vaidateNo) {
                    random = (int) ((Math.random() + j) * 15 + 1);
                    vaidateNo = false;
                    for (int k = 0; k <= i; k++) {
                        if (random == bingoArray[k][j]) {
                            vaidateNo = true;
                        }
                    }
                }

                bingoArray[i][j] = random;
                vaidateNo = true;
            }
        }
        //Print the Bingo array
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + bingoArray[i][j] + " ");
            }
            System.out.println(" ");
        }
        //write the numbers in a file
        writeBingoNumberstoFile(bingoArray);
        System.out.println(" ");

    }

    public static void writeBingoNumberstoFile(int array[][]) {
        int num;
        File bingoFile = new File("bingoFile.text");
        try {
            PrintWriter fileoutput = new PrintWriter(bingoFile);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    fileoutput.println(array[i][j]);
                    //System.out.println("Printed to file."+array[i][j]);
                }
            }
            fileoutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exit() {
        System.out.println("\nExit\n");
    }
}
