package implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MatrixLayerRotation {

    private static int[][] matrixRotation(int[][] matrix, int r) {
        // Complete this function
        return rotate(matrix,r);
    }

    private static int[][] rotate(int[][] matrix, int r) {


        final int rows    = matrix.length;
        final int columns = matrix[0].length;
        final int[][] rotated = new int[rows][columns];
        final Map<Integer,MatrixPosition[]> mappings = map(matrix);
        final int numberOfCicles = numberOfCicles(rows,columns);
        for(int c=0; c<=numberOfCicles; c++) {

            final MatrixPosition[] mapping = mappings.get(c);
            final int positions = 2*(rows-2*c-1)+2*(columns-2*c-1);
            final int movements = r%positions;
            for(int p=0; p<positions; p++) {

                final MatrixPosition startpoint = mapping[p];
                final int idx = p+movements<positions ? p+movements : p+movements-positions;
                final MatrixPosition endpoint   = mapping[idx];
                rotated[endpoint.getI()][endpoint.getJ()] = matrix[startpoint.getI()][startpoint.getJ()];
            }
        }
        return rotated;
    }

    private static Map<Integer,MatrixPosition[]> map(int matrix[][]) {

        final int rows = matrix.length;
        final int columns = matrix[0].length;
        final int numberOfCicles = numberOfCicles(rows,columns);
        final Map<Integer,MatrixPosition[]> mapping = new HashMap<>(numberOfCicles+1);
        for(int c = 0; c<=numberOfCicles; c++) {

            final int positions                 = 2*(rows-2*c-1)+2*(columns-2*c-1);
            final MatrixPosition[] cicleMapping = new MatrixPosition[positions];
            final int cicleRows                 = rows-2*c;
            final int cicleColumns              = columns-2*c;
            for(int i=0; i<positions; i++) {

                //left column
                if(i<cicleRows-1) {

                    cicleMapping[i] = new MatrixPosition(c+i,c);
                }
                //bottom row
                else if(i>=cicleRows-1 && i<cicleRows+cicleColumns-2) {

                    int idx = i+c+1-cicleRows;
                    cicleMapping[i] = new MatrixPosition(rows-c-1,idx);
                }
                //right column
                else if(i>=cicleRows+cicleColumns-2 && i<2*cicleRows+cicleColumns-3) {

                    int idx = 2*rows+columns-5*c-3-i;
                    cicleMapping[i] = new MatrixPosition(idx,columns-1-c);
                }
                else {

                    int idx = 2*rows+2*columns-7*c-4-i;  
                    cicleMapping[i] = new MatrixPosition(c,idx);
                }
            }
            mapping.put(c,cicleMapping);
        }
        return mapping;
    }

    private static int numberOfCicles(int rows, int columns) {

        return rows<columns ? rows/2-1 : columns/2-1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        int[][] matrix = new int[m][n];
        for(int matrix_i = 0; matrix_i < m; matrix_i++){
            for(int matrix_j = 0; matrix_j < n; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        int[][] rotated = matrixRotation(matrix,r);
        for(int i=0; i<rotated.length; i++) {

            for(int j=0; j<rotated[i].length; j++) {

                System.out.print(rotated[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        in.close();
    }
}

class MatrixPosition {

    private int i;
    private int j;

    MatrixPosition(int i, int j) {

        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}

