/*(4 POINTS) A) Write a java program that simulates a text menu as follows:
Welcome to the IDP Menu 
-----------------------------------

1. Play the game of craps
2. What is your Chinese Sign?
3. Exit

Enter your choice:

Using a DO – WHILE loop, construct the logic for the menu. 

First print the menu, the prompt the user for a choice. 
Once you retrieve the choice from the user, print a message as follows:

If the choice is 1, then print:
“Welcome to the game of craps”

If the choice is 2, then print:
“Looking for your Chinese sign”

Once the message is printed, you should display the full menu again.
We exit the menu when the user enters 3 as a choice.

b) Use another while loop, right after prompting the user for a choice, 
in order to validate that the user only enters a choice between 1 and 3)*/

import java.util.*;

public class q3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            choice = 0;
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
            } else if (choice == 2) {
                System.out.println("Looking for your Chinese sign");
                System.out.println();
            } else if (choice == 3) {
                System.out.println("You exit the system.");
                System.out.println();
            }
        } while (choice != 3);

    }

}
