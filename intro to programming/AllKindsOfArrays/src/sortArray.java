
import java.util.Arrays;

public class sortArray {

    public static void main(String[] args) {
        int[] myArray = new int[10];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (int) (Math.random() * 10 + 1);
        }
        System.out.println(Arrays.toString(myArray));
//Reverse the array
        int tempELement1, tempElement2;
        System.out.println(myArray.length);
        for (int i = 0; i < myArray.length / 2; i++) {
            tempELement1 = myArray[myArray.length - 1 - i];
            tempElement2 = myArray[i];
            myArray[myArray.length - 1 - i] = tempElement2;
            myArray[i] = tempELement1;

        };
        System.out.println(Arrays.toString(myArray));
        
    }

}
