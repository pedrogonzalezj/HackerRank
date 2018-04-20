package warmup;

import java.util.Arrays;
import java.util.Scanner;

public class BirthDayCakeCandles {

    private static int birthdayCakeCandles(int[] ar) {
        // Complete this function
        final int maxValue   = Arrays.stream(ar).max().orElse(0);
        return (int)Arrays.stream(ar).filter(c -> c == maxValue).count();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(ar);
        System.out.println(result);
    }
}
