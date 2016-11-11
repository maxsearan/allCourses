
import java.util.Scanner;

/**
 *
 * @author laurian staicu
 */
public class homework12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float a;
        int acents, r;
        Scanner amount = new Scanner(System.in);

        System.out.println("Plese enter the amount of dollars:");

        a = amount.nextFloat();
        acents = (int) (a * 100);
        System.out.println("you have " + acents + "cents");

        r = (int) a / 2;
        System.out.println("number of toonies " + r);
        acents = acents - r * 2 * 100;
        System.out.println("you have " + acents + " cents left to sort");

        r = (int) acents / 100;
        System.out.println("you have " + r + " loonie");
        acents = acents - r * 100;
        System.out.println("you have left " + acents + " cents to sort");

        r = (int) acents / 25;
        System.out.println("you have " + r + " quarters");
        acents = acents - r * 25;
        System.out.println("you have left " + acents + " cents to sort");

        r = (int) acents / 10;
        System.out.println("you have " + r + " dimes");
        acents = acents - r * 10;
        System.out.println("you have left " + acents + " cents to sort");

        r = (int) acents / 10;
        System.out.println("you have " + r + " nickel");
        acents = acents - r * 10;
        System.out.println("you have left " + acents + " cents to sort");

    }

}
