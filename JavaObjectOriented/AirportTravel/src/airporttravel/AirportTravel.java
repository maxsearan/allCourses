package airporttravel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Airport {

    Airport(String code) {
        setCode(code);
    }

    Airport(String code, String city) {
        setCode(code);
        setCity(city);
    }

    Airport(String code, String city, double latitude) {
        setCode(code);
        setCity(city);
        setLatitude(latitude);
    }

    Airport(String code, String city, double latitude, double longitude) {
        setCode(code);
        setCity(city);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    private String code;
    private String city;
    private double latitude;
    private double longitude;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {

        if (code.length() == 3 && code.matches("[A-Z]+")) {
            this.code = code;
            return;
        }
        throw new IllegalArgumentException("Code must Have 3 upper-case letters");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city.equals("") || city.isEmpty()) {
            throw new IllegalArgumentException("City must be non-null and not empty string");
        }
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        if (latitude <= 90 && latitude >= -90) {
            this.latitude = latitude;
            return;
        }
        throw new IllegalArgumentException("latitude between -90 and 90");
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {

        if (longitude <= 180 && longitude >= -180) {
            this.longitude = longitude;
            return;
        }
        throw new IllegalArgumentException("longitude between -180 and 180");

    }

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
        String line;
        int numerOfAiportsInFile = 0;
        File file = new File(AIRPORT_NAMES);
        try {
            Scanner fileToRead = new Scanner(file);
            while (fileToRead.hasNextLine()) {
                line = fileToRead.nextLine();
                String delims = ";";
                String[] tokens = line.split(delims);
                String code = tokens[0];
                String city = tokens[1];
                double latitude = Double.parseDouble(tokens[2]);
                double longitude = Double.parseDouble(tokens[3]);
                Airport airport = new Airport(code, city, latitude, longitude);
                airportList.add(airport);
                numerOfAiportsInFile++;
            }
            fileToRead.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not read.");
        }
        for (;;) {
            System.out.println("\n1. Show all airports (codes and city names)\n"
                    + "2. Find distance between two airports by codes.\n"
                    + "3. Find the 2 airports nearest to an airport given and display the distance.\n"
                    + "4. Add a new airport to the list.\n"
                    + "0. Exit.");
            int choice = 0;
            for (;;) {
                try {
                    System.out.println("Please enter choice 0;1;2;3;4");
                    choice = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException ime) {
                    System.out.println("Please enter valid data");
                    input.nextLine();
                }
            }
            switch (choice) {
                case 1: {
                    showAllAirports1();
                    break;
                }

                case 2: {
                    displayDistanceOf2Airports2();
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
                    exit0(numerOfAiportsInFile);
                    return;
                }
                default: {
                    System.err.println("Fatal error: invalid control flow");
                    System.exit(1);
                }

            }
        }
    }

    private static void showAllAirports1() {
        //ONE WAY TO DO IT
        /*for (Airport a : airportList) {
            System.out.printf("code=%s  city=%s  latitude=%.7f longitude=%.7f %n",
                    a.getCode(), a.getCity(), a.getLatitude(), a.getLongitude());
        }*/
        for (int i = 0; i < airportList.size(); i++) {
            Airport a = airportList.get(i);
            System.out.printf("code=%s  city=%s  latitude=%.7f longitude=%.7f %n",
                    a.getCode(), a.getCity(), a.getLatitude(), a.getLongitude());

        }

    }

    private static void displayDistanceOf2Airports2() {

        System.out.println("Calculate the distance Between 2 airports.");
        System.out.println("Enter the code of the first and second Airport: ");
        String aCode = enterAndValidateAirportCode();
        String bCode = enterAndValidateAirportCode();

        System.out.printf("Distance between %.2f miles %n", calculateDistancebetween2Airports(aCode, bCode));

    }

    private static double calculateDistancebetween2Airports(String aCode, String bCode) {

        double lat1 = 0, lat2 = 0, lon1 = 0, lon2 = 0, distance = 0;
        for (int i = 0; i < airportList.size(); i++) {
            Airport a = airportList.get(i);

            Airport b = airportList.get(i);

            if (a.getCode().contains(aCode)) {
                lat1 = a.getLatitude();
                lon1 = a.getLongitude();
            }
            if (b.getCode().contains(bCode)) {
                lat2 = b.getLatitude();
                lon2 = b.getLongitude();
            }
        }
        distance = distance(lat1, lon1, lat2, lon2);
        return distance;
    }

    private static void FindTheTwoairportsNearestToAnAirportGivenAndDisplayTheDistance3() {
        String code, code1 = "", code2 = "";
        int kMinIndex = 0;
        Double distance = Double.POSITIVE_INFINITY, minDistance = Double.POSITIVE_INFINITY;
        Double secondMinDistance = Double.POSITIVE_INFINITY;
        Airport a, nA1, nA2, temp;
        System.out.println("Find the 2 nearest airports to a an airport.");
        System.out.println("Enter the code of your airport:");
        code = enterAndValidateAirportCode();
        for (int i = 0; i < airportList.size(); i++) {
            a = airportList.get(i);
            if (code.contains(a.getCode())) {
                for (int j = 0; j < airportList.size(); j++) {
                    temp = airportList.get(j);
                    distance = calculateDistancebetween2Airports(a.getCode(), temp.getCode());
                    if (distance < minDistance && i != j) {
                        minDistance = distance;
                        nA1 = airportList.get(j);
                        code1 = nA1.getCode();
                        kMinIndex = j;
                    }
                }
                for (int j = 0; j < airportList.size(); j++) {
                    temp = airportList.get(j);
                    distance = calculateDistancebetween2Airports(a.getCode(), temp.getCode());
                    if (distance < secondMinDistance && kMinIndex != j && i != j) {
                        secondMinDistance = distance;
                        nA2 = airportList.get(j);
                        code2 = nA2.getCode();
                    }
                }
            }

        }
        System.out.printf("The nearest airport from %s is %s at %.1f miles %n", code, code1, minDistance);
        System.out.printf("The second nearest airport from %s is %s at %.1f miles %n", code, code2, secondMinDistance);

    }

    private static void addNewAirportToTheList4() {
        String code, city;
        float longitude, latitude;
        System.out.println("Enter code, city, longitude, latitude for a new airport to the list.");
        code = enterAndValidateAirportCode();
        city = input.nextLine();
        longitude = Float.parseFloat(input.nextLine());
        latitude = Float.parseFloat(input.nextLine());

        Airport a = new Airport(code, city, longitude, latitude);
        airportList.add(a);

    }

    private static void exit0(int numerOfAiportsInFile) {
        //TO DO  WRITE THE ARRAY THE THE FILE AIRPORT.TXT
        for (int i = numerOfAiportsInFile; i < airportList.size(); i++) {
            Airport a = airportList.get(i);
            File file = new File(AIRPORT_NAMES);
            try {
                
                //true = append file
                FileWriter fileWritter = new FileWriter(file.getName(), true);
                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                
                bufferWritter.write("\n" + a.getCode() + ";" + a.getCity() + ";" + a.getLatitude() + ";" + a.getLongitude());
                bufferWritter.close();

            } catch (FileNotFoundException e) {
                System.out.println("File not found: "+ file.toString());
            }catch(IOException e){
                System.out.println("Unable to read file: " + file.toString());
            }
        }
        System.out.printf("Number of aiports %d added %n", airportList.size() - numerOfAiportsInFile);

        System.out.println("the aiport.txt file was updated and bye for now!");

    }

    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
 /*::	This function converts decimal degrees to radians						 :*/
 /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
 /*::	This function converts radians to decimal degrees						 :*/
 /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    private static String enterAndValidateAirportCode() {
        String code;
        code = "";
        boolean codevalide = false;
        while (!codevalide) {
            code=input.nextLine();
            if (code.length() == 3 && code.matches("[A-Z]+")) {
                codevalide = true;
            }
            System.out.println("Please enter valid code for airport 3 upper-case letters.");
        }
        
        return code;
    }
}
