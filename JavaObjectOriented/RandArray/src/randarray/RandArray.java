
/**
 * TASK 1
 *
 * Create a project RandArray.
 *
 * Declare an array of 10 integer values.
 *
 * Use one for loop to write to it
 * 10 random integers between 1-100.
 *
 * Use *another* for loop to print out
 * all integer values larger or equal to 70.
 *
 * BONUS: Find an print out all prime numbers, if any.
 *
 *
 */
public class RandArray {

    public static void main(String[] args) {

        int[] intArray = new int[10];
        {
        int i = 2, j = 3;
        int k= i++ +j;
        System.out.printf("i = %d ,k = %d\n",i,k);
        }
        for (int i = 0; i < 10; i++) {
            intArray[i] = (int) (Math.random() * 100 + 1);

        }
        for (int i = 0; i < 10; i++) {
            if((intArray[i])>=70){
                System.out.print(intArray[i]+" ");
            }
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            if(isPrime(intArray[i])){
                System.out.print(intArray[i]+" ");

        }
    }
    }
    
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}

