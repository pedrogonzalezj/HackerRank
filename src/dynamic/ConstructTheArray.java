package dynamic;


import java.util.Scanner;

public class ContructTheArray {

    private static long countArray(int length, int max, int lastElement) {

        final int mod = 1000000007; //we want to have always an integer value
        final long[] previousState = {1,0};
        //{number of ones at iteration i, number of the rest of numbers between 1..max (all have the same number)}
        final long[] state = {1,0};
        for (int i = 1; i < length; i++){
            state[0] = ((max - 1) * previousState[1]) % mod; //reduce to integer
            state[1] = ((max - 2) * previousState[1] + previousState[0]) % mod; //reduce to integer
            previousState[0] = state[0];
            previousState[1] = state[1];
        }
        return lastElement == 1 ? state[0] : state[1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        long answer = countArray(n, k, x);
        System.out.println(answer);
        in.close();
    }
}
