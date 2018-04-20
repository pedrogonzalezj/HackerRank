package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class AppleAndOrange {

    private static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        // Complete this function
        final long applesScore = Arrays.stream(apples).filter(d -> d>= s - a && d<= t - a).count();
        final long orangesScore = Arrays.stream(oranges).filter(d -> d >= s -b  && d <= t - b).count();
        System.out.println(applesScore);
        System.out.println(orangesScore);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i = 0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i = 0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        countApplesAndOranges(s, t, a, b, apple, orange);
        in.close();
    }
}
