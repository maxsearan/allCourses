
public class q1 {

    public static void main(String[] args) {

        int array01[] = new int[10];
        int array02[] = new int[10];
        System.out.println("insert unique random numbers in a array: \n");
        int random = 0;
        boolean vaidateNo = true;

        for (int i = 0; i < 10; i++) {

            while (vaidateNo) {
                random = (int) (Math.random() * 20 + 1);
                vaidateNo = false;//set to false to validate agaisnt the array
                //checks all the previous elements to elements i to verify if here is a match
                for (int k = 0; k <= i; k++) {
                    if (random == array01[k]) {
                        //random nunmber found. flag is set to true. random number needed again.
                        vaidateNo = true;
                    }
                }
            }
            array01[i] = random;
            vaidateNo = true;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + array01[i] + " ");
        }
        System.out.println("\n\ncopy arrays reverse array1 to array2:");
        int k = array02.length;
        System.out.println(" ");
        for (int i = 0; i < 10; i++) {
            array02[k - 1] = array01[i];
            k--;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + array02[i] + " ");
        }

    }

}
