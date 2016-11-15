
import java.util.Scanner;

public class casino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean novalidation;

        while (choice != 3) {
            novalidation = true;
            System.out.println("Welcome to the IPD Casino");
            System.out.println("-------------------------------------");
            System.out.println();
            System.out.println("1) Play Craps");
            System.out.println();
            System.out.println("2) Play Max Number");
            System.out.println("");
            System.out.println("3) Exit");
            System.out.println();

            while (novalidation) {
                System.out.println("Please enter your choice 1, 2 or 3");
                System.out.println();
                System.out.println();
                choice = input.nextInt();
                //validation of the data entry
                if ((choice == 3) || (choice == 2) || (choice == 1)) {

                    novalidation = false;
                }

            }

            if (choice == 1) {
                System.out.println("Welcome to the CARPS game.");
            } else if (choice == 2) {
                System.out.println("Welcom to the MAXIME game.");
            }
            System.out.println();
            System.out.println();

        }
        System.out.println("You left the casino application. ");
    }

}
