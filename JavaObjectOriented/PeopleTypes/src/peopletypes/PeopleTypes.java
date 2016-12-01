package peopletypes;

/* Laurian Staicu 1696177
 * IPD 9 
 */
class Person{
    private String name = "joe";
    private int age =21;

    public Person() {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
class Student extends Person{
private String program;
private int GPA;


    public Student() {
                super();
                setProgram(program);
                setGPA(GPA);
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

}

class Teacher {
    private String subject ;
    private int joe;

    public Teacher(String subject, int joe) {
        
        this.subject = subject;
        this.joe = joe;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getJoe() {
        return joe;
    }

    public void setJoe(int joe) {
        this.joe = joe;
    }
}
public class PeopleTypes  {

      

    public static void main(String[] args) {
        
        Person p = new Person();
        p.setName("jimmy");
        
        
    }

}
