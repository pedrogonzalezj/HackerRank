package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks {

    private static Integer[] cutTheSticks(int[] arr) {
        // Complete this function
        Arrays.sort(arr);
        List<Integer> cutted = new ArrayList<>();
        int i = 0;
        do {

           for (; i < arr.length; i++) {

               if (arr[i] > 0) {

                   break;
               }
           }
           if(i<arr.length) {

               int toCut = arr[i];
               int count = 0;
               for (int j = i; j < arr.length; j++) {

                   count = count + 1;
                   int updatedLength = arr[j] - toCut;
                   arr[j] = updatedLength;
               }
               cutted.add(count);
           }
        } while(i < arr.length);
        return cutted.toArray(new Integer[cutted.size()]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        Integer[] result = cutTheSticks(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
