package implementation;

import java.util.Scanner;

public class SurfaceArea {

    private static int surfaceArea(int[][] A) {
        // Complete this function
        int area = 0;
        for(int i = 0; i< A.length; i++) {

            for(int j = 0; j<A[i].length; j++) {

                int height = A[i][j];
                area = area + 4*height + 2;
                if(j>0) {

                    area = minus(area,height,A[i][j-1]);
                }
                if(j<A[i].length-1) {

                    area = minus(area,height,A[i][j+1]);
                }
                if(i>0) {

                    area = minus(area,height,A[i-1][j]);
                }
                if(i<A.length-1) {

                    area = minus(area,height,A[i+1][j]);
                }
            }
        }
        return area;
    }

    private static int minus(int area, int currentHeight, int height) {

        if(height > currentHeight) {

            return area - currentHeight;
        }
        else {

            return area - height;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for(int A_i = 0; A_i < H; A_i++){
            for(int A_j = 0; A_j < W; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = surfaceArea(A);
        System.out.println(result);
        in.close();
    }
}
