
import java.util.*;
import java.io.*;

public class menunutrition {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nutritionList = 0;
        int selection = 0;
        boolean menu = true;
        String[] nutrition = new String[nutritionList];
        while (menu) {
            System.out.println("Choose an option:\n");
            System.out.println("*******************");
            System.out.println("1) Create you account.\n");
            System.out.println("2) your preferences.\n");
            System.out.println("3) nutrition list.\n");
            System.out.println("4) exit.\n");

            while ((selection < 1) || (selection > 4)) {
                System.out.println("Make your selection. Press 1,2,3,...");
                selection = input.nextInt();
            }
            switch (selection) {
                case 1:
                    account();
                    break;
                case 2:
                    System.out.println("sel2");
                    break;
                case 3:
                    System.out.println("sel3");
                    break;
                case 4:
                    System.out.println("exit");
                    menu = false;
                    break;
            }
            selection = 0;

        }
    }

    public static void account() {
        //create account
        int dataDimArray = 20;
        int selection = 0;
        String[] account = new String[dataDimArray];
        //Get data from consol
        Scanner input = new Scanner(System.in);

        //fro read and write to file
        File UserProfile = new File("profile.txt");
        //Create a file and write to it
        try {
            PrintWriter Larryfileoutput = new PrintWriter(UserProfile);
            Larryfileoutput.println("Gia");
            Larryfileoutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String reafromfile;
        //Read from file
        try {
            Scanner Larryfileinput = new Scanner(UserProfile);
            System.out.println("Read from file profile.txt entry: Gia:\n");
            reafromfile = Larryfileinput.next();
            System.out.println(reafromfile);
            Larryfileinput.close();
        } catch (Exception e) {
            e.printStackTrace();
            
        // Menu to create 
        }

        System.out.println("\nSelect: \n");

        System.out.println("1) Create account.\n");
        System.out.println("2) View your accoutn.\n");
        System.out.println("3) Update your account\n");

        switch (selection) {

            case 1:
                createAccount();
                break;
            case 2:
                viewAccount();
                break;
            case 3:
                updateAccount();
                break;

        }

    }

    public static void createAccount() {

    }

    public static void viewAccount() {

    }

    public static void updateAccount() {

    }

}
