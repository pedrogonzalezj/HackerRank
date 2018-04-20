package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class TheHurdleRace {


    private static int hurdleRace(int k, int[] height) {
        // Complete this function
        int totalHeightToJump = Arrays.stream(height).filter(h -> h>k).max().orElse(0);
        return totalHeightToJump >0 ? totalHeightToJump - k : 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for(int height_i = 0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        int result = hurdleRace(k, height);
        System.out.println(result);
        in.close();
    }
}
