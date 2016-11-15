/*The program should perform a maximum of 6 tosses. For every toss, print the following:
Dice 1: 3 Dice2: 5 Sum: 8
If the sum of the Dice is 7, then you must print “You are a winner …”.
As soon as a sum of 7 is encountered you must stop tossing the dice. 
If not sum is equal to 7 and you reach the max number of tosses (6) then you must print:
“Better luck next time! Play again”*/

public class q2 {

    public static void main(String[] args) {
        int dice1, dice2, maxNumTosses, winner;

        maxNumTosses = 1;

        do {
            dice1 = (int) (Math.random() * 6+1);
            dice2 = (int) (Math.random() * 6+1);
            winner = dice1 + dice2;
            System.out.println(" Dice 1 :" + dice1 + " Dice 2 :" + dice2 + " Sum: " + winner);
            maxNumTosses++;

        } while ((maxNumTosses < 7) && (winner != 7));
        if (winner == 7) {
            System.out.println("You are a winner …");
        } else {
            System.out.println("Better luck next time! Play again");
        }

    }

}
