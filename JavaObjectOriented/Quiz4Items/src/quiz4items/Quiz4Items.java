package quiz4items;

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
 /*abstract class Item {
String name;
double weight;
}

class TV extends Item {
double diagonal;
}

class Couch extends Item {
int seats;
}

class Bed extends Item {
double width, height;
}

Add convenient constructors to the classes above.
Do NOT add getters setters, do NOT verify values.

[1pt] Add appropriate toString() to all classes except Item.

input.txt file contents:

TV;Big black screen;10.5;60
TV;Mini;15.1;22
Couch;Blue seater;32.72;3
Couch;Mini;11.1;1;
Couch;Love seat;19.2;2
Bed;Master bedroom;28.11;182;234.5
Bed;Mini;13.5;72.2;165.5


In your main method you will:

1. [2pts] Read in contents of the file and add it to

static ArrayList<Item> itemList = new ArrayList<>();

Print them out in order they were read in.

2. [3pts] Add natural sorting order by using an appropriate
interface in Item class, so that items are sorted by name.

Print them out.

3. [2pts] Add another sorting order to sort items by weight.
Sort them and print them out.

4. [2pts] Modify the "natural order" sorting so that
if two items being compared have the same name then
they are ordered from lightest (smallest weight) to heaviest.
 */
abstract class Item implements Comparable<Item> {

    String name;
    double weight;

    @Override
    public int compareTo(Item o) {
        return this.name.toUpperCase().compareTo(o.name.toUpperCase());
    }

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
}

class TV extends Item {

    String type;
    double diagonal;

    public TV(String type, String name, double weight, double diagonal) {
        super(name, weight);
        this.diagonal = diagonal;
        this.type = type;
    }

    @Override
    public String toString() {
        return "TV{" + type + super.name + super.weight + "diagonal=" + diagonal + '}';
    }

}

class Couch extends Item {

    int seats;
    String type;

    public Couch(String type, String name, double weight, int seats) {
        super(name, weight);
        this.seats = seats;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Couch{" + "name" + super.name + "weight" + super.weight + "seats=" + seats + ", type=" + type + '}';
    }
}

class Bed extends Item {

    String type;
    double width, height;

    public Bed(String type, String name, double width, double height, double weight) {
        super(name, weight);
        this.type = type;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Bed{" + super.name + "weight" + "type=" + type + ", width=" + width + ", height=" + height + '}';
    }
}

class SortItemsByWeight implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        if (o1.weight > o2.weight) {
            return 1;
        } else if (o1.weight < o2.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}

class lastSort implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        if (o1.name.equals(o2.name)) {
            if (o1.weight > o2.weight) {
                return 1;
            }
        }
        return 0;
    }

}

public class Quiz4Items {

    static String FILE_NAME = "input.txt";
    static ArrayList<Item> itemList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(FILE_NAME);
        Scanner fileInput = new Scanner(file);
        System.out.println("\n1. Read in data from file \n");
        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();
            String data[] = line.split(";");
            System.out.println(line);
            switch (data[0]) {
                case "TV": {
                    itemList.add(new TV(data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3])));
                }
                break;
                case "Couch": {
                    itemList.add(new Couch(data[0], data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3])));
                }
                break;
                case "Bed": {
                    String type = data[0];
                    String name = data[1];
                    double width = Double.parseDouble(data[2]);
                    double height = Double.parseDouble(data[3]);
                    double weight = Double.parseDouble(data[4]);
                    itemList.add(new Bed(type, name, width, height, weight));
                }
                break;
                default:
                    System.out.println("Warning: invalid data in line " + line);
            }

        }
        for (Item item : itemList) {
            System.out.println(item);
        }
        System.out.println("\n");
        Collections.sort(itemList);
        for (Item item : itemList) {
            System.out.println(item);
        }
        Collections.sort(itemList, new SortItemsByWeight());
        Collections.sort(itemList);
        for (Item item : itemList) {
            System.out.println(item);
        }

        Collections.sort(itemList, new lastSort());
        Collections.sort(itemList);
        for (Item item : itemList) {
            System.out.println(item);
        }
    }

}
