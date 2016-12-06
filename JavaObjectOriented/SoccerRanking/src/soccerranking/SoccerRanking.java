package soccerranking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/* Laurian Staicu 1696177
 * IPD 9 
 */
class Team implements Comparable<Team> {

    String title;
    int matchesWon;
    int matchesLost;

    public Team(String title, int matchesWon, int matchesLost) {
        this.title = title;
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
    }

    @Override
    public String toString() {
        return "Team{" + "title=" + title + ", matchesWon=" + matchesWon + ", matchesLost=" + matchesLost + '}';
    }

    @Override
    public int compareTo(Team o) {
        System.out.printf("compare the object %s to the object %s passed as an argument", this, o);
        if (this.matchesWon == o.matchesWon) {
            return 0;

        }
        if (this.matchesWon > o.matchesWon) {
            return 1;
        } else {
            return -1;
        }

    }
}

class SortTeamsByName implements Comparator<Team> {

    @Override
    public int compare(Team o1, Team o2) {
        return o1.title.compareTo(o2.title);
    }
}

class SortByPercentageGamesWon implements Comparator<Team> {

    @Override
    public int compare(Team o2, Team o1) {
        double perc1;
        double perc2;
        perc1 = (double)o1.matchesWon/(o1.matchesWon+o1.matchesLost);
                perc2 = (double)o2.matchesWon/(o2.matchesWon+o2.matchesLost);
        if (perc1-perc2==0){
            return 0;
        }else if (perc1-perc2>=0){
            return 1;
        }else {
            return -1;
        }

    }
}

public class SoccerRanking {

    static ArrayList<Team> teamList = new ArrayList<>();

    static final String FILE_NAME = "input.txt";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner fileInput = new Scanner(new File(FILE_NAME));
        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();
            System.out.println("Processing line: " + line);
            String[] data = line.split(";");
            String name = data[0];
            int matchesWon = Integer.parseInt(data[1]);
            int matchesLost = Integer.parseInt(data[2]);
            Team team = new Team(name, matchesWon, matchesLost);
            teamList.add(team);
        }

        //print list
        for (Team team : teamList) {
            System.out.println(team.toString());
        }
        System.out.println("\n");
        Collections.sort(teamList, new SortTeamsByName());
        for (Team team : teamList) {
            System.out.println(team.toString());
        }
        
        System.out.println("\n");
        Collections.sort(teamList, new SortByPercentageGamesWon());
        for (Team team : teamList) {
            System.out.println(team.toString());
        }
    }
    
}
// Collections.sort(teamList);

