package implementation;

import java.util.Scanner;

public class Encryption {

    private static String encryption(String s) {
        // Complete this function
        char[][] matrix;
        int rows;
        int cols;
        String stripped = s.replace(" ","");
        double l = Math.sqrt(stripped.length());
        final int min = (int)Math.floor(l);
        final int max = (int)Math.ceil(l);
        if(min*max == stripped.length()) {

            rows = min;
            cols = max;
        }
        else if(min*max>stripped.length()) {
            rows = min;
            cols = 0;
            for (int i = min; i <= max; i++) {

                if (min * i >= stripped.length()) {

                    cols = i;
                    break;
                }
            }
        }
        else {

            rows = max;
            cols = max;
        }
        matrix = fillMatrix(rows,cols,stripped);
        return encript(rows,cols,matrix);
    }

    private static String encript(int rows, int cols, char[][] matrix) {

        StringBuilder encripted = new StringBuilder();
        for(int i = 0; i < cols; i++) {

            for(int j = 0; j < rows; j ++) {

                if(matrix[j][i]!=Character.UNASSIGNED) {

                    encripted.append(matrix[j][i]);
                }
            }
            encripted.append(" ");
        }
        return encripted.toString();
    }

    private static char[][] fillMatrix(int rows, int cols, String message) {

        int idx = 0;
        final char[][] matrix = new char[rows][cols];
        for(int i = 0; i<rows; i++) {

            for(int j = 0; j<cols; j++) {

                if(idx<message.length()) {

                    matrix[i][j] = message.charAt(idx);
                    idx = idx+1;
                }
                else {

                    return matrix;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = encryption(s);
        System.out.println(result);
        in.close();
    }
}
