package quiz2passports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Passport {

    public Passport(String number, String firstName, String lastName, String address,
            String city, double heightCm, double weightKg, int yob) {
        setNumber(number);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCity(city);
        setHeightCm(heightCm);
        setWeightKg(weightKg);
        setYob(yob);

    }

    private String number;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private double heightCm;
    private double weightKg;
    private int yob;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (city == null || city.length() < 1) {
            throw new IllegalArgumentException("number must not be empty");
        }
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (city == null || city.length() < 1) {
            throw new IllegalArgumentException("City name must not be empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (city == null || city.length() < 1) {
            throw new IllegalArgumentException("Last name must not be empty");
        }
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (city == null || city.length() < 1) {
            throw new IllegalArgumentException("Address name must not be empty");
        }
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city == null || city.length() < 1) {
            throw new IllegalArgumentException("City name must not be empty");
        }
        this.city = city;
    }

    public double getHeightCm() {

        return heightCm;
    }

    public void setHeightCm(double heightCm) {
        this.heightCm = heightCm;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }
}

/* Laurian Staicu 1696177
 * IPD 9 
 */
public class Quiz2Passports {

    static ArrayList<Passport> passList = new ArrayList<>();
    static final String FILE_NAME = "passports.txt";

    static void readPassports() throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File(FILE_NAME));
        while (fileInput.hasNextLine()) {
            String fileLine = null;
            try {
                fileLine = fileInput.nextLine();

                String data[] = fileLine.split(";");
                if (data.length != 8) {
                    throw new IllegalArgumentException("Line malformed: " + fileLine);
                }
                String number = data[0];
                String firstName = data[1];
                String lastName = data[2];
                String address = data[3];
                String city = data[4];
                double heightCm = Double.parseDouble(data[5]);
                double weightKg = Double.parseDouble(data[6]);
                int yob;
                yob = Integer.parseInt(data[7]);

                passList.add(new Passport(number, firstName, lastName, address, city, heightCm, weightKg, yob));
            } catch (IllegalArgumentException e) {
                System.err.println("Skipping invalid input line: " + fileLine);
            }
        }
        fileInput.close();
    }

    private static int getMenuChoice() {
        while (true) {
            System.out.println("1. Display all passports data (one per line)\n"
                    + "2. Display all passports for people in the same city (ask for city name)\n"
                    + "3. Find the tallest person and display their info.\n"
                    + "4. Find the lightest person and display their info.\n"
                    + "5. Display all people younger than certain age (ask for max age, not year)\n"
                    + "6. Add person to list (in memory only)\n"
                    + "0. Save data back to file and exit.");
            System.out.print("Enter choice [0-6]: ");
            try {
                int choice = input.nextInt();
                input.nextLine();
                if (choice < 0 || choice > 6) {
                    System.out.println("Invalid choice, try again");
                } else {
                    return choice;
                }
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid choice, try again");
            }
        }
    }
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            readPassports();
            while (true) {
                int choice = getMenuChoice();
                switch (choice) {
                    case 0:
                        // save all airports back to file
                        saveAllPassortsToFile();
                        System.out.println("Aurevoir");
                        return;
                    case 1:
                        displayAllPassports();
                        break;
                    case 2:
                        passportPeopleSameCity();
                        break;
                    case 3:
                        tallestPerson();
                        break;
                    case 4:
                        lightestPerson();
                        break;
                    case 5:
                        YoungestPerson();
                        break;
                    case 6:
                        AddPerson();
                        break;

                    default:
                        System.out.println("Internal fatal error. Terminating.");
                        System.exit(1);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private static void saveAllPassortsToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME));
            for (Passport a : passList) {
                pw.printf("%s;%s;%s;%s;%s;%f;%f;%d\n", a.getNumber(),
                        a.getFirstName(), a.getLastName(),
                        a.getAddress(), a.getCity(), a.getHeightCm(), a.getWeightKg(), a.getYob());
            }
            pw.close();
        } catch (IOException e) {
            System.err.println("Error saving to file");
            // FIXME close the file anyway
        }

    }

    private static void displayAllPassports() {
        for (int i = 0; i < passList.size(); i++) {
            Passport a = passList.get(i);
            System.out.printf("%s-%s-%s-%s-%s-%.2f-%.2f-%d\n", a.getNumber(),
                    a.getFirstName(), a.getLastName(),
                    a.getAddress(), a.getCity(), a.getHeightCm(), a.getWeightKg(), a.getYob());
        }
    }

    private static void passportPeopleSameCity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void tallestPerson() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void lightestPerson() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void YoungestPerson() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void AddPerson() {
        try {
            System.out.print("Enter number: ");
            String number = input.nextLine();
            System.out.print("Enter First name: ");
            String firstName = input.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = input.nextLine();
            System.out.print("Enter Address: ");
            String address = input.nextLine();
            System.out.print("Enter city: ");
            String city = input.nextLine();
            System.out.print("Enter height: ");
            double heightCm = input.nextDouble();
            System.out.print("Enter weight: ");
            double weightKg = input.nextDouble();
            System.out.print("Enter yob: ");
            int yob = input.nextInt();
            input.nextLine();

            Passport a = new Passport(number, firstName, lastName, address, city, heightCm, weightKg, yob);

            passList.add(a);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.err.println("Error creating airport: " + e.getMessage());
        }
    }

}
