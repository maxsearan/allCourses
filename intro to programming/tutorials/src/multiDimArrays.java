
import java.util.Arrays;
import java.util.Scanner;

public class multiDimArrays {

    public static void main(String[] args) {
        /* find max and min in an array*/

        int dimAr;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your array size: ");
        dimAr = input.nextInt();
        int[] myArray = new int[dimAr];
        System.out.println("Your array has the size: " + myArray.length);
        System.out.println();

        for (int t : myArray) {

            dimAr--;
            //System.out.println(dimAr);

            myArray[dimAr] = (int) (Math.random() * 6) + 1;

        }
        int winNum = -1;
        do {
            System.out.println("Enter winning number from 1 to 6: ");
            winNum = input.nextInt();
        } while ((winNum > 6) || (winNum < 0));

        System.out.println("you entered winning number :"
                + winNum);
        int no1, no2, no3, no4, no5, no6, notwin;
        no1 = no2 = no3 = no4 = no5 = no6 = notwin = 0;

        System.out.println();
        for (int v = 0; v < myArray.length; v++) {
            //System.out.println("myArray[" + v + "]=" + myArray[v]);
            switch (myArray[v]) {
                case 1: {
                    no1++;
                    //System.out.println("Bravo you won with 1: " + no1 + " times");
                    break;
                }

                case 3: {
                    no3++;
                    //System.out.println("Bravo you won with 3: " + no3 + " times");
                    break;
                }

                default: {
                    notwin++;
                    //System.out.println("times u didnt win: " + notwin);
                    break;
                }

            }
        }
        System.out.println("Bravo you won with 1 : " + no1 + " times");
        System.out.println("Bravo you won with 3 : " + no3 + " times");
        System.out.println("times u didnt win: " + notwin);

        // Loop through 0, 1, and 2.
        /*for (int i = 0; i <= 4; i++) {
            // Switch on number.

            System.out.println();
            System.out.println("i = " + i);
            switch (i) {
                case 1: {
                    System.out.println("1) One: " + i);
                    break;
                }
                case 2:
                case 3: {
                    System.out.println("3) three: " + i);
                }
                default: {
                    System.out.println("Default case: " + i);
                }
            }
        }*/
    }
}
