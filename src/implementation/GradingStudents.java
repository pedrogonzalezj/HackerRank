package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class GradingStudents {

    private static int[] solve(int[] grades) {
        // Complete this function
        return Arrays.stream(grades).parallel().map(grade -> {

            int roundedGrade = grade;
            if(grade >= 38) {

                int ganMultipleOfFive = (int) Math.ceil((double)grade/(double)5)*5;

                if(ganMultipleOfFive - grade < 3 ) {

                    roundedGrade = ganMultipleOfFive;
                }
            }
            return roundedGrade;
        }).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


    }
}
