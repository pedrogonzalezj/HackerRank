package implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QueensAttackII {

    private static final String NORTH_LINE = "n";
    private static final String NORTH_EAST_LINE = "ne";
    private static final String EAST_LINE = "e";
    private static final String SOUTH_EAST_LINE = "se";
    private static final String SOUTH_LINE = "s";
    private static final String SOUTH_WEST_LINE = "sw";
    private static final String WEST_LINE = "w";
    private static final String NORTH_WEST_LINE = "nw";

    private static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        // Complete this function
        final Map<String, Integer> attackableCells = new HashMap<>(8);
        attackableCells.put(NORTH_LINE,n - r_q);
        if(c_q - r_q <= 0) {

            attackableCells.put(NORTH_EAST_LINE,Math.abs(n - r_q));
        }
        else {

            attackableCells.put(NORTH_EAST_LINE,Math.abs(n - c_q));
        }
        attackableCells.put(EAST_LINE,n - c_q);
        if(c_q + r_q <= n + 1) {

            attackableCells.put(SOUTH_EAST_LINE,Math.abs(1 - r_q));
        }
        else {

            attackableCells.put(SOUTH_EAST_LINE,Math.abs(c_q - n));
        }
        attackableCells.put(SOUTH_LINE,r_q - 1);
        if(c_q - r_q >= 0) {

            attackableCells.put(SOUTH_WEST_LINE,Math.abs(1 - r_q));
        }
        else {

            attackableCells.put(SOUTH_WEST_LINE,Math.abs(1 - c_q));
        }
        attackableCells.put(WEST_LINE,c_q - 1);
        if(c_q + r_q >= n + 1) {

            attackableCells.put(NORTH_WEST_LINE,Math.abs(n - r_q));
        }
        else {

            attackableCells.put(NORTH_WEST_LINE,Math.abs(c_q - 1));
        }

        for(int i=0;i<k;i++) {
            //row, col
            int[] obstacle = obstacles[i];
            //check if blocks north/south line line
            updateNorthSouthCells(attackableCells,r_q,c_q,obstacle);
            //check if blocks east/west line
            updateEastWestCells(attackableCells,r_q,c_q,obstacle);
            //check if blocks northeast/southwest line
            updateNorthEastSouthWest(attackableCells,r_q,c_q,obstacle);
            //check if blocks northwest/southeast line
            updateNorthWestSouthEastCells(attackableCells,r_q,c_q,obstacle);
        }
        return attackableCells.values().parallelStream().reduce(0,Integer::sum);
    }

    private static void updateNorthEastSouthWest(Map<String, Integer> attackableCells, int r_q, int c_q, int[] obstacle) {

        if(r_q - c_q == obstacle[0] - obstacle[1]) {

            final int cells = Math.abs(obstacle[0] - r_q) - 1;
            if (obstacle[0] > r_q && attackableCells.get(NORTH_EAST_LINE) > cells) {

                attackableCells.put(NORTH_EAST_LINE, cells);
            } else if (obstacle[0] < r_q && attackableCells.get(SOUTH_WEST_LINE) > cells) {

                attackableCells.put(SOUTH_WEST_LINE, cells);
            }
        }
    }

    private static void updateNorthWestSouthEastCells(Map<String, Integer> attackableCells, int r_q, int c_q, int[] obstacle) {

        //check if blocks northwest/southeast line
        if(r_q + c_q == obstacle[0] + obstacle[1]) {

            final int cells = Math.abs(obstacle[0] - r_q) - 1;
            if(obstacle[0] > r_q && attackableCells.get(NORTH_WEST_LINE)>cells) {

                attackableCells.put(NORTH_WEST_LINE,cells);
            }
            else if(obstacle[0] < r_q && attackableCells.get(SOUTH_EAST_LINE)>cells) {

                attackableCells.put(SOUTH_EAST_LINE,cells);
            }
        }
    }

    private static void updateNorthSouthCells(Map<String, Integer> attackableCells, int r_q, int c_q, int[] obstacle) {

        if(obstacle[1] == c_q) {

            //north or south
            int cells = Math.abs(r_q - obstacle[0]) - 1;
            if(obstacle[0] > r_q && attackableCells.get(NORTH_LINE)>cells) {

                attackableCells.put(NORTH_LINE,cells);
            }
            else if(obstacle[0] < r_q && attackableCells.get(SOUTH_LINE)>cells) {

                attackableCells.put(SOUTH_LINE,cells);
            }
        }
    }

    private static void updateEastWestCells(Map<String, Integer> attackableCells, int r_q, int c_q, int[] obstacle) {
        //check if blocks east/west line
        if(obstacle[0] == r_q) {

            //north or south
            final int cells = Math.abs(c_q - obstacle[1]) - 1;
            if(obstacle[1] > c_q && attackableCells.get(EAST_LINE)>cells) {

                attackableCells.put(EAST_LINE,cells);
            }
            else if(obstacle[1] < c_q && attackableCells.get(WEST_LINE)>cells) {

                attackableCells.put(WEST_LINE,cells);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r_q = in.nextInt();
        int c_q = in.nextInt();
        int[][] obstacles = new int[k][2];
        for(int obstacles_i = 0; obstacles_i < k; obstacles_i++){
            for(int obstacles_j = 0; obstacles_j < 2; obstacles_j++){
                obstacles[obstacles_i][obstacles_j] = in.nextInt();
            }
        }
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        in.close();
    }
}