package implementation;

import java.util.Scanner;

public class JumpingOnTheCloudsRev {

    private static int jumpingOnClouds(int[] c, int k) {
        // Complete this function
        int energy = 100;
        int cloud = 0;
        int n = c.length;
        //n = c.lenght
        //use 1 energy to jump k to cloud: (i+k)%n
        //if ci = 1 energy = energy - 2
        //starts at 0
        int numberOfJumps = c.length/k;
        for(int i = 0; i<numberOfJumps;i++) {

            cloud = (cloud+k)%n;
            if(c[cloud] == 1) {

                energy = energy - 2;
            }
            energy = energy -1;
        }
        return energy;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c, k);
        System.out.println(result);
        in.close();
    }
}
