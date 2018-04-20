package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BirthDayChocolate {

    private static int solve(int n, int[] s, int d, int m){
        // Complete this function
        return find(d,m,s);
    }

    private static int find(int d, int m, int[] bar) {

        int count = 0;
        if(bar.length >= m) {
            int sum = Arrays.stream(Arrays.copyOfRange(bar,0,m)).sum();
            if(sum == d) {

                count = count + 1;
            }
        }
        return count + (bar.length > m ? find(d,m, Arrays.copyOfRange(bar,1,bar.length)) : 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
