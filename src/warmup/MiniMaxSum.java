package warmup;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class MiniMaxSum {

    private static void miniMaxSum(int[] arr) {
        // Complete this function
        BigInteger max = BigInteger.ZERO;
        BigInteger min = BigInteger.ZERO;
        for(int i = 0; i<arr.length;i++) {

            final BigInteger tmpSum = sum(i,arr);
            if(tmpSum.compareTo(max)>0) {
                max = tmpSum;
            }
            if(tmpSum.compareTo(min)<0 || i == 0) {
                min = tmpSum;
            }
        }
        System.out.println(min + "  " + max);
    }

    private static BigInteger sum(int excluded, int[] arr) {

        if(arr.length == 0) {

            return BigInteger.ZERO;
        }
        else {

            final BigInteger curr = arr.length -1 != excluded ? BigInteger.valueOf(arr[arr.length-1]) : BigInteger.ZERO;
            return sum(excluded,Arrays.copyOfRange(arr,0,arr.length-1)).add(curr);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }
}
