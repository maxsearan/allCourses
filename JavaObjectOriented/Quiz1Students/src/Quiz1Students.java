//Laurian Staicu  1696177

import java.util.*;
import java.io.*;

public class Quiz1Students {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        for (;;) {
            System.out.println("1. Add student and their GPA\n"
                    + "2. List all students and their GPAs\n"
                    + "3. Find all students whose name begins with a letter\n"
                    + "4. Find the average GPA of all students and display it.\n"
                    + "0. Exit");

            int trychoice = 0;
            for (;;) {
                try {
                    System.out.println("Please enter choice 0;1;2;3;4");
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
                    addStudent1();
                    break;
                }
                case 2: {
                    listallStudents2();
                    break;
                }
                case 3: {
                    searchByFirstLetter();
                    break;
                }
                case 4: {
                    averageGpa();
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

    static void addStudent1() throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Adding a student.");
        System.out.print("Enter student's name: ");

        String name = input.nextLine();
        System.out.print("Enter student's GPA: ");
        String gpa = stringGpa();
        System.out.println();

        try {

            File file = new File("students.txt");

            //if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            //true = append file
            FileWriter fileWritter = new FileWriter(file.getName(), true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(name);
            bufferWritter.newLine();
            bufferWritter.write(gpa);
            bufferWritter.newLine();
            bufferWritter.close();

            System.out.println("Student added.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void listallStudents2() {

        System.out.println("Listing all students");
        File myFile = new File("students.txt"); // path
        Scanner input = new Scanner(System.in);
        String name;
        String gpa;
        double doubleGpa;
        try {
            Scanner fileinput = new Scanner(myFile); //object 

            while (fileinput.hasNext()) {
                name = fileinput.nextLine();
                gpa = fileinput.nextLine();
                System.out.printf(name + " has GPA: %.1f", Double.valueOf(gpa));
                System.out.println("");
            }
            System.out.println("\n\n");
            fileinput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void searchByFirstLetter() {

        System.out.println("Enter first letter of student name (only one letter):");

        Scanner input = new Scanner(System.in);

        String parName;
        for (;;) {
            parName = input.nextLine();
            int length = parName.length();
            System.out.println("you have entered " + length + " letters");
            if (length == 1) {
                break;
            } else {
                System.out.println("Please enter 1 charater.");
            }
        }

        File myFile = new File("students.txt"); // path
        String name, gpa;

        try {
            Scanner fileinput = new Scanner(myFile); //object 

            while (fileinput.hasNext()) {
                name = fileinput.nextLine();
                gpa = fileinput.nextLine();
                if (name.toUpperCase().matches(parName.toUpperCase() + ".*")) {
                    //return index of the match;
                    System.out.printf(name + " has GPA %10.1f %n", Double.valueOf(gpa));

                }
            }
            System.out.println("\n\n");
            fileinput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void averageGpa() {

        System.out.print("The average GPA of all students is ");
        File myFile = new File("students.txt"); // path
        Scanner input = new Scanner(System.in);
        String name;
        double totalGpa = 0;
        double avGpa;
        int numberOfStudent = 0;
        try {
            Scanner fileinput = new Scanner(myFile); //object 
            while (fileinput.hasNext()) {
                name = fileinput.nextLine();
                totalGpa = totalGpa + fileinput.nextDouble();
                numberOfStudent++;
                fileinput.nextLine();
            }
            fileinput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        avGpa = totalGpa / (double) numberOfStudent;
        System.out.printf("%.1f", avGpa);
        System.out.println("\n");

        System.out.println("If you would like to save it to a "
                + "file, provide file name (empty to skip):");
        String filename;
        filename = input.nextLine();
        if (filename.isEmpty()) {
        } else {
            File myFile1 = new File(filename);
            try {
                PrintWriter fileoutput = new PrintWriter(myFile1);
                fileoutput.printf("%.2f",totalGpa / (double) numberOfStudent);
                fileoutput.close();
                System.out.printf("Contents of %s file will be: %4.1f %n",filename, avGpa);
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    static void exit() {
        System.out.println("Good bye!");

    }

    static String stringGpa() {
        Scanner input = new Scanner(System.in);
        String gpa;
        double gpaDouble;
        for (;;) {
            try {

                for (;;) {
                    gpaDouble = input.nextDouble();
                    if ((gpaDouble >= 0) && (gpaDouble <= 4.3)) {
                        break;
                    }
                    System.out.println("GPA must be between 0 and 4.3 maximum.");
                    System.out.print("Enter student's GPA: ");

                }
                gpa = Double.toString(gpaDouble);
                input.nextLine(); // consume left-over new line character
                break;
            } catch (InputMismatchException ime) {
                input.nextLine(); // consume the invalid input
                System.out.println("Invalid input, try again");
            }
        }
        return gpa;
    }
}
