/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplefromfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class people{
    
    people(String n, int a) {
        name = n;
        age = a;
    }
    String name;
    int age;
    
}
public class PeopleFromFile {
    
   static ArrayList<people> people = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
      
       try{ 
        File file = new File("people.txt");
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
            
        System.out.println(input.nextLine());
        String name = input.nextLine();
        int age = input.nextInt();
        input.nextLine();
        
        people p = new people(name,age);
        people.add(p);
        }
         
       }catch (IOException e) {
           System.err.println("Error reading file");
       }
        
    }
    
}
