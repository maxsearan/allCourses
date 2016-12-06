package quiz3moto;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Laurian Staicu 1696177
 * IPD 9 
 */
class InvalidInputDataException extends Exception {

    public InvalidInputDataException(String message) {
        super(message);
    }
}

class Transport {
// factory method

    static Transport createFromLine(String line) {
        System.out.println("Processing line: " + line);
        String[] data = line.split(";");
        String description ="";
        switch (data[0]) {
            case "Bicycle": {
                int wheelsCount = 0;
                int maxPassengers = 0;
                try {

                    wheelsCount = Integer.parseInt(data[2]);
                    maxPassengers = Integer.parseInt(data[3]);
                    if (!(data[0].matches("*w{2)*") && wheelsCount <= 100 && maxPassengers <= 1000)) {
                        throw new InvalidInputDataException("input out of range");
                    }

                    new Bicycle(data[1], wheelsCount, maxPassengers);
                } catch (InvalidInputDataException e) {
                    System.out.println(e.toString());
                }
            }

            break;

            case "Motorbike": {
                 int wheelsCount = 0;
                int maxPassengers = 0;
                double maxSpeed = 0;
                String plates="";
                description=data[0];
                try {
                    plates = data[2];
                    wheelsCount = Integer.parseInt(data[1]);
                    maxPassengers = Integer.parseInt(data[2]);
                    if (maxSpeed<=500&&()) {
                        throw new InvalidInputDataException("input out of range");
                    }

                    new Motorbike(double maxSpeed, String plates, String description, int wheelsCount, int maxPassengers);
                } catch (InvalidInputDataException e) {
                    System.out.println(e.toString());
                }
            }
            break;
            case "Car": {

            }
            break;
            case "Bus": {

            }
            break;

            default:
                System.out.println("Warning: invalid data in line " + line);
        }

        return null;

    }

}

class Bicycle extends Transport {
// add constructor with 3 parameters

    String description; // at least 2 characters long
    int wheelsCount; // 0-100
    int maxPassengers; // 0-1000

    public Bicycle(String description, int wheelsCount, int maxPassengers) {
        this.description = description;
        this.wheelsCount = wheelsCount;
        this.maxPassengers = maxPassengers;
    }

}

class Motorbike extends Bicycle {

    double maxSpeed; // 0-500
    String plates; // 3-10 characters

    public Motorbike(double maxSpeed, String plates, String description, int wheelsCount, int maxPassengers) {
        super(description, wheelsCount, maxPassengers);
        this.maxSpeed = maxSpeed;
        this.plates = plates;
    }

    
}
    /*
class Car extends Motorbike {
// add constructor with 5 parameters
public String toString() { ... }
}

class Bus extends Motorbike {
// add constructor with 5 parameters
public String toString() { ... }
}

     */
    public class Quiz3Moto {

        static ArrayList<Transport> transportList = new ArrayList<>();
        static final String FILE_NAME = "input.txt";
        static Scanner input = new Scanner(System.in);

        public static void main(String[] args) throws FileNotFoundException {
            //Reading from the file..
//---------------------------------------------
            File file = new File(FILE_NAME);
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNextLine()) {

                String line = fileInput.nextLine();
                transportList.add(new Transport());
                //System.out.println(line);
                //static Transport createFromLine(String line);

                fileInput.close();
//----------------------------------------------------------------------
            }

        }
    }
