package implementation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EqualizeArray {

    private static int equalizeArray(int[] arr) {
        // Complete this function
        Map<Integer,Long> counts = new HashMap<>(arr.length);
        for (final int anArr : arr) {

            long curr = counts.get(anArr) != null ? counts.get(anArr) : 0;
            counts.put(anArr, curr + 1);
        }
        return Long.valueOf(arr.length - Collections.max(counts.values())).intValue();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = equalizeArray(arr);
        System.out.println(result);
        in.close();
    }
}
