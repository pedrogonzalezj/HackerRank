package implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class TaumAndBDay {

    private static BigInteger taumBday(BigInteger b, BigInteger w, BigInteger bc, BigInteger wc, BigInteger z) {

        BigInteger cost;
        if(bc.add(z).compareTo(wc)<0) {

            cost = b.multiply(bc).add(w.multiply(bc.add(z)));
        }
        else if(wc.add(z).compareTo(bc)<0) {

            cost = w.multiply(wc).add(b.multiply(wc.add(z)));
        }
        else {

            cost = w.multiply(wc).add(b.multiply(bc));
        }
        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] bw = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            BigInteger b = BigInteger.valueOf(Integer.parseInt(bw[0]));

            BigInteger w = BigInteger.valueOf(Integer.parseInt(bw[1]));

            String[] bcWcz = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            
            BigInteger bc = BigInteger.valueOf(Integer.parseInt(bcWcz[0]));

            BigInteger wc = BigInteger.valueOf(Integer.parseInt(bcWcz[1]));

            BigInteger z = BigInteger.valueOf(Integer.parseInt(bcWcz[2]));

            BigInteger result = taumBday(b, w, bc, wc, z);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
