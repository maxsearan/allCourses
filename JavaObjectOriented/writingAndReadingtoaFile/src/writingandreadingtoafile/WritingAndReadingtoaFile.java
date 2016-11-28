package writingandreadingtoafile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* Laurian Staicu 1696177
 * IPD 9 
 */
public class WritingAndReadingtoaFile {

    public static void main(String[] args) {
        File file = new File("test.txt");

        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            br.write("This is line one");
            br.newLine();
            br.write("This is line two");
            br.newLine();
            br.write("Last line");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.toString());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to read file" + file.toString());
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
         String line;   
	while((line = br.readLine()) != null) 
        { //reads line until empty
		System.out.println(line);
	}

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.toString());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to read file" + file.toString());
            e.printStackTrace();
        }

    }

}
