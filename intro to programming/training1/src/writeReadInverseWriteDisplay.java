import java.util.*;
import java.io.*;
//writes and reads an array of integers to a file,
//and then displays the array to the screen.
public class writeReadInverseWriteDisplay {

    public static void main(String[] args) {
        File myfile = new File("test.txt");
        //loop write to file string array
        int [] name = new int[20];
        
        for(int i=0;i<20;i++){
            name[i]= i;
        }
        try {
            PrintWriter myfiletoprint = new PrintWriter(myfile);
            for (int i = 0; i < 10; i++) {
                myfiletoprint.println(name[i]);
            }
            myfiletoprint.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //loop read from file and loop display
        int i = 0;
        try {
            Scanner myfiletoread = new Scanner(myfile);
            while (myfiletoread.hasNext()) {
                name[i]=myfiletoread.nextInt();
                System.out.println(name[i]);
                i++;
            }
            myfiletoread.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
