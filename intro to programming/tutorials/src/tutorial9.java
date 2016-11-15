/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/*
 *
 * @author JohnSmith
 */
public class tutorial9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        name = scanner.nextLine();
        switch (name){
            case("tati"):
            System.out.println("you selected tati");
            break;
            
            case ("gia"):
                System.out.println("you selected gia");
                break;
                default:
                    System.out.println("you selected something "
                            + ", bye for now.");
                 
        }
        
        
        
    };
    
}
