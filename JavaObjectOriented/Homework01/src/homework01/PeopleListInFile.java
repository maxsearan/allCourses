/*
 HOMEWORK - day 2

Create project PeopleListInFile

You will display a menu to the user:
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit

You will implement functions to manage contents of file "people.txt".

Example session

What do you want to do?
1. Add person info
2. List persons info
3. Find and list a person by name
4. Find and list persons younger than age
0. Exit
Choice: 1

Adding a person.
Enter name: Jerry
Enter age: 22
Enter city: Montreal
Person added.

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 1

Adding a person.
Enter name: Maria
Enter age: 26
Enter city: Toronto
Person added.

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 2

Listing all persons
Jerry is 22 from Montreal
Maria is 26 from Toronto

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 3

Enter partial person name:
ri
Matches found:
Maria is 26 from Toronto

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 4

Enter maximum age:
25
Matches found:
Jerry is 22 from Montreal

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 0

Good bye!



Result data file will have the following contents.
Jerry
22
Montreal
Maria
26
Toronto


NOTE: If you run your program again you will operate
on data you already have, example:

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 2

Listing all persons
Jerry is 22 from Montreal
Maria is 26 from Toronto


NOTE: You do NOT need to and are not allowed to
store data in memory in array or ArrayList.
You must read file every time.

 */
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
            int choice = input.nextInt();
            if ((choice > 5) || (choice < 0)) {
                System.out.println("Please enter a valid choice.");
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
        String age ;
        for (;;) {
            try {
                System.out.println("Enter age:");
                int ageInt = input.nextInt();
                age = Integer.toString(ageInt);
                input.nextLine(); // consume left-over new line character
                break;
            } catch (InputMismatchException ime) {
                input.nextLine(); // consume the invalid input
                System.out.println("Invalid input, try again");
            }
        }

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
        int minAge = input.nextInt();
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
}
