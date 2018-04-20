package implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NonDivisibleSubSet {

    private static int nonDivisibleSubset(int k, int[] S) {

        final Set<Integer> maximalSet = permute(k,S);
        return maximalSet.size();
    }

    private static Set<Integer> permute(int k, int[] arr) {

        final Set<Integer> undivisibleSet = new HashSet<>();
        for(int i = 0; i < arr.length; i ++) {

            for(int j = i+1; j<arr.length; j++) {

                Pair pair = new Pair(arr[i],arr[j]);
                if(undivisibleSet.isEmpty() && pair.sum()%k != 0) {

                    undivisibleSet.add(pair.getA());
                    undivisibleSet.add(pair.getB());
                }
            }
        }
        return undivisibleSet;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");

        for (int SItr = 0; SItr < n; SItr++) {
            int SItem = Integer.parseInt(SItems[SItr].trim());
            S[SItr] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

class Pair  {

    private int a;
    private int b;

    Pair(int a, int b) {

        this.a = a;
        this.b = b;
    }

    public final int getA() {
        return a;
    }

    public final int getB() {
        return b;
    }

    final int sum() {

        return a + b;
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair other = (Pair) obj;
        return a == other.a && b == other.b;
    }

    @Override
    public int hashCode() {
            return a+b;
        }
}
