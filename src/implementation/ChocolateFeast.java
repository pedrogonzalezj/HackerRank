package implementation;

import java.util.Scanner;

public class ChocolateFeast {

    private static int chocolateFeast(int cash, int cost, int neededWrappers) {
        // Complete this function
        int chocolates = cash/cost;
        int wrappers = chocolates;
        while(wrappers>=neededWrappers) {
            wrappers = 1+wrappers-neededWrappers;
            chocolates = chocolates+1;
        }
        return chocolates;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            int result = chocolateFeast(n, c, m);
            System.out.println(result);
        }
        in.close();
    }
}
