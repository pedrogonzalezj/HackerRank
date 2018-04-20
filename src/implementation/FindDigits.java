package implementation;

import java.util.Scanner;

public class FindDigits {

    private static int findDigits(int n) {
        // Complete this function
        int count = 0;
        final String number = Integer.valueOf(n).toString();
        for(int i = 0; i<number.length(); i++) {

            int test = Character.getNumericValue(number.charAt(i));
            if(test != 0 && n%test==0) {

                count = count+1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = findDigits(n);
            System.out.println(result);
        }
        in.close();
    }
}
