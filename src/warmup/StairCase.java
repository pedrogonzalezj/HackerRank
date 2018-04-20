package warmup;

import java.util.Scanner;

public class StairCase {

    private static void staircase(int n) {
        // Complete this function
        for(int i = n-1; i>=0;i--) {

            for(int j = 0; j<n;j++) {

                if(j-i>=0) {
                    System.out.print("#");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }
}
