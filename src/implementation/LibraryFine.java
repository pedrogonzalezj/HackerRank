package implementation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class LibraryFine {

    private static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Complete this function
        final LocalDate returnDate = LocalDate.of(y1,m1,d1);
        final LocalDate dueDate = LocalDate.of(y2,m2,d2);
        if(returnDate.isBefore(dueDate) || returnDate.isEqual(dueDate)) {

            return 0;
        }
        else if(returnDate.isAfter(dueDate) && m2 == m1 && y2 == y1) {

            return (int)(15*dueDate.until(returnDate, ChronoUnit.DAYS));
        }
        else if(returnDate.isAfter(dueDate) && y2 == y1) {

            return 500*(m1-m2);
        }
        else {

            return 10000;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        int result = libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result);
        in.close();
    }
}
