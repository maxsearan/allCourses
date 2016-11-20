
import java.util.*;
import java.io.*;
//import java.io.File;
//import java.io.PrintWriter;

public class nestedloops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(" " + i + " " + (i + j));
            }

        }

        ///two dimensional array. We initialize wiht random
        //numbers and print it with 2 loops
        int[][] twoDimArray = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                twoDimArray[i][j] = (int) (Math.random() * 10 + 1);

            }
        }
        //Print array two dimensions
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(" " + twoDimArray[i][j] + " ");
            }
            System.out.println(" ");
        }

        for (int j = 0; j < 4; j++) {
            int sumrow = 0;
            for (int i = 0; i < 4; i++) {
                sumrow += twoDimArray[i][j];

            }
            System.out.print("Add each column :");
            System.out.print(" " + sumrow + " ");
        }

        int[][] zeroOne = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                zeroOne[i][j] = (i + j) % 2;
                System.out.print(" " + zeroOne[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");

        int ones = 0;
        int xrand, yrand;
        int[][] tenZeros = new int[10][10];
//10 randoms 1 in a 10X10 array[10][10]
        for (int i = 0; i < 10; i++) {
            xrand = (int) (Math.random() * 10);
            yrand = (int) (Math.random() * 10);
            tenZeros[xrand][yrand] = 1;
            ones++;
        }
        System.out.println("Number of random 1 is: " + ones);

        //Print the Array
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + tenZeros[i][j] + " ");
            }
            System.out.println(" ");
        }

        //BINGO CARD
        System.out.println(" ");

        System.out.println("BINGO GAME..");
        System.out.println("*************");

        int[][] bingoArray = new int[5][5];
        int random = 0;
        boolean vaidateNo = true;

        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                while (vaidateNo) {
                    random = (int) (Math.random() * 15 + 1) + 15 * j;
                    vaidateNo = false;
                    for (int k = 0; k < 5; k++) {
                        if (random == bingoArray[k][j]) {
                            vaidateNo = true;
                        }
                    }
                }

                bingoArray[i][j] = random;
                vaidateNo = true;
            }
        }
        //Print array for Bingo
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + bingoArray[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");

        //Training 2 dimensional arrays
        System.out.println("Ask for input size for 2 dim array");
        int x, y;
        int sum = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no fo rows :");
        //x = input.nextInt();
        x = 4;
        System.out.println("Enter no fo columns :");
        //y = input.nextInt();
        y = 3;
        System.out.println(" ");
        int[][] matrixInput = new int[x][y];

        for (int i = 0; i < matrixInput.length; i++) {
            for (int j = 0; j < matrixInput[0].length; j++) {
                matrixInput[i][j] = sum++;
            }

        }

        for (int i = 0; i < matrixInput.length; i++) {
            for (int j = 0; j < matrixInput[0].length; j++) {
                System.out.print(matrixInput[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println(" ");
        System.out.println("display no rows array function: \n");
        System.out.println(rowsArray(matrixInput));
        System.out.println("display no rows array function: \n");
        System.out.println(columnsArray(matrixInput));
        System.out.println("add elements of array function: \n");
        System.out.println(addArrays(matrixInput));
        System.out.println("pass 2 arrays to a function: \n");
        System.out.println(addElements(matrixInput, matrixInput));
        System.out.println("Summing elements by column and display each total \n");
        sumElemCol(matrixInput);
        System.out.println("Summing elements by row and display each total \n");
        sumElemRow(matrixInput);
        System.out.println("Reading array shorthant \n");
        readArray(matrixInput[0]);
        System.out.println("Reading Enter Unique Number and write Reverse \n");
        enterUniqueReverse();
        System.out.println("IO files  - working with files \n");
        io();
        System.out.println("IO files file2 - working with files "
                + "Ask the user for 10 names\n");
        WriteToFile();
        System.out.println("IO reading from file class exmple\n");
        readFromFile();
        System.out.println("Simple Read and Write to a file simplereadandwrite.txt");
        simplewriteandread();
        System.out.println("Loop write and read from a file");
        loopreadandwrite();
    }

    public static int rowsArray(int[][] array) {
        int value;
        value = array.length;
        return value;
    }

    public static int columnsArray(int[][] array) {
        int value;
        value = array[0].length;
        return value;
    }

    public static int addArrays(int[][] array) {
        int sumElem = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                sumElem += array[i][j];
            }
        }
        return sumElem;
    }

    public static int addElements(int[][] array1, int[][] array2) {
        int total = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                total += array1[i][j];
            }
        }
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                total += array2[i][j];
            }
        }
        return total;
    }

    public static void sumElemCol(int array[][]) {
        for (int j = 0; j < array[0].length; j++) {

            int total = 0;
            for (int i = 0; i < array.length; i++) {
                total += array[i][j];
            }
            System.out.print(" " + total);
        }
        System.out.print("\n)");
    }

    public static void sumElemRow(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            int total = 0;
            for (int j = 0; j < array[0].length; j++) {

                total += array[i][j];
            }
            System.out.print(" " + total);
        }
        System.out.print("\n)");
    }

    public static void readArray(int array[]) {
        for (int e : array) {
            System.out.print(" " + e + " ");
        }
        System.out.println();
    }

    public static void enterUniqueReverse() {
        int array1[] = new int[10];
        int array2[] = new int[10];
        System.out.println("insert unique random numbers in a array:");
        int random = 0;
        boolean vaidateNo = true;

        for (int i = 0; i < 10; i++) {

            while (vaidateNo) {
                random = (int) (Math.random() * 20 + 1);
                vaidateNo = false;
                for (int k = 0; k < 5; k++) {
                    if (random == array1[k]) {
                        vaidateNo = true;
                    }
                }
            }
            array1[i] = random;
            vaidateNo = true;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + array1[i] + " ");
        }

        System.out.println("copy arrays reverse array1 to array2");
        int k = array2.length;
        System.out.println(" ");
        for (int i = 0; i < 10; i++) {
            array2[k - 1] = array1[i];
            k--;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + array2[i] + " ");
        }

    }

    public static void io() {
        //instanciate object file for readind and writing
        File myFile = new File("mytextfile.txt");
        try {
            PrintWriter fileoutput = new PrintWriter(myFile);
            fileoutput.println("Laurian Staicu");
            fileoutput.println("ELmira da Fish ");
            fileoutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void WriteToFile() {
        //instanciate object file for readind and writing
        //ask the user for 10 names with for loop.
        String enterName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name :");
        enterName = input.next();
        File myFile1 = new File("mytextfile1.txt");

        try {
            PrintWriter fileoutput = new PrintWriter(myFile1);
            for (int i = 0; i < 10; i++) {
                fileoutput.println(enterName);
            }
            fileoutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("mytextfile1.txt was created it was written on the file.");

    }

    public static void readFromFile() {
        System.out.println("We read lines from text mytextfile1.txt and "
                + "display it on the screen. ");

        File myFile = new File("mytextfile1.txt"); // path

        Scanner input = new Scanner(System.in);
        String name;
        try {
            Scanner fileinput = new Scanner(myFile); //object 

            while (fileinput.hasNext()) {
                name = fileinput.next();
                System.out.println(name);
            }

            fileinput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void simplewriteandread() {
        //instantiates class File with object simplereadandwrite 
        //with File constructor?
        //and creates simreadandwrite.txt file
        File simplereadandwrite = new File("simplereadandwrite.txt");
        //Write Gia to simreadandwrite.txt
        try {
            PrintWriter myfileoutput = new PrintWriter(simplereadandwrite);
            myfileoutput.println("Gia");
            myfileoutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Read entry "Gia" from simreadandwrite.txt file and displays 
        try {
            Scanner myfileinput = new Scanner(simplereadandwrite);
            System.out.println(myfileinput.next());
            myfileinput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loopreadandwrite() {
        File myfile = new File("myfile.txt");
        //loop write to file string array
        String [] name = new String[20];
        
        for(int i=0;i<20;i++){
            name[i]= Integer.toString(i+(int)(Math.random()*10+1));
        }
        try {
            PrintWriter myfiletoprint = new PrintWriter(myfile);
            for (int i = 0; i < 10; i++) {
                myfiletoprint.println(name[i]);
            }
            myfiletoprint.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //loop read from file and loop display
        int i = 0;
        try {
            Scanner myfiletoread = new Scanner(myfile);
            while (myfiletoread.hasNext()) {
                name[i]=myfiletoread.next();
                System.out.println(name[i]);
                i++;
            }
            myfiletoread.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
