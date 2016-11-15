
public class Exercise22 {

    public static void main(String[] args) {
        int[] array1 = {2, 7, 4, -5, 11, 5, 20};

        int[] array2 = {14, -15, 9, 16, 25, 45, 12, 8};
        int dim1 = array1.length;
        int dim2 = array2.length;
        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                if ((array1[i] + array2[j]) == 20) {
                    System.out.println("array1["+i+"] + array2["+j+"] = "+(array1[i] + array2[j]));
                }
            }
        }

    }
}
