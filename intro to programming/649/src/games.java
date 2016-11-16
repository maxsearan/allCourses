
import java.util.*;

public class games {

    public static void main(String[] args) {
        int[] lotnum = new int[6];
        int[] mynum = new int[6];
        int counter = 0;

        for (int i = 0; i < 6; i++) {
            lotnum[i] = (int) (Math.random() * 49 + 1);
            System.out.println("Lottery numbers " + i + " :" + lotnum[i]);
        }
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println("Please enter your " + (i + 1) + " lottery number");
            mynum[i] = input.nextInt();
        }
        for (int i = 0; i < 6; i++) {

            System.out.println("Your numbers are: " + mynum[i]);
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; i < 6; i++) {
                if (mynum[i] == lotnum[i]) {
                    counter++;
                    System.out.println("numbers that are the same: "+counter);
                }
            }
        }

    }

}
