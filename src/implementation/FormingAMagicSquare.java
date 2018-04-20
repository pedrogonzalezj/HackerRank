package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormingAMagicSquare {

    private static int formingMagicSquare(int[][] s) {
        // Complete this function
        List<int[][]> magicSquares = generateAllMagicSquares();
        int cost = Integer.MAX_VALUE;
        for(int[][] magic: magicSquares) {

            final int actualCost =  calculateCost(s,magic);
            if(actualCost < cost) {

                cost = actualCost;
            }
        }
        return cost;
    }

    private static int calculateCost(int[][]s, int[][] magicSquare) {

        int actualCost = 0;
        for(int i = 0; i < magicSquare.length; i++) {

            for(int j = 0; j < magicSquare.length; j++) {

                actualCost = actualCost + Math.abs(magicSquare[i][j] - s[i][j]);
            }
        }
        return actualCost;
    }

    private static List<int[][]> generateAllMagicSquares() {

        final List<int[][]> magicSquares = new ArrayList<>(8);
        final int[][] base = new int[3][3];
        base[0][0] = 4;
        base[0][1] = 9;
        base[0][2] = 2;
        base[1][0] = 3;
        base[1][1] = 5;
        base[1][2] = 7;
        base[2][0] = 8;
        base[2][1] = 1;
        base[2][2] = 6;
        magicSquares.add(base);
        //rotations
        //1
        final int[][] firstRotation = rotate(base);
        magicSquares.add(firstRotation);
        //2
        final int[][] secondRotation = rotate(firstRotation);
        magicSquares.add(secondRotation);
        //3
        final int[][] thirdRotation = rotate(secondRotation);
        magicSquares.add(thirdRotation);
        //reflect
        //1
        final int[][] firstReflection = reflect(base);
        magicSquares.add(firstReflection);
        //2
        final int[][] secondReflection = reflect(firstRotation);
        magicSquares.add(secondReflection);
        //3
        final int[][] thirdReflection = reflect(secondRotation);
        magicSquares.add(thirdReflection);
        //4
        final int[][] fourthReflection = reflect(thirdRotation);
        magicSquares.add(fourthReflection);
        return magicSquares;
    }

    private static int[][] rotate(int[][] in) {

        final int[][] out = new int[3][3];
        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {

                out[2 - j][i] = in[i][j];
            }
        }
        return out;
    }

    private static int[][] reflect(int[][] in) {

        final int[][] out = new int[3][3];
        for(int i = 0; i < 3; i++) {

            out[i][0] = in[i][2];
            out[i][1] = in[i][1];
            out[i][2] = in[i][0];
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }
}
