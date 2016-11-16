public class oneDimRandomArray {

    public static void main(String[] args) {
        /*Array has 10 elements initilized 
        with random numbers 1 to 20
        then print the array.
        */
        
        int [] array = new int[10];
        for (int i=0;i<10;i++){
            array[i]=(int)(Math.random()*20+1);

        }
        /*print the array elements on a sigle line*/
        for(int i=0;i<10;i++){
           System.out.print(" "+array[i]+" ");
        }
        
        
    }
    
}
