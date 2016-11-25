package demandingpeople;


class Person {

    Person(String n, int a) {
        setName(n);
        setAge(a);
    }
    private String name;
    private int age;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if(name.isEmpty()||name==null){
            throw new IllegalArgumentException("name must not be null or empty");
        }
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        if(age<1||age >150){
            throw new IllegalArgumentException("Age must be between 1 and 150");
        }
        this.age = age;
    }
}

public class Demandingpeople {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Person p = new Person("Jerry", -33);
        //p.setAge(101);
        //p.setName("Jerry P");
        System.out.printf("p: name=%s, age=%d/n", p.getName(), p.getAge());
        }
        catch (IllegalArgumentException ipe){
            System.err.println("Invalid operation "+ipe.getMessage());
        }
        
    }

}
