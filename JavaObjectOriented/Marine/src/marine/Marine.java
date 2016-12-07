package marine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/* Laurian Staicu 1696177
 * IPD 9 
 */
 /*class Boat {
	String name;
	double grossWeight;
	double length;
	int masts;
}

Define:
- constructor
- toString appropriate to the rest of the task
- NO getters or setters, or input verification

Read data from file, assume data is all valid:

Ocean Breeze III;2373.5;11.3;2
Magic Beyond;4532.1;27.2;3
Adventurer 2;789.5;7.3;1


(add at least 4 more, so you have 7 lines at least)

Read all data into 

static ArrayList<Boat> boatList = new ArrayList<>();

In your main program:

1. Read in data from file
2. Print all data in natural order by name
3. Print all data in order by length
4. Print all data in order by masts
5. Print all data in order by masts and grossWeight

Use Comparable interface for natural order,
and for other sorts use one Comparator class for each.*/
abstract class MarineVehicles {

    String type;
static int index;
int ID;
    abstract public String typeOfBoat();
    abstract public void uniqueIDPrint();
    

}

class Boat extends MarineVehicles implements Comparable<Boat> {

    String name;
    double grossWeight;
    double length;
    int masts;

    public Boat(String name, double grossWeight, double length, int masts, String type) {
        super.type = type;
        this.name = name;
        this.grossWeight = grossWeight;
        this.length = length;
        this.masts = masts;
        super.index++;
        super.ID=super.index;

    }

    @Override
    public String toString() {
        return "Boat{" + "name=" + name + ", grossWeight=" + grossWeight + ", length=" + length + ", masts=" + masts + '}';
    }

    @Override
    public int compareTo(Boat o) {
        return -this.name.toUpperCase().compareTo(o.name.toUpperCase());
    }

    @Override
    public String typeOfBoat() {
        return super.type;
    }

    @Override
    public void uniqueIDPrint() {
            System.out.println(super.ID);
        }

}
//3. Print all data in order by length

class OrderByLenght implements Comparator<Boat> {

    @Override
    public int compare(Boat o1, Boat o2) {
        if (o1.length > o2.length) {
            return 1;
        } else if (o1.length < o2.length) {
            return -1;
        } else {
            return 0;
        }
    }

}
//4. Print all data in order by masts

class OrderByMasts implements Comparator<Boat> {

    @Override
    public int compare(Boat o1, Boat o2) {
        if (o1.masts > o2.masts) {
            return 1;
        } else if (o1.masts < o2.masts) {
            return -1;
        } else {
            return 0;
        }
    }

}

//5. Print all data in order by masts and grossWeight
class OrderByMatsAndGrossWeight implements Comparator<Boat> {

    @Override
    public int compare(Boat o1, Boat o2) {
        if (o1.masts > o2.masts) {
            return 1;
        } else if (o1.masts < o2.masts) {
            return -1;
        } else {
            if (o1.grossWeight > o2.grossWeight) {
                return 1;
            } else if (o1.grossWeight < o2.grossWeight) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}

public class Marine {

    static String FILE_NAME = "input.txt";
    static ArrayList<Boat> boatList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(FILE_NAME);
        Scanner fileInput = new Scanner(file);
        System.out.println("\n1. Read in data from file \n");
        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();
            String data[] = line.split(";");
            String name = data[0];
            double grossWeight = Double.parseDouble(data[1]);
            double length = Double.parseDouble(data[2]);
            int masts = Integer.parseInt(data[3]);
            String type = data[4];
            Boat boat = new Boat(name, grossWeight, length, masts, type);
            System.out.println(boat);
            boatList.add(boat);

        }
        System.out.println("\n2. Print all data in natural order by name");
        Collections.sort(boatList);
        for (Boat boat : boatList) {
            System.out.println(boat);
        }
        System.out.println("\n");
        for (Boat boat : boatList) {
            System.out.println((MarineVehicles) boat);

        }
        System.out.println("\n3. Print all data in order by length\n");
        for (Boat boat : boatList) {
            System.out.println(boat);

        }
        System.out.println("\n4. Print all data in order by masts\n");
        boatList.forEach((boat) -> {
            System.out.println(boat);
        });
        System.out.println("\n5. Print all data in order by masts and grossWeight\n");
        boatList.forEach((boat) -> {
            System.out.println(boat);
        });
        System.out.println("\n");
        for (int i = 0; i < boatList.size(); i++) {
            System.out.printf("type of boat %s ", boatList.get(i).typeOfBoat());
           Boat boat = boatList.get(i);
           boat.uniqueIDPrint();

        }
    }

}
