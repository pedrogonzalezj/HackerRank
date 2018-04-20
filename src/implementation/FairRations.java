package implementation;

import java.util.Scanner;

public class FairRations {

    private static void fairRations(int[] B) {
        // Complete this function
        int sum = 0;
        int count = 0;
        for (final int aB : B) {

            sum += aB;
            if (sum % 2 == 1) {

                count += 2;
            }
        }
        System.out.println(sum % 2 == 0 ? count : "NO");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] B = new int[N];
        for(int B_i = 0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
        }
        fairRations(B);
        in.close();
    }
}
