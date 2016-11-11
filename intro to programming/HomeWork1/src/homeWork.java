
import java.util.Scanner;

public class homeWork {

    /**
     * float f ,c; represent the temperature in farenheid and celcius
     */
    public static void main(String[] args) {
        float c, f;
        Scanner temp = new Scanner(System.in);

        System.out.println("Please enter the farenhied temparatue in farenheid: ");
        f = temp.nextFloat();
        c = (f - 32) * 5 / 9;
        System.out.println("Your celcius input temperature is: " + c);
        if (c <= -15) {
            System.out.println("It is " + c + "degrees Celsius, Let’s get out of here!");

        } else if ((-15 < c) && (c <= 0)) {
            System.out.println("it is " + c + " degrees Celsius ,Get your boots and gloves!");
        } else if ((0 < c) && (c <= 15)) {
            System.out.println("It is " + c + " degrees Celsius, , I have my sweater! ");
        } else {
        System.out.println("It is " + c + "degrees Celsius, It is BBQ time!");
        }
        
    }

    }
