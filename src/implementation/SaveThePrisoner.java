package implementation;

import java.util.Scanner;

public class SaveThePrisoner {

    private static int saveThePrisoner(int n, int m, int s){
        // Complete this function
        int advance = s + m - 1;
        if(advance > n) {

            if(advance%n == 0) {

                return n;
            }
            return advance%n;
        }
        return advance;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int result = saveThePrisoner(n, m, s);
            System.out.println(result);
        }
    }
}
