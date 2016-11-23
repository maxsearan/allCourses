/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training01;

import java.util.Random;

/**
 *
 * @author JohnSmith
 */
public class arrayofintegers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic herefor
        int[][] intArray = new int[20][5];
        int[][] intArray2 = new int[20][5];

        Random r = new Random();

        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[0].length; j++) {
                intArray[i][j] = r.nextInt(100) + 1;
                System.out.printf("%5d", intArray[i][j]);
            }
            System.out.println("\n");
        }   
        for (int i = 0; i < intArray2.length; i++) {
            for (int j = 0; j < intArray2[0].length; j++) {
                intArray2[i][j] = r.nextInt(100) + 1;
                System.out.printf("%5d", intArray2[i][j]);
            }
            System.out.println("\n");
        }
        for (int i = 0; i < intArray2.length; i++) {
            for (int j = 0; j < intArray2[0].length; j++) {
                if (intArray[i][j] > intArray2[i][j]) {
                    System.out.println(" bigger");
                } else if (intArray[i][j] < intArray2[i][j]) {
                    System.out.println(" smaller ");

                } else {
                    System.out.println(" equals ");
                    return;
                }
                //System.out.println(" ");
            }
            System.out.println("\n");
        }
        Random rn = new Random();
        int randomNum = rn.nextInt(500000) + 1;
        System.out.println(randomNum);

    }

    static void badwords() {
        System.out.println("va chier!");
    }
}
