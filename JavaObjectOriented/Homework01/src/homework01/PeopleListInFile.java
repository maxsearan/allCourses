package homework01;

import java.util.*;
import java.io.*;

public class PeopleListInFile {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        for (;;) {
            System.out.println("1. Add person info\n"
                    + "2. List persons info\n"
                    + "3. Find a person by name\n"
                    + "4. Find all persons younger than age\n"
                    + "0. Exit");

            int trychoice = 0;
            for (;;) {
                try {
                    System.out.println("Please enter choice 0;1;2;3;4;5.");
                    trychoice = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException ime) {
                    System.out.println("Please enter valid data");
                    input.nextLine();
                }

            }

            int choice = trychoice;
            if ((choice > 5) || (choice < 0)) {
                System.out.println("Make choice 0;1;2;3;4;5.");
                continue;
            }

            System.out.println("choice=" + choice);
            switch (choice) {
                case 1: {
                    addPerson1();
                    break;
                }
                case 2: {
                    listallPersons2();
                    break;
                }
                case 3: {
                    Enterpartialpersonname3();
                    break;
                }
                case 4: {
                    findAllPersonsYoungerThanAge4();
                    break;
                }
                case 0: {
                    exit();
                    return;
                }
                default: {
                    System.err.println("Fatal error: invalid control flow");
                    System.exit(1);
                }
            }

        }
    }

    static void addPerson1() throws IOException {
        /*Adding a person.
Enter name: Jerry
Enter age: 22
Enter city: Montreal
Person added.*/
        Scanner input = new Scanner(System.in);
        System.out.println("Adding a person.");
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter age:");
        String age = stringAge();

        System.out.println("Enter city:");
        String city = input.nextLine();
        try {

            File file = new File("people.txt");

            //if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            //true = append file
            FileWriter fileWritter = new FileWriter(file.getName(), true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(name);
            bufferWritter.newLine();
            bufferWritter.write(age);
            bufferWritter.newLine();
            bufferWritter.write(city);
            bufferWritter.newLine();
            bufferWritter.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void listallPersons2() {
        /*Listing all persons
Jerry is 22 from Montreal
Maria is 26 from Toronto*/
        System.out.println("Listing all persons");
        File myFile = new File("people.txt"); // path
        Scanner input = new Scanner(System.in);
        String[] entry = new String[3];
        try {
            Scanner fileinput = new Scanner(myFile); //object 

            while (fileinput.hasNext()) {
                for (int i = 0; i < 3; i++) {
                    entry[i] = fileinput.nextLine();

                }
                System.out.println(entry[0] + " is " + entry[1] + " from " + entry[2]);
            }
            System.out.println("\n\n");
            fileinput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void Enterpartialpersonname3() {
        /*Enter partial person name:
ri
Matches found:
Maria is 26 from Toronto*/
        System.out.println("Enter partial person name:");

        Scanner input = new Scanner(System.in);
        String parName = input.nextLine();
        File myFile = new File("people.txt"); // path
        String[] entry = new String[3];
        try {
            Scanner fileinput = new Scanner(myFile); //object 

            while (fileinput.hasNext()) {
                for (int i = 0; i < 3; i++) {
                    entry[i] = fileinput.nextLine();

                }
                if (entry[0].matches(".*" + parName + ".*")) {
                    //return index of the match;
                    System.out.println(entry[0] + " is " + entry[1] + " from " + entry[2]);
                }
            }
            System.out.println("\n\n");
            fileinput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void findAllPersonsYoungerThanAge4() {
        /*Enter maximum age:
25
Matches found:
Jerry is 22 from Montreal*/

        System.out.println("Enter maximum age:");

        File myFile = new File("people.txt"); // path
        Scanner input = new Scanner(System.in);
        
        
        
        int trychoice ;
            for (;;) {
                try {
                    trychoice = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException ime) {
                    System.out.println("Please enter valid age");
                    input.nextLine();
                }

            }
        
        int minAge = trychoice;
        String[] entry = new String[3];
        try {
            Scanner fileinput = new Scanner(myFile); //object 

            while (fileinput.hasNext()) {
                for (int i = 0; i < 3; i++) {
                    entry[i] = fileinput.nextLine();

                }
                if (Integer.valueOf(entry[1]) <= minAge) {
                    System.out.println(entry[0] + " is " + entry[1] + " from " + entry[2]);
                }
            }
            System.out.println("\n\n");
            fileinput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void exit() {
        System.out.println("Good bye!");

    }

    static String stringAge() {
        Scanner input = new Scanner(System.in);

        String age;
        int ageInt;
        for (;;) {
            try {

                ageInt = input.nextInt();
                age = Integer.toString(ageInt);
                input.nextLine(); // consume left-over new line character
                break;

            } catch (InputMismatchException ime) {
                input.nextLine(); // consume the invalid input
                System.out.println("Invalid input, try again");
            }

        }
        return age;
    }
}
