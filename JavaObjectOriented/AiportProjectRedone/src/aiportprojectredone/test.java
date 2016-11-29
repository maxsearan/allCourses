package aiportprojectredone;

import java.util.Scanner;

/* Laurian Staicu 1696177
 * IPD 9 
 */
public class test {

    public static void main(String[] args) {

        int j;
        Scanner br = new Scanner(System.in);
        System.out.println("Enter a number");
        j = Integer.parseInt(br.nextLine());
        try {
            if (j < 10) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException e) {
            System.out.println("BS");

        }
    }

}
