/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author JohnSmith
 */
public class guessRandomNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int random = 0;
        int input = 0;
        random = (int) (Math.random() * 20) + 1;

        System.out.println("random generated number is :" + random);

        Scanner interminal = new Scanner(System.in);

        //input the number to guess
        do {
            System.out.println("Please enter an number");
            input = interminal.nextInt();
            System.out.println("you entered number is : " + input);
            if (random < input) {
                System.out.println("you number is higher");
            } else if (random > input) {
                System.out.println("you number is lower");
            } else {
                System.out.println("you  found the number :" + random);
            }

        } while (random != input);
    }
}
