package implementation;

import java.util.Scanner;

public class SequenceEquation {

    private static int[] permutationEquation(int[] p) {
        // Complete this function
        int n = p.length;
        int[] r = new int[n];
        int[] inversef = new int[n];
        for(int i = 0; i<n; i++) {

            inversef[p[i]-1] = i;
        }
        for(int i = 0; i<n; i++) {

            r[i] = inversef[inversef[i]]+1;
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
        }
        int[] result = permutationEquation(p);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
