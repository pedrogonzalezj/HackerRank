package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class DivisibleSumPairs {

    private static int divisibleSumPairs(int n, int k, int[] ar) {
        // Complete this function
        return count(k,ar);
    }

    private static int count(int k, int[] arr) {

        int count = 0;
        int i = arr[0];
        for(int j = 1; j < arr.length; j++) {

            if((i + arr[j])%k == 0) {

                count = count + 1;
            }
        }
        return count + (arr.length>1 ? count(k,Arrays.copyOfRange(arr,1,arr.length)) : 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }
}
