package implementation;

import java.util.Scanner;

public class JumpingOnTheClouds {

    private static int jumpingOnClouds(int[] c) {
        // Complete this function
        return countSteps(0,c);
    }

    private static int countSteps(int idx, int[] c) {

        int steps = 0;
        if(idx+2<=c.length-1 && c[idx+2] == 0) {

            steps =  1 + countSteps(idx+2,c);
        }
        else if(idx+1<=c.length-1 && c[idx+1] == 0) {

            steps = 1 + countSteps(idx+1,c);
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c);
        System.out.println(result);
        in.close();
    }
}
