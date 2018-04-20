package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheGridSearch {

    private static String gridSearch(String[] G, String[] P) {
        // Complete this function
        for(int i = 0; i<G.length-P.length+1; i++) {

            final String row = G[i];
            final String pattern = P[0];
            for(Integer idx: search(-1,row,pattern)) {

                if(matches(G,P,i,idx)) {

                    return "YES";
                }
            }
        }
        return "NO";
    }

    private static boolean matches(String[] G, String[] P, int rowIdx, int column) {

        int j = rowIdx;
        //check width and height
        if(rowIdx+P.length>G.length) {

            return false;
        }
        if(column+P[0].length()>G[0].length()) {

            return false;
        }
        for (final String pattern : P) {

            final String row = G[j].substring(column, column + pattern.length());
            if (!pattern.equals(row)) {

                return false;
            }
            j = j + 1;
        }
        return true;
    }

    private static List<Integer> search(int idx, String row, String pattern) {

        final List<Integer> indexes = new ArrayList<>();
        if(idx<row.length()-pattern.length()) {

            int index = row.indexOf(pattern, idx + 1);
            if (index != -1) {

                indexes.add(index);
                indexes.addAll(search(index + 1, row, pattern));
            }
        }
        return indexes;
    }

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for(int G_i = 0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];
            for(int P_i = 0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            String result = gridSearch(G, P);
            System.out.println(result);
        }
        in.close();
    }
}
