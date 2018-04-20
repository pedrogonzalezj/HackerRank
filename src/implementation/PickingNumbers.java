package implementation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PickingNumbers {

    private static int pickingNumbers(int[] a) {
        // Complete this function
        Integer start = null;
        PriorityQueue<Integer> sets = new PriorityQueue<>(Comparator.reverseOrder());
        int count = 0;
        Arrays.sort(a);
        for(int n: a) {

            if(start == null) {

                start = n;
                count = 1;
            }
            else if(Math.abs(n - start)<=1) {

                count = count + 1;
            }
            else {

                sets.add(count);
                start = n;
                count = 1;
            }
        }
        return !sets.isEmpty() ? sets.peek() : count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }
}
