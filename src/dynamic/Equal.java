package dynamic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Equal {

   private static int equal(int[] arr) {
        // Complete this function
        int i = 0;
        Arrays.sort(arr);
        if(arr.length>0) {
            final int min = arr[0];
            final List<Integer> stepsList = new ArrayList<>();
            while (i <= 4) {

                int steps = 0;
                final int[] delta = delta(min - i, arr);
                for (final int aDelta : delta) {

                    steps = steps + aDelta/5 + (aDelta%5)/3 + (aDelta%5)%3;
                }
                stepsList.add(steps);
                i = i + 1;
            }
            return stepsList.stream().min(Comparator.naturalOrder()).orElse(0);
        }
        return 0;
    }

    private static int[] delta(int min, int[] arr) {

        return Arrays.stream(arr).map(n -> n-min).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = equal(arr);
            System.out.println(result);
        }
        in.close();
    }
}