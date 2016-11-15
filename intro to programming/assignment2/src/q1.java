/*
 (3 POINTS) Write a small java program that executes the following logic:
The program prompts the user for a temperature in degrees Fahrenheit (i.e. 75, 78.3, -10.5,
etc.). Then program then converts the temperature to degrees Celsius according to the formula:
°C = (°F - 32) x 5/9
Then the program prints a message according to the following logic:
If the temperature (Celsius) is less than or equal to -15.0 print:
 “It’s (temp) degrees Celsius, Let’s get out of here!”
If the temperature is higher than -15.0 but less than or equal to 0.0 then print:
 “It’s (temp) degrees Celsius, Get your boots and gloves!”
If the temperature is higher than 0.0 but less than or equal to 15.0 then print:
“It’s (temp) degrees Celsius, I have my sweater!”
If the temperature is higher than 15.0 then print:
“It’s (temp) degrees Celsius, It is BBQ time!!”
Use the if else if structure.
 */

import java.util.*;

public class q1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the temperature in Fahrenheit: ");
        double farTemp = input.nextDouble();
        double celTemp = (farTemp - 32) * 5 / 9;
        System.out.println("Your temperature in Celcius is:" + Math.round(celTemp * 10.0) / 10.0);

        if (celTemp <= -15) {
            System.out.println("It’s " + Math.round(celTemp * 10.0) / 10.0 + " degrees Celsius, Let's get out of here!");
        } else if ((celTemp > -15) && (celTemp <= 0)) {
            System.out.println("It’s " + Math.round(celTemp * 10.0) / 10.0 + " degrees Celsius, Get your boots and gloves!");
        } else if ((celTemp > 0) && (celTemp <= 15)) {
            System.out.println("It’s " + Math.round(celTemp * 10.0) / 10.0 + " degrees Celsius, I have my sweater!");
        } else {
            System.out.println("It’s " + Math.round(celTemp * 10.0) / 10.0 + " degrees Celsius, It is BBQ time!!");
        }
    }

}
