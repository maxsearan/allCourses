/*Write a program that finds your Chinese Sign. 
Use a Switch statement.*/
import java.util.Scanner;

public class q4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year ;
        int sign ;
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
