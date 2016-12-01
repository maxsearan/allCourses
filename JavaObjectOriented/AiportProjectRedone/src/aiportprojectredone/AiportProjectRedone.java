package aiportprojectredone;

/* Laurian Staicu 1696177
 * IPD 9 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Airport {

    private String code;
    private String city;
    private double latitude;
    private double longitude;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if(code.equals("YUL")){
            throw new IllegalArgumentException("Cannot enter "+code);
        }
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    private Exception IllegalArgumentException(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

public class AiportProjectRedone {
    static ArrayList<Airport> airportList = new ArrayList<>();

    static final String FILE_NAME = "airports.txt";

    public static void main(String[] args) {
                Scanner fileInput = new Scanner(new File(FILE_NAME));
while (fileInput.hasNextLine()) {
            String fileLine = fileInput.nextLine();
            /* VERSION 1
            Scanner lineInput = new Scanner(fileLine).useDelimiter(";");
            String code = lineInput.next();
            String city = lineInput.next();
            double lat = lineInput.nextDouble();
            double lgt = lineInput.nextDouble();
             */
            String data[] = fileLine.split(";");
            if (data.length != 4) {
                throw new IllegalArgumentException("Line malformed: " + fileLine);
            }
            String code = data[0];
            String city = data[1];
            double lat = Double.parseDouble(data[2]);
            double lgt = Double.parseDouble(data[3]);
            airportList.add(new Airport(code, city, lat, lgt));
        }
        fileInput.close();
    }
        
        
         
    }

}
