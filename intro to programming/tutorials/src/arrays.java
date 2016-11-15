/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author JohnSmith
 */
public class arrays {

    public static void main(String[] args) {
        int[] values;

        int testplusandminus = 6;
        System.out.println(testplusandminus);
        testplusandminus++;
        System.out.println(testplusandminus);
        testplusandminus--;
        System.out.println(testplusandminus);

        values = new int[3];
        values[0] = 34;
        System.out.println(values[0]);

        for (int i = 2; 0 <= i; i--) {

            System.out.println(values[i]);

        }
        String[] words;
        words = new String[6];

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {

            System.out.println("Please enter a word: ");
            words[1] = input.nextLine();
            System.out.println("You entered the : " + (i + 1) + "th as " + words[1]);

        }
        for (int i = 0; i < 6; ++i) {
            System.out.print(words[i]);
        }
        System.out.println();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 89};
        for (int i=0;i<8;i++){
        System.out.println(
                 "element no "+ (i+1) + " value : "+nums[i] );
        }
        
        
    }

}
