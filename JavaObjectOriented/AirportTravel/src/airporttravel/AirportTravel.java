/*
 DAY 04 TASK 3

Create a project AirportTravel.

In the main directory of the project, using Notepad create file "airports.txt" which will contain lines such as:

YUL;Montreal;45.4697842;-73.7554174
YYZ;Toronto;43.6777215;-79.6270084
JFK;New York JFK;40.6413151;-73.7803278,17

(Add at least 3 more lines)

Create a class Airport initially like this:

class Airport {
	String code, city;
	double latitude, longitude;
}

Add a suitable constructor, getters and setters that ensure that:
-code is always 3 upper-case letters,
- city is non-null, not empty string,
- latitude and longitude are within the correct ranges.

When your program starts you will read file "airports.txt" instantiate object type Airport for each of them and add them to

static ArrayList<Airport> airportList = new ArrayList<>();

Suggestion: read each line with nextLine(), then split(";") the result, parse doubles and pass to Airport() constructor.

Display the following menu to the user:

1. Show all airports (codes and city names)
2. Find distance between two airports by codes.
3. Find the 2 airports nearest to an airport given and display the distance.
4. Add a new airport to the list.
0. Exit.

On Exit your program must write back an updated list of airports to "airports.txt" file.

Suggestion: make a copy of "airports.txt" file just in case you lost data when overriding.

Implement the functionality listed in the menu.

Regarding item #3 - if you can't find the 2 nearest airports then find the 1 nearest airport and display the distance.


 */
package airporttravel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Airport {

    String code, city;
    double latitude, longitude;
}

/**
 *
 * @author JohnSmith
 */
public class AirportTravel {

    static ArrayList<Airport> airportList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static final String AIRPORT_NAMES = "airports.txt";


    public static void main(String[] args) {

        System.out.println("1. Show all airports (codes and city names)\n"
                + "2. Find distance between two airports by codes.\n"
                + "3. Find the 2 airports nearest to an airport given and display the distance.\n"
                + "4. Add a new airport to the list.\n"
                + "0. Exit.");

        System.out.println("Enter your selection:");
        int choice = input.nextInt();

        switch (choice) {
            case 1: {
                showAllAirports1();
                break;
            }

            case 2: {
                findDistanceBetweenTwoAirportsByCodes2();
                break;
            }
            case 3: {
                FindTheTwoairportsNearestToAnAirportGivenAndDisplayTheDistance3();
                break;
            }
            case 4: {
                addNewAirportToTheList4();
                break;
            }
            case 0: {
                exit0();
                break;}
            default:{
                
            }
            
            

        }
    }

    private static void showAllAirports1()  {
        try{  
                         File file = new File(AIRPORT_NAMES);
                         Scanner fileToScan = new Scanner(file);
            while(fileToScan.hasNextLine()){
             
             System.out.println(fileToScan.nextLine());
            }
        }
        catch( FileNotFoundException e){
            
        }
       
        
    }

    private static void findDistanceBetweenTwoAirportsByCodes2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void FindTheTwoairportsNearestToAnAirportGivenAndDisplayTheDistance3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void addNewAirportToTheList4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void exit0() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
