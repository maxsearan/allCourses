package people1;

import java.util.ArrayList;

class Person {

    Person(String n, int a) {
        name = n;
        age = a;
    }
    String name;
    int age;
}

public class People1 {

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Jerry", 33));
        people.add(new Person("Maria", 44));
        people.add(new Person("Tommy", 55));

        /*Person p = new Person("Jerry",33);
        
        System.out.printf("p: name=%s, age=%d\n",p.name,p.age);
        
        Person p1 = new Person("Maria",23);
        
        System.out.printf("p: name=%s, age=%d\n",p1.name,p1.age);*/
        System.out.printf("p[0]: name=%s, age=%d\n", people.get(0).name,
                people.get(0).age);

        for (int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            System.out.printf("p[0]: name=%s, age=%d\n", p.name,
                    p.age);
        }
         

    }

}
