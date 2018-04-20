package implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StrangeCounter {

    private static final Scanner scanner = new Scanner(System.in);

    private static long strangeCounter(long t) {

        long value = 3;
        long timer = 1;
        long time = 1;
        while(value + time <= t) {
            timer = timer + 1;
            time  = value + time;
            value = (long)Math.pow(2,timer-1)*3;
        }
        return value - (t-time);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        long result = strangeCounter(t);

        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
