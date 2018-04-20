package implementation;

import java.util.Scanner;

public class SherlockAndSquares {

    private static int squares(int a, int b) {

        return (int)Math.floor(Math.sqrt(b)) - (int)Math.floor(Math.sqrt(a-1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int result = squares(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
