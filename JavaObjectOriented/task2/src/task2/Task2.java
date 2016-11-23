package task2;

/*TASK 2 - project SimpleCalc

Ask user to choose an option from menu:
1. Add
2. Subtract
3. Multiply
4. Divide

If user enters an invalid choice, display error message and exit.

Otherwise ask user for 2 floating point values,
perform the needed computation and display the result.

BONUS: Add one more option to the menu.
0. Exit

And add a loop around the entire program so that
the menu is displayed repeatedly until user asks to exit.

Suggestion: instead of do-while loop use
an infinite loop and a break/return.*/
import java.util.*;



public class Task2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("input 2 floating numbers");
        float n1,n2;
        n1 = input.nextFloat();
        n2 = input.nextFloat();
        boolean exit = true;
        int choice ;
        while (exit) {

            System.out.println("1.Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.println("make your choice 1 2 3 4 or exit");
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                   System.out.println((n1+n2));
                    break;
                }
                case 2: {
                    System.out.println((n1-n2));
                    break;
                }
                case 3: {
                    System.out.println((n1*n2));
                    break;
                }
                case 4: {
                    System.out.println((n1/n2));
                    break;
                }
                case 5: {
                   exit = false;
                    System.out.println("exit");
                   break;
                }
                default:{  
                    exit = false;
                    System.out.println("invalid choice,bye");
                     break;
                }
            }

        }

    }
}
