package implementation;

import java.util.Scanner;

public class DrawingBook {

    private static int solve(int n, int p){

        int pagesTurnedFromStart;
        int pagesTurnedFromEnd;
        if(p%2 == 0) {

            pagesTurnedFromStart = p/2;
            pagesTurnedFromEnd = n%2 == 0 ? (n - p)/2 : (n - p - 1)/2;

        }
        else {

            pagesTurnedFromStart = (p-1)/2;
            pagesTurnedFromEnd = n%2 == 0 ? (n + 1 - p)/2 : (n - p)/2;
        }
        return pagesTurnedFromStart < pagesTurnedFromEnd ? pagesTurnedFromStart : pagesTurnedFromEnd;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
}
