package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheBombermanGame {

    private static String[] bomberMan(int n, String[] grid) {
        // Complete this function
        String[] timeGrid = grid.clone();
        String[] firstGrid = increase(timeGrid);
        String[] secondGrid = firstGrid.clone();
        secondGrid = increase(secondGrid);
        secondGrid = plantBombs(secondGrid);
        String[] thirdGrid = secondGrid.clone();
        thirdGrid = explodeAndIncrease(thirdGrid);
        String[] fithGrid = thirdGrid.clone();
        fithGrid = increase(fithGrid);
        fithGrid = plantBombs(fithGrid);
        fithGrid = explodeAndIncrease(fithGrid);
        double thirdSeries = (n-3)/4d;
        if(n==1) {

            return format(firstGrid);
        }
        else if(n%2==0) {

            return format(secondGrid);
        }
        else if(thirdSeries%1 == 0) {

            return format(thirdGrid);
        }
        else {

            return format(fithGrid);
        }
    }

    private static String[] increase(String[] grid) {

        for(int i = 0; i<grid.length; i++) {

            grid[i] = grid[i].replaceAll("1","2").replaceAll("O","1");
        }
        return grid;
    }

    private static String[] plantBombs(String[] grid) {

        for(int i = 0; i<grid.length; i++) {

            grid[i] = grid[i].replaceAll("\\.","O");
        }
        return grid;
    }

    private static String[] explodeAndIncrease(String[] grid) {

        String[] newGrid = grid.clone();
        for(int i = 0; i<grid.length; i++) {

            char[] line = newGrid[i].toCharArray();
            List<Integer> bombs = findBombs(0,grid[i]);
            if(!bombs.isEmpty()) {

                char[] prev = null;
                char[] next = null;

                if (i > 0) {

                    prev = newGrid[i-1].toCharArray();
                }
                if (i < grid.length - 1) {

                    next = newGrid[i+1].toCharArray();
                }
                for (Integer idx : bombs) {

                    line[idx] = '.';
                    if (idx > 0) {

                        line[idx - 1] = '.';
                    }
                    if (idx < line.length - 1) {

                        line[idx + 1] = '.';
                    }
                    if (prev != null) {

                        prev[idx] = '.';
                    }
                    if (next != null) {

                        next[idx] = '.';
                    }
                }
                if (prev != null) {

                    newGrid[i-1] = String.valueOf(prev);
                }
                if (next != null) {

                    newGrid[i+1] = String.valueOf(next);
                }
            }
            newGrid[i] = String.valueOf(line).replaceAll("O","1");
        }
        return newGrid;
    }

    private static List<Integer> findBombs(int idx, String line) {

        List<Integer> bombs = new ArrayList<>();
        if(idx<line.length()){

            int i = line.indexOf("2",idx);
            if(i>-1) {

                bombs.add(i);
                bombs.addAll(findBombs(i + 1, line));
            }
        }
        return bombs;
    }

    private static String[] format(String[] grid) {

        for(int i = 0; i<grid.length; i++) {

            grid[i] = grid[i].replaceAll("1","O").replaceAll("2","O");
        }
        return grid;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();
        String[] grid = new String[r];
        for(int grid_i = 0; grid_i < r; grid_i++){
            grid[grid_i] = in.next();
        }
        String[] result = bomberMan(n, grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
