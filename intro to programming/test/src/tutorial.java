
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JohnSmith
 */
public class tutorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        int numberToGuess = 0;

        /*       while (value != 5) {
            
            System.out.println("please enter a value : ");
         value = scanner.nextInt();
            System.out.println("you entered the value: " +value);
            if (value != 5){
            System.out.println("PLease reenter a "
                    + "value that matches our value");
        }
         */
        System.out.println("Please enter a"
                + " number that you have to guess: ");
        numberToGuess = scanner.nextInt();

        do {

            System.out.println("Please enter the "
                    + "number in order to guess it:");
            value = scanner.nextInt();

        } while (value != numberToGuess);
        System.out.println("U guessed, it was number: " + value);

    }
}
