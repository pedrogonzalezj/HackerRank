package implementation;

import java.util.Scanner;

public class CavityMap {

    private static String[] cavityMap(String[] grid) {
        // Complete this function
        for(int i = 1; i<grid.length-1; i++) {

            final String prevRow = grid[i-1];
            final String nextRow = grid[i+1];
            final char[] row = grid[i].toCharArray();
            for(int j = 1; j<row.length-1; j++) {

                final char top    = prevRow.charAt(j);
                final char left   = row[j-1];
                final char right  = row[j+1];
                final char bottom = nextRow.charAt(j);
                final char curr   = row[j];
                if(isCavity(top,right,bottom,left,curr)) {
                    row[j] = 'X';
                }
            }
            grid[i] = String.valueOf(row);
        }
        return grid;
    }

    private static boolean isCavity(char top, char rigth, char bottom, char left, char curr) {

        return top<curr && left<curr && rigth<curr && bottom<curr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i = 0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        String[] result = cavityMap(grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
