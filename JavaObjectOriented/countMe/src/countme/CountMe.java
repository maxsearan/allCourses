package countme;


/* Laurian Staicu
    TASK: implement method
    public int getUniqueId() {}
    that will return a unique, consecutive ID number for every box created
    IOW. 1st box will have ID=1, 2nd ID=2, and so on.
    Note: You must NOT add parameters to constructor
 */
class Box {

    private static int count;
    private int uniqueID;

    Box() {
        count++;
        uniqueID = count;
    }
    int value;

    public int getCount() {
        return count;
    }

    public int getUniqueId() {
        return uniqueID;
    }
}

public class CountMe {

    public static void main(String[] args) {

        System.out.println(new Box().getUniqueId());
        System.out.println(new Box().getUniqueId());
        System.out.println(new Box().getUniqueId());
        System.out.println(new Box().getUniqueId());
        System.out.println(new Box().getUniqueId());

    }

}
