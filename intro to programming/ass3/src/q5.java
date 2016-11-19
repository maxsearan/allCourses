
public class q5 {

    public static void main(String[] args) {

        System.out.println("\nBINGO GAME..");
        System.out.println("*************\n");

        int[][] bingoArray = new int[5][5];
        int random = 0;
        boolean vaidateNo = true;
        //Insert unique random number per column  
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                while (vaidateNo) {
                    random = (int) ((Math.random() + j) * 15 + 1);
                    vaidateNo = false;
                    for (int k = 0; k <= i; k++) {
                        if (random == bingoArray[k][j]) {
                            vaidateNo = true;
                        }
                    }
                }

                bingoArray[i][j] = random;
                vaidateNo = true;
            }
        }
        //Print the Bingo array
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + bingoArray[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");

    }

}
