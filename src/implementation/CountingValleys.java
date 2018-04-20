package implementation;

import java.util.Scanner;

public class CountingValleys {

    private static int countingValleys(String s) {
        // Complete this function
        int level = 0;
        int valleys = 0;
        for(int i = 0; i < s.length(); i++) {

            final char currentStep = s.charAt(i);
            if(currentStep == 'U') {

                if(level == -1) {

                    valleys = valleys + 1;
                }
                level = level + 1;
            }
            else if(currentStep == 'D') {


                level = level - 1;
            }
        }
        return valleys;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = countingValleys(s);
        System.out.println(result);
        in.close();
    }
}
