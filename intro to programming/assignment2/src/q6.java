/*
Rewrite (refactor) your menu.
Rewrite the menu in part 3, by using methods (i.e functions). 
When you select 1 as a choice , 
you will call a method that will play the game of craps 
that you designed in part2.
When you select 2 as a choice, 
you will call a method that will let you find you Chinese Sign.
 */

import java.util.*;

public class q6 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            choice = 0;
            System.out.println();
            System.out.println("Welcome to the IDP Menu ");
            System.out.println("-----------------------------------");
            System.out.println();
            System.out.println("1. Play the game of craps");
            System.out.println("2. What is your Chinese Sign?");
            System.out.println("3. Exit");
            System.out.println();
            System.out.println("Please enter your choice: ");
            while ((choice != 1) && (choice != 2) && (choice != 3)) {
                choice = input.nextInt();
                System.out.println();
            }
            if (choice == 1) {
                System.out.println("Welcome to the game of craps");
                System.out.println();
                playcraps();
            } else if (choice == 2) {
                System.out.println("Looking for your Chinese sign");
                System.out.println();
                chinesesign();
            } else if (choice == 3) {
                System.out.println("You exit the system.");
                System.out.println();
                System.out.println();
            }
        } while (choice != 3);

    }

    public static void playcraps() {
        int dice1, dice2, maxNumTosses, winner;

        maxNumTosses = 1;

        do {
            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);
            winner = dice1 + dice2;
            System.out.println(" Dice 1 :" + dice1 + " Dice 2 :" + dice2 + " Sum: " + winner);
            maxNumTosses++;

        } while ((maxNumTosses < 7) && (winner != 7));
        if (winner == 7) {
            System.out.println("You are a winner …");
        } else {
            System.out.println("Better luck next time! Play again");
        }

    }

    public static void chinesesign() {
        Scanner input = new Scanner(System.in);
        int year;
        int sign;
        System.out.println("Please enter your year of birth: ");
        year = input.nextInt();
        sign = year % 12;

        switch (sign) {
            case 0:
                System.out.println("Your chinese year is monkey");
                break;
            case 1:
                System.out.println("Your chinese year is rooster");
                break;
            case 2:
                System.out.println("Your chinese year is dog");
                break;
            case 3:
                System.out.println("Your chinese year is pig");
                break;
            case 4:
                System.out.println("Your chinese year is rat");
                break;
            case 5:
                System.out.println("Your chinese year is ox");
                break;
            case 6:
                System.out.println("Your chinese year is tiger");
                break;
            case 7:
                System.out.println("Your chinese year is rabbit");
                break;
            case 8:
                System.out.println("Your chinese year is dargon");
                break;
            case 9:
                System.out.println("Your chinese year is snake");
                break;
            case 10:
                System.out.println("Your chinese year is horse");
                break;
            case 11:
                System.out.println("Your chinese year is sheep");
                break;

        }
    }

}
