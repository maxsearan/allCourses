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

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        for (;;) {
            System.out.println("1. Add person info\n"
                    + "2. List persons info\n"
                    + "3. Find a person by name\n"
                    + "4. Find all persons younger than age\n"
                    + "0. Exit");
            int choice = input.nextInt();
            if((choice>5)||(choice<0)){
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

    static void addPerson1() {
/*Adding a person.
Enter name: Jerry
Enter age: 22
Enter city: Montreal
Person added.*/
        System.out.println("Adding a person.");
        
        System.out.println("Enter name:");
        String name = input.nextLine();
        input.nextLine();  
        
        System.out.println("Enter age:");
        int age = input.nextInt();
        input.nextLine();  
        
        System.out.println("Enter city:");
        String city = input.nextLine();
        input.nextLine();  
        
        File filelocation = new File("people.txt");
        
        try {
            PrintWriter file = new PrintWriter(filelocation);
            file.println(name);
            file.println(age);
            file.println(city);
            file.println();
            file.close();
        } catch (Exception e) {
        }
          
            
        
    }

    
    static void listallPersons2() {
/*Listing all persons
Jerry is 22 from Montreal
Maria is 26 from Toronto*/
        System.out.println("Listing all persons");

    }

    static void Enterpartialpersonname3() {
/*Enter partial person name:
ri
Matches found:
Maria is 26 from Toronto*/
        System.out.println("Enter partial person name:");

    }

    static void findAllPersonsYoungerThanAge4() {
/*Enter maximum age:
25
Matches found:
Jerry is 22 from Montreal*/
        System.out.println("Enter maximum age:");

    }

    static void exit() {
        System.out.println("Good bye!");

    }
}
