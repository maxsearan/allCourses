
import java.util.*;

public class menu {

    public static void main(String[] args) {
        /*"inMenu" repeats the menu after the functions are called
 "menu" is to check the validation of the menu selection*/
        Scanner input = new Scanner(System.in);
        boolean inMenu = true;
        int menu = 0;

        while (inMenu) {

            System.out.println("Enter Menu Here:");
            System.out.println("");
            System.out.println("****************");
            System.out.println();
            System.out.println("1) Menu 1 :");
            System.out.println();
            System.out.println("2) Menu 2 :");
            System.out.println();
            System.out.println("3) Exit :");
            System.out.println();

            while ((menu != 1) && (menu != 2) && (menu != 3)) {
                System.out.println("Please enter your option: ");
                menu = input.nextInt();
            }

            if (menu == 1) {
                menuFunction1();
                menu = 0;
                System.out.println("Menu has the value: " + menu);
            } else if (menu == 2) {
                menuFunction2();
                menu = 0;

            } else if (menu == 3) {
                exit();
                inMenu = false;
            }

        }
    }

    public static void menuFunction1() {
        System.out.println();
        System.out.println("this is  menu 1");
        System.out.println();
    }

    public static void menuFunction2() {
        System.out.println();
        System.out.println("this is menu 2");
        System.out.println();

    }

    public static void exit() {
        System.out.println();
        System.out.println("Exit");
        System.out.println();

    }
}
