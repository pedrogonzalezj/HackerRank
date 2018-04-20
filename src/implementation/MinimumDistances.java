package implementation;

import java.util.Scanner;

public class MinimumDistances {

    private static int minimumDistances(int[] a) {
        // Complete this function
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i<a.length; i++) {

            for(int j = i+1; j<a.length; j++) {

                int distance = j-i;
                if(a[i] == a[j] && distance < minDistance) {

                    minDistance = distance;
                }
            }
        }
        return minDistance != Integer.MAX_VALUE ? minDistance : -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = minimumDistances(a);
        System.out.println(result);
        in.close();
    }
}
