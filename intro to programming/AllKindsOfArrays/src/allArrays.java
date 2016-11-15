
import java.util.*;

public class allArrays {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int arraySize;
        System.out.println("Please enter your array size : ");
        arraySize = input.nextInt();
        System.out.println();
        int[] myArray = new int[arraySize];
        int arrayElement = 0;
        for (int v : myArray) {
            myArray[arrayElement] = (int) (Math.random() * 20 + 1);
            arrayElement++;
        }
        for (int i = 0; i < myArray.length; i++) {
            System.out.println("myArray[" + i + "]" + myArray[i]);
        }
        System.out.println();
        int maxEl = myArray[0];
        int minEl = myArray[0];
        int imax, imin;
        imax = imin = 0;

        for (int i = 0; i < myArray.length; i++) {

            if ((myArray[i]) > maxEl) {
                maxEl = myArray[i];
                imax=i;
            } else if ((myArray[i]) < minEl) {
                minEl = myArray[i];
                imin=i;
            }
        }
        System.out.println("biggest element : myArray[" + imax + "] = " + maxEl);
        System.out.println("smallest element : myArray[" + imin + "] = " + minEl);

        System.out.println();
        System.out.println("array size: " + arraySize);
        System.out.println();

    }

}
