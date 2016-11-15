
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
public class sum {
    
    public static void main(String[] args) {
        float a;
        Scanner in = new Scanner(System.in);
        System.out.println("Input your number :");
        a = in.nextFloat();

        System.out.println("your input amount is " + a);
        System.out.println("you have " + (int) a / 2 + " toonies");
        System.out.println("you have " + (int) (a * 100) % 200 / 100 + " loonie");
        System.out.println("you have " + (int) (a * 100) % 100 / 25 + " quarters");
        System.out.println("you have " + (int) (a * 100) % 25 / 10 + " dimes");
        System.out.println("you have " + (int) (a * 100) % 10 / 5 + " nickels");
    }
}
