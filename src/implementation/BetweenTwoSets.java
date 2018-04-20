package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BetweenTwoSets {

    private static int getTotalX(int[] a, int[] b) {
        // Complete this function
        final List<Integer> commonFactors = new ArrayList<>();
        commonFactors.addAll(factors(1,b[0]));
        for(int i = 1; i<b.length;i++) {

            commonFactors.retainAll(factors(1,b[i]));
        }
        return (int)commonFactors.stream().filter(factor -> Arrays.stream(a).noneMatch(n -> factor%n!=0)).count();
    }

    private static List<Integer> factors(int f, int number) {

        final List<Integer> factors = new ArrayList<>();
        if( f <= number) {

            if(number%f == 0) {

                factors.add(f);
                factors.addAll(factors(f + 1, number));
                return factors;
            }
            else {

                return factors(f+1, number);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
