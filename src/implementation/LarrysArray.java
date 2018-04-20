package implementation;

import java.util.Scanner;

public class LarrysArray {

    private static String larrysArray(int[] A) {
        // Complete this function

        int inversions = 0;
        for(int i = 0; i <A.length; i++) {

            int current = A[i];
            for(int j = i+1; j<A.length; j++) {

                if(A[j]<current) {

                    inversions = inversions+1;
                }
            }
        }
        if(A.length%2!=0 && inversions%2==0) {

            return "YES";
        }
        else if(A.length%2==0 && inversions%2==0) {

            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] A = new int[n];
            for(int A_i = 0; A_i < n; A_i++){
                A[A_i] = in.nextInt();
            }
            String result = larrysArray(A);
            System.out.println(result);
        }
        in.close();
    }
}
