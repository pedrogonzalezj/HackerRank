package implementation;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExtraLongFactorials {

    private static Map<Integer,BigInteger> factorials = new HashMap<>();

    static {

        factorials.put(0,BigInteger.ONE);
    }

    private static void extraLongFactorials(int n) {
        // Complete this function
        System.out.println(factorial(n));
    }

    private static BigInteger factorial(int n) {

        if(factorials.get(n)!=null) {

            return factorials.get(n);
        }
        else {

            BigInteger fact = BigInteger.valueOf(n).multiply(factorial(n-1));
            factorials.put(n,fact);
            return fact;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        extraLongFactorials(n);
        in.close();
    }
}
