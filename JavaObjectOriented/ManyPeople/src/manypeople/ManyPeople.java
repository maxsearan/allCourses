package manypeople;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* Laurian Staicu 1696177
 * IPD 9 
 */
 /*TASK - EXTEND ManyPeople

In the main directory of your project, using Notepad++
create file "people.txt" with the following contents:

Person;Jerry;23
Teacher;Randy;66;PhysEd;33
Person;Timmy;44
Student;Mary;34;Nursing;4.1
Student;Martin;31;Math;4.0
Teacher;Larry;51;Physics;22

In the main() method of your program
write code that will read this file line by line
and will instantiate the correct class
and add it to ArrayList

static ArrayList<Person> people = new ArrayList<>();

If you encounter a line that does not conform to requirements then warn user, ignore it and continue to next line.

Once all lines have been parsed and added to "people" ArrayList write a for loop that will display all data for each element of the list, for example:
Student Mary is 34 studying Nursing with GPA 4.1
Hint: use instanceof operator figure out the actual type of the object you're looking at
Give each of 3 classes a toString() method that returns string describing data in object instance.
Rewrite your for loop code to use polymorphism instead of instanceof. 
string split
switch


 */
class Person {

    /*Person;Timmy;44*/
 /*Person;Jerry;23*/
    private String name;
    private int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 1) {
            throw new IllegalArgumentException("Name must not be empty");
        }

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "toString() : Person " + name + " " + age;
    }
}

class Student extends Person {

    /*Student;Mary;34;Nursing;4.1
    Student;Martin;31;Math;4.0
     */
    private String program;
    private double GPA;

    public Student(String name, int age, String program, double GPA) {
        super(name, age);
        setProgram(program);
        setGPA(GPA);
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        if (program == null || program.length() < 1) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.program = program;

    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "toString() : Person " + super.getName() + " " + super.getAge() + " " + program + " " + GPA;
    }
}

class Teacher extends Person {

    /*Teacher;Randy;66;PhysEd;33
  Teacher;Larry;51;Physics;22
     */
    private String subject;
    private int yoe;

    public Teacher(String name, int age, String subject, int yoe) {
        super(name, age);
        setSubject(subject);
        setYoe(yoe);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.length() < 1) {
            throw new IllegalArgumentException("Name must not be empty");
        }

        this.subject = subject;
    }

    public int getYoe() {
        return yoe;
    }

    public void setYoe(int yoe) {
        this.yoe = yoe;
    }

    @Override
    public String toString() {
        //? update it to s 
        return "toString() : Teacher " + super.getName() + " " + super.getAge() + " " + subject + " " + yoe;
    }
}

public class ManyPeople {

    static final String FILE_NAME = "people.txt";

    static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File(FILE_NAME));

        while (fileInput.hasNextLine()) {
            String fileLine = null;
            try {
                fileLine = fileInput.nextLine();
                System.out.println(fileLine);
                String data[] = fileLine.split(";");
                createPeopleObjects(data, people);

            } catch (IllegalArgumentException e) {
                System.err.println("Skipping invalid input line: " + fileLine);
            }
        }

        fileInput.close();
        //Student Mary is 34 studying Nursing with GPA 4.1
        //Teacher Randy is 66 teaching PhysEd with 33 yoe
//? when i try to move it the for loop in function problem with Person
        for (int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            if (p instanceof Student) {
                Student s = (Student) p;
                System.out.printf("Student %s is %d studying %s with GPA %.1f %n", s.getName(), s.getAge(), s.getProgram(), s.getGPA());
                //System.out.println(p.toString());
            } else if (p instanceof Teacher) {
                Teacher t = (Teacher) p;
                System.out.printf("Teacher %s is %d teaching %s with %d yoe %n", p.getName(), p.getAge(), t.getSubject(), t.getYoe());
                //System.out.println(p.toString());
            } else if (p instanceof Person) {
                System.out.printf("Person %s is %d %n", p.getName(), p.getAge());
                //System.out.println(p.toString());
            } else {
                System.out.println("!-800-something went wrong");
            }
        }

        printToStringForEachObject(people);
        System.out.println("printing the reference to the object ");
        for (Person p :people){
            System.out.println(p);
        }
    }

    static private void createPeopleObjects(String[] data, ArrayList people) {
        switch (data[0]) {
            case "Person":
                people.add(new Person(data[1], Integer.parseInt(data[2])));

                break;
            case "Teacher":
                people.add(new Teacher(data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4])));
                break;
            case "Student":

                people.add(new Student(data[1], Integer.parseInt(data[2]), data[3], Double.parseDouble(data[4])));

                break;
            default:
                throw new IllegalArgumentException("Invalid type of person: " + data[0]);
        }
    }

    static private void printToStringForEachObject(ArrayList people) {
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).toString());

        }
    }

}
