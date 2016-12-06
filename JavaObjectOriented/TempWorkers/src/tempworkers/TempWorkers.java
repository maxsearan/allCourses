package tempworkers;

/* Laurian Staicu 1696177
 * IPD 9 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*TASK 1

Create project TempWorkers

class Worker {	
	String name;
	Date startDate;
	Date endDate;
	int getId(); // returns unique consecutive Id
}

You will modify Worker class:
- add constructor with 3 parameters
- using static implement getId() method
- encapsulate fields and verify in setters that:
a) name is not empty
b) start date is not after end date
In case of violation of requirements throw
a checked exception InvalidDataProvidedException()

input.txt file contents

Jerry;2016/02/15;2016/04/15
Macy;2016/03/22;2016/05/28
Timmy;2016/06/08;2016/07/10
Manny;2016/08/01;2016/12/10

You will read in data line by line, instantiate objects type Worker() and add them to

static ArrayList<Worker> personel = new ArrayList<>();

You will implement the following menu interactions:

1. List all personel
2. Find out who works on a specific date
3. Ask for a year number and print out all dates
in that year that nobody is scheduled to work on
4. Add worker
5. Delete worker by Id
0. Exit

Output of option 1. List all personel

1: Jerry works from 15 Feb 2016 to 15 April 2016
2: Macy works from March 22, 2016 to 28 May 2016
... and so on...

On exit you save data back to the file.

BONUS***:
In 3. instead of showing all dates when nobody works
display RANGES from-to date when nobody works.*/
//unchecked runtime 
//checked I/O
final class Worker {

    private String name;
    private Date startDate;
    private Date endDate;
    private static int count;
    private int uniqueID;

    public void setupID() {
        count++;
        uniqueID = count;
    }

    public int getUniqueId() {
        return uniqueID;
    }

    public Worker(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        setupID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws invalideName {
        if (name == "" || name == null) {
            throw new invalideName("name must not be null or empty");
        }
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) throws startDate {
        if (!startDate.before(getEndDate())) {
            throw new startDate("start date before enddate");
        }
        this.startDate = startDate;

    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) throws InvalidDataProvidedException {
        if (startDate.after(getEndDate())) {
            throw new InvalidDataProvidedException("start date is not after end date");
        }
        this.endDate = endDate;
    }

    private static class invalideName extends Exception {

        public invalideName(String name_must_not_be_null_or_empty) {
            super();
        }
    }

    private static class startDate extends Exception {

        private String s;

        public startDate(String start_date_after_enddate) {
            super();
        }

        @Override
        public String toString() {
            return s;
        }
    }

    private static class InvalidDataProvidedException extends Exception {

        private String s;

        public InvalidDataProvidedException(String start_date_is_not_after_end_date) {
            super();
        }

        @Override
        public String toString() {
            return s;
        }
    }

}

public class TempWorkers {
//General settings

    static ArrayList<Worker> personel = new ArrayList<>();
    static final String FILE_NAME = "input.txt";
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
//Reading from the file..
//---------------------------------------------
        File file = new File(FILE_NAME);
        Scanner fileInput = new Scanner(file);
        while (fileInput.hasNextLine()) {

            String line = fileInput.nextLine();
            //System.out.println(line);
            try {
                //splitting the line by ";" into an array

                String data[] = line.split(";");
                if (data.length != 3) {
                    throw new InvalidDataProvidedException("Line malformed" + line);
                }
                //Assigning data form line to elements of array
                String name = data[0];
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                Date startDate = formatter.parse(data[1]);
                Date endDate = formatter.parse(data[2]);

                if (startDate.after(endDate)) {
                    throw new InvalidDataProvidedException("Start date after end date " + line);
                }
                Worker worker = new Worker(name, startDate, endDate);
                personel.add(worker);

            } catch (InvalidDataProvidedException ex) {
                System.err.println("Invalid Data " + line);
            } catch (ParseException ex) {
                System.err.println("Date from file is not valid");
            }
        }
        fileInput.close();
//----------------------------------------------------------------------

        //Menu   
        //---------------------------------------------
        for (;;) {
            System.out.println("1. List all personel\n"
                    + "2. Find out who works on a specific date\n"
                    + "3. Ask for a year number and print out all dates\n"
                    + "in that year that nobody is scheduled to work on\n"
                    + "4. Add worker\n"
                    + "5. Delete worker by Id\n"
                    + "0. Exit");
            int choice = 0;
            for (;;) {
                try {
                    System.out.println("Please enter choice 0;1;2;3;4");
                    choice = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException ime) {
                    System.out.println("Please enter valid data");
                    input.nextLine();
                }
            }
            switch (choice) {
                case 1: {
                    listAllPersonel1();
                    break;
                }

                case 2: {
                    workOnSpecificDay2();

                    break;
                }
                case 3: {
                    yearPrint3();
                    break;
                }
                case 4: {
                    addWorker4();
                    break;
                }
                case 5: {
                    deleteWorker5();
                    break;
                }
                case 0: {
                    //On exit you save data back to the file.

                    exit0();
                    return;
                }
                default: {
                    System.err.println("Fatal error: invalid control flow");
                    System.exit(1);
                }
            }
        }
        //------------------------------------------------------------------------------

    }

    private static void listAllPersonel1() {
        /*for (Worker worker : personel) {
            System.out.println(worker);
        }*/
        for (int i = 0; i < personel.size(); i++) {
            Worker worker = personel.get(i);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String startDate = sdf.format(worker.getStartDate());
            String endDate = sdf.format(worker.getEndDate());
            System.out.printf("%d %s works from %s to %s%n", worker.getUniqueId(), worker.getName(), startDate, endDate);

        }
    }

    private static void workOnSpecificDay2() {
        //2. Find out who works on a specific date
        System.out.println("Enter \"yyyy/MM/dd\" the date to find out who worked");
        Date datef;
        String date;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        for (;;) {
            try {
                date = input.nextLine();
                String data[] = date.split("/");
                for (int i = 0; i < data.length; i++) {
                    if ((i == 0) && !data[0].matches("[1-2][0-9]{3}")) {
                        throw new yearMatching("year is 4 digits");
                    } else if ((i == 1) && !data[1].matches("[01][0-9]")) {
                        throw new monthMatching("month is 2 digits");
                    } else if (i == 1 && !data[2].matches("[0-3][0-9]")) {
                        throw new dayMatching("day contains 2 ");
                    }
                }
                if (data.length != 3) {
                    throw new DateIsNotTheRightFormat("date needs 3 fields");

                }

                datef = formatter.parse(date);
                break;
            } catch (ParseException ex) {
                System.out.println("Enter date as yyyy/MM/dd");
            } catch (DateIsNotTheRightFormat e_date) {
                System.out.println(e_date.toString());
            } catch (yearMatching year) {
                System.out.println(year.toString());
            } catch (monthMatching month) {
                System.out.println(month.toString());
            } catch (dayMatching e_day) {
                System.out.println(e_day.toString());
            }
        }
        System.out.println("Personel that works on " + date);
        for (int i = 0; i < personel.size(); i++) {
            Worker w = personel.get(i);
            if (datef.after(w.getStartDate()) && (datef.before(w.getEndDate()))) {
                System.out.println("we found :");
                System.out.println(w.getName() + w.getStartDate() + w.getStartDate());
            }
        }

    }

    private static void yearPrint3() {
        /*3. Ask for a year number and print out all dates
        in that year that nobody is scheduled to work on
        BONUS***:
        In 3. instead of showing all dates when nobody works
        display RANGES from-to date when nobody works.
         */
        String year;
        Date yeard;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("enter year to show the dates nobody schedule for work");
        for (;;) {
            year = input.nextLine();
            try {
                if (!year.matches("[01][0-9][0-9][0-9]")) {
                    throw new yearMatching("year contains 4 digits");
                }
                yeard = formatter.parse(year);
                break;
            } catch (yearMatching e_year) {
                System.out.println(e_year);
            } catch (ParseException e) {
                System.out.println(e.toString());
            }
        }

        for (Worker worker : personel) {
            System.out.println(worker);
        }

    }

    private static void addWorker4() {
        //4. Add worker
        Date StartDate;
        Date EndDate;
        System.out.println("enter a new worker");
        System.out.print("enter name ");
        String name = input.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        for (;;) {
            try {
                System.out.println("enter start date yyyy/MM/dd");
                String stratDate = input.nextLine();
                System.out.println("enter end date yyyy/MM/dd");
                String endDate = input.nextLine();
                StartDate = formatter.parse(stratDate);
                EndDate = formatter.parse(endDate);
                break;
            } catch (ParseException ex) {
                System.out.println("enter the dates corectly");
            }
        }
        Worker worker = new Worker(name, StartDate, EndDate);
        personel.add(worker);
        System.out.println(worker.getName() + worker.getUniqueId());

    }

    private static void deleteWorker5() {
        //5. Delete worker by Id
        int ID;
        for (;;) {
            System.out.println("enter the ID of the worker to delete ");
            ID = input.nextInt();
            input.nextLine();
            try {
                System.out.println(personel.size());
                if (!(ID <= personel.size() && ID >= 1) ){
                    throw new IdNotFound("enter the ID again ");
                }
                break;
            } catch (IdNotFound e_ID) {
                System.out.println(e_ID.toString());
                
            }
        }
        for (int i = 0; i < personel.size(); i++) {
            Worker w = personel.get(i);
            if (ID == w.getUniqueId()) {
                personel.remove(i);
            }
        }
        for (Worker worker : personel) {
            System.out.println(worker.toString());
        }
    }

    private static void exit0() {
        //On exit you save data back to the file.
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME));

            for (Worker w : personel) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String startDate = sdf.format(w.getStartDate());
                String endDate = sdf.format(w.getEndDate());
                pw.printf("%s;%s;%s%n", w.getName(), startDate, endDate);
            }
            pw.close();
        } catch (IOException e) {
            System.err.println("Error saving to file");
            // FIXME close the file anyway
        }
    }

    static class DateIsNotTheRightFormat extends Exception {

        private String s;

        public DateIsNotTheRightFormat(String s) {
            super();
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    private static class yearMatching extends Exception {

        private String s;

        public yearMatching(String s) {
            super(s);
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    private static class monthMatching extends Exception {

        private String s;

        public monthMatching(String s) {
            super();
            this.s = s;
        }

        @Override
        public String toString() {
            return this.s;
        }
    }

    private static class InvalidDataProvidedException extends Exception {

        private String s;

        public InvalidDataProvidedException(String message) {
            super(message);
            this.s = message;
        }

        @Override
        public String toString() {
            return s;
        }

    }

    private static class dayMatching extends Exception {

        private String s;

        public dayMatching(String day_contains_2_) {
            super();
            this.s = day_contains_2_;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    private static class IdNotFound extends Exception {

        String s;

        public IdNotFound(String id_not_found) {
            super();
        }

        @Override
        public String toString() {
            return s;
        }
    }
}
