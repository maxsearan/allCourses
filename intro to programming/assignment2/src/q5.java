/*
 Write a program that calls two methods (functions).
a) The first method is called “title”. 
This method does not receive any parameters and 
does not return any values. All it does is to print the following:
**************** 
* This is my TITLE * 
****************
b) The second method is called “max”. This method receives two integers and returns the largest integer of the two (if they are equal, it just return any of the integers).
Call your method with the following values:
Largest = max(10,15)
 */
import java.util.Scanner;

public class q5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Largest;
        title();
        int i1, i2;
        System.out.println("Please enter the first number : ");
        i1 = input.nextInt();
        System.out.println("Please enter the second ");
        i2 = input.nextInt();
        Largest = max(i1, i2);
        System.out.println("The largest number is: " + Largest);
    }

    public static void title() {
        System.out.println("****************");
        System.out.println("* This is my TITLE *");
        System.out.println("****************");
        System.out.println();
        System.out.println();
    }

    public static int max(int i1, int i2) {
        int max;
        if (i1 >= i2) {
            max = i1;
        } else {
            max = i2;
        }
        return max;

    }
}
