
import java.util.*;

public class test1 {

    public static void main(String[] args) {

        int choice = 0;
        Scanner input = new Scanner(System.in);
        boolean menu = true;
        while (menu) {

            System.out.println("\n");
            System.out.println("Welcome to IDP :");
            System.out.println("****************");
            System.out.println("\n");

            System.out.println("1- Guess a number.");
            System.out.println("\n");
            System.out.println("2 - Try you luck.");
            System.out.println("\n");
            System.out.println("3-  Exit.");
            System.out.println("\n");
            while ((choice != 1) && (choice != 2) && (choice != 3)) {
                choice = input.nextInt();
                System.out.println();
            }
            if (choice == 1) {
                guessinggame();
                choice = 0;
            } else if (choice == 2) {

                tryyourluck();
                choice = 0;
            } else if (choice == 3) {
                System.out.println("You exit the system.");
                menu = false;
                System.out.println();
            }

        }
    }

    public static void guessinggame() {
        System.out.println("Welcome to the guessing Game");
        System.out.println();
        Scanner input = new Scanner(System.in);
        int guessnum;
        System.out.println();
        int progrand = (int) (Math.random() * 100 + 1);
        System.out.println();
        System.out.println("number to guess:" + progrand);

        for (int i = 1; i <= 7; i++) {
            System.out.println();
            System.out.println("Please enter your guess number:");
            System.out.println();
            guessnum = input.nextInt();
            System.out.println("your guess no is :" + guessnum);

            if (guessnum > progrand) {

                System.out.println("your number is bigger");
            } else if (guessnum < progrand) {
                System.out.println("your number is smaller");
            } else {
                System.out.println("Bravo you won!");
                return;

            }

        }
        System.out.println("Wish the user better luck");

    }

    public static void tryyourluck() {
        System.out.println("Welcome to try your luck");
        System.out.println();
        int[] array = new int[10];
        int max;
        int min;
        int diff;
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 50 + 1);
            System.out.print(" " + array[i] + " ");
        }
        max = array[0];
        for (int i = 0; i < 10; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        min = array[0];
        for (int i = 0; i < 10; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        diff = max - min;
        System.out.println();
        System.out.println();
        System.out.println(" Max: " + max + " Min: " + min + " Diff: " + diff);
        Scanner input = new Scanner(System.in);
        int guessnum;
        System.out.println();
        System.out.println("Please enter your number:");
        System.out.println();
        guessnum = input.nextInt();
        System.out.println();
        for (int i = 0; i < 10; i++) {
            if (guessnum == array[i]) {
                System.out.println("The number " + guessnum + " is found at position " + (i + 1));
                return;
            }

        }
        System.out.println("The number is not found in the array");
    }
}
