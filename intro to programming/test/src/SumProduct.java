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
public class SumProduct {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        int theSum = 0;
        int theProduct = 0;

        System.out.println("enter the first number");
        num1 = input.nextInt();
        System.out.println("enter the second number");
        num2 = input.nextInt();

        theSum = num1 + num2;
        theProduct = num1 * num2;

        System.out.println("the sum of the numbers is: " + theSum);
        System.out.println("the product is: " + theProduct);
    }

}
