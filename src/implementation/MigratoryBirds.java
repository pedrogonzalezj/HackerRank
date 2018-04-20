package implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class MigratoryBirds {

    private static int migratoryBirds(int[] ar) {
        // Complete this function
        return check(ar).orElse(0);
    }

    private static Optional<Integer> check(int[] arr) {

        Map<Integer, Integer> sights = new HashMap<>();
        for (final int anArr : arr) {

            sights.merge(anArr, 1, (a, b) -> a + b);
        }
        return sights.entrySet().stream().max((e1,e2) -> {

           if(e1.getValue().equals(e2.getValue())) {

               return e2.getKey() - e1.getKey();
           }
           else {

               return e1.getValue()-e2.getValue();
            }
        }).map(Map.Entry::getKey);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(ar);
        System.out.println(result);
    }
}
