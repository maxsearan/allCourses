
// @author Elmira
import java.util.Scanner;

public class Elmira {

    public static void main(String[] args) {
        int n = 0;
        Scanner elmira = new Scanner(System.in);

        do {
            System.out.println("Welcome to IDP");
            System.out.println("****************");
            System.out.println("1 - Guess a number");
            System.out.println("2 - Try your luck");
            System.out.println("3 - Exit");
            while (n < 1 || n > 3) {
                System.out.println("Enter Your Choice:");
                n = elmira.nextInt();
            }
            if (n == 1) {
                System.out.println("Welcome to the guessing Game");
                System.out.println("******************************");
                guessingGame();
                n = -1;
            } else if (n == 2) {
                System.out.println("Welcome to try your luck");
                luckGame();
                n = -1;
            } else if (n == 3) {
                System.out.println("Exit");
            }
        } while (n < 3);
    }

    public static void guessingGame() {
        int randomNum = 0;
        int guessedNum = 0;
        int n1 = 0;
        Scanner elmira = new Scanner(System.in);
        randomNum = (int) (Math.random() * 100 + 1);

        System.out.println("the random number is " + randomNum);

        do {
            System.out.println("Guess a number: ");
            guessedNum = elmira.nextInt();
            if (guessedNum == randomNum) {
                System.out.println("You are a winner");
                //LS
                return;
                //LS

            } else {
                System.out.println("Better luck next time!Play again");
            }

            if (guessedNum > randomNum) {

                System.out.println("Guessed number is higher than random Number ");
            } else if (guessedNum < randomNum) {
                System.out.println("Guessed number is lower than random Number");

                n1++;

            }

        } while (n1 < 7);

    }

    public static void luckGame() {
        Scanner elmira = new Scanner(System.in);
        int[] myInt = new int[6];
        for (int i = 0; i < myInt.length; i++) {

            myInt[i] = (int) (Math.random() * 50 + 1);
            System.out.println(myInt[i]);

        }
        int max = myInt[0];
        for (int i = 0; i < myInt.length; i++) {
            if (myInt[i] > max) {
                max = myInt[i];
            }
        }
        System.out.println("the max Number is: " + max);

        int min = myInt[0];
        for (int i = 0; i < myInt.length; i++) {
            if (myInt[i] < min) {
                min = myInt[i];

            }
        }
        System.out.println("the min Number is: " + min);

        int diff = 0;
        diff = max - min;
        System.out.println("the Difference between max and min is: " + diff);
        System.out.println("enter a number: ");
        int number = elmira.nextInt();
        for (int i = 0; i < 6; i++) {
            if (myInt[i] == number) {
                System.out.println("the number " + number + " was found in the array.");
                return;
            }

        }
        System.out.println("display the " + number + " is not found in the array");

    }
}
