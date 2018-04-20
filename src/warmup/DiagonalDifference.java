package warmup;

import java.util.Scanner;

public class DiagonalDifference {

    private static int diagonalDifference(int[][] a) {
        // Complete this function
        int secondDiagonal = 0;
        int firstDiagonal  = 0;
        for(int i = 0; i < a.length; i++) {

            for(int j = a.length-1; j >= 0; j--) {

                if(i == j) {

                    firstDiagonal = firstDiagonal + a[i][j];
                }
                if(i  + j == a.length -1) {

                    secondDiagonal = secondDiagonal + a[i][j];
                }
            }
        }
        return Math.abs(firstDiagonal - secondDiagonal);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}
