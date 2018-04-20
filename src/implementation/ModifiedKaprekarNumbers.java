package implementation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModifiedKaprekarNumbers {

    private static Integer[] kaprekarNumbers(int p, int q) {
        // Complete this function
        final List<Integer> kaprekarNumbers = new ArrayList<>();
        for(int n = p; n<=q; n++) {

            if(n == 1) {

                kaprekarNumbers.add(1);
            }
            else if(isKaprekarNumber(BigInteger.valueOf(n))) {

                kaprekarNumbers.add(n);
            }
        }
        return kaprekarNumbers.toArray(new Integer[kaprekarNumbers.size()]);
    }

    private static boolean isKaprekarNumber(BigInteger n) {

        final int digits = n.toString().length();
        final BigInteger square = n.pow(2);
        final String squareDigits = square.toString();
        if(squareDigits.length()>1) {
            
            final int leftDigits = squareDigits.length() - digits;
            final BigInteger left = new BigInteger(squareDigits.substring(0, leftDigits));
            final BigInteger right = new BigInteger(squareDigits.substring(leftDigits, squareDigits.length()));
            return left.add(right).equals(n);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int q = in.nextInt();
        Integer[] result = kaprekarNumbers(p, q);
        if(result.length == 0) {

            System.out.println("INVALID RANGE");
        }
        else {

            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");
        }
        in.close();
    }
}
