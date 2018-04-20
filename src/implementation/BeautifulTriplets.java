package implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BeautifulTriplets {

    private static int beautifulTriplets(int d, int[] arr) {
        // Complete this function
        final Set<Integer> jValues = new HashSet<>();
        int triplets = 0;
        for(int i = 0; i<arr.length; i++) {

            for(int j = i+1; j<arr.length; j++) {

                int diff = arr[j]-arr[i];
                if(diff == d) {

                    if(jValues.contains(arr[i])) {

                        triplets = triplets + 1;
                        jValues.add(arr[j]);

                    }
                    else {

                        jValues.add(arr[j]);
                    }
                    break;
                }
                else if(diff>d) {
                    break;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = beautifulTriplets(d, arr);
        System.out.println(result);
        in.close();
    }
}


