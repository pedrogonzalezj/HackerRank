package implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AbsolutePermutation {

    private static final Scanner scanner = new Scanner(System.in);

    private static int[] absolutePermutation(int n, int k) {


        final int[] permutation = new int[n];
        Set<Integer> values = new HashSet<>();
        for(int i = 1; i<=n; i++) {

            int a = k+i;
            int b = i-k;
            if(b>=1 && b<=n && !values.contains(b)) {

                permutation[i-1] = b;
                values.add(b);
            }
            else if(a >=1 && a <=n && !values.contains(a)) {

                permutation[i-1] = a;
                values.add(a);
            }
            else {

                return new int[0];
            }
        }
        return permutation;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0].trim());

            int k = Integer.parseInt(nk[1].trim());

            final int[] result = absolutePermutation(n, k);

            if(result.length>0) {

                for (int resultItr = 0; resultItr < result.length; resultItr++) {
                    bufferedWriter.write(String.valueOf(result[resultItr]));
                    System.out.print(result[resultItr]);
                    if (resultItr != result.length - 1) {
                        bufferedWriter.write(" ");
                        System.out.print(" ");
                    }
                }
            }
            else {

                bufferedWriter.write("-1");
            }
            bufferedWriter.newLine();
            System.out.println("");
        }

        bufferedWriter.close();
    }
}
