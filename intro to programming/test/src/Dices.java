
import java.util.Scanner;

public class Dices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int d1 = 0;
        int d2 = 0;
        int t = 0;
        int tintheloop = 0;

        // TODO code application logic here
        Scanner tosses = new Scanner(System.in);
        System.out.println("PLease enter the number of tosses :");
        t = tosses.nextInt();
        
        while ((t<2)||(t>10)){
        System.out.println("PLease enter again the number of tosses :");
        t = tosses.nextInt();
        
        System.out.println("number of tosses you entered: " + t);
        }
        while ((t > 0 )&& ((d1 + d2) != 7) && (tintheloop <7) ) {
            tintheloop = tintheloop + 1;
            System.out.println();
            System.out.println("no toss of the dice: " + tintheloop);

            d1 = (int) (Math.random() * 6) + 1;
            System.out.println("first dice shows: " + d1);
            d2 = (int) (Math.random() * 6) + 1;
            System.out.println("first dice shows: " + d2);
            System.out.println("the sum of the 2 number is : " + (d1 + d2));
            t--;
        }
    }

}
