/*
 TASK 1

Create project FileSaveRead.

1. Ask user for one line of text input.

2. Open file 'data.txt' in current directory
for writing and write the line of text
user provided.
3. Close the file

4. Open file 'data.txt' one more time for reading, read one line of text from it,
display it back on the console.
5. Close the file.
 */
package filesaveread;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JohnSmith
 */
public class FileSaveRead {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        File file = new File("data.tx");
        try {
            PrintWriter printToFile = new PrintWriter(file);
            String  lineToFile;
            System.out.println("Enter line to write on file:");
            lineToFile = input.nextLine();
            printToFile.println(lineToFile);
            printToFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSaveRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Scanner fileinput = new Scanner(file);
            String  linefromFile;
            linefromFile = fileinput.nextLine();
            System.out.println(linefromFile);
            fileinput.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSaveRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
