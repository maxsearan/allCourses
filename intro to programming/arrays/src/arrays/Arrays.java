/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author JohnSmith
 */
public class Arrays {

    public static void main(String[] args) {
        int largest;
        int smallest;
        int[] array = new int[50];
        for (int i = 0; i < 50; i++) {
            //System.out.println(array[i]);
        }
        System.out.println();

        for (int i = 0; i < 50; i++) {
            array[i] = (int) (Math.random() * 50 + 1);
            //System.out.println(array[i]);
        }
        largest = array[0];
        smallest = array[0];
        for (int i = 0; i < 50; i++) {
            if (largest < array[i]) {
                largest = array[i];
            }
            if (smallest > array[i]) {
                smallest = array[i];
            }
        }

        System.out.println("largest number is: " + largest);
        System.out.println("smallest number is: "+ smallest);

    }

}
