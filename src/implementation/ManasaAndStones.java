package implementation;

import java.util.Scanner;

public class ManasaAndStones {

    private static String stones(int n, int one, int two) {
        // Complete this function
        int a = Math.min(one,two);
        int b = Math.max(one,two);
        if(a == b) {

            return ((n-1)*a) + "";
        }
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int toAppend = a * (n-i-1) + b * i;
            output.append(toAppend).append(" ");
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(stones(n, a, b));
        }
        in.close();
    }
}
