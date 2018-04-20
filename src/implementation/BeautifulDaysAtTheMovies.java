package implementation;

import java.util.Scanner;

public class BeautifulDaysAtTheMovies {

    private static int beautifulDays(int i, int j, int k) {
        // Complete this function
        int count = 0;
        for(int n = i; n <=j; n++) {

            int reversed = reverse(n);
            if(Math.abs(n - reversed)%k == 0) {

                count = count + 1;
            }
        }
        return count;
    }

    private static int reverse(int number) {
       String toReverse = Integer.toString(number);
       StringBuilder reversed = new StringBuilder();
       for(int i = toReverse.length()-1; i>=0;i--) {

           reversed.append(toReverse.charAt(i));
       }
       return Integer.valueOf(reversed.toString());
   }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int result = beautifulDays(i, j, k);
        System.out.println(result);
        in.close();
    }
}
