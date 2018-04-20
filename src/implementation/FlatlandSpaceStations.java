package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class FlatlandSpaceStations {

    private static int flatlandSpaceStations(int n, int[] c) {
        // Complete this function
        Arrays.sort(c);
        int maxDistance = c[0];
        for(int i = 0; i<c.length; i++) {

            int distance;
            if(i+1<c.length) {

                distance = (int)Math.floor((c[i+1]-c[i])/2);
            }
            else {

                distance = n-c[i]-1;
            }
            if(maxDistance<distance) {

                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i = 0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = flatlandSpaceStations(n, c);
        System.out.println(result);
        in.close();
    }
}
