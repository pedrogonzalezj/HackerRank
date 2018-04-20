package implementation;

import java.util.Scanner;

public class RepeatedString {

    private static final String BASECTX = "a";

    private static long repeatedString(String s, long n) {
        // Complete this function
        final long iterations = n/s.length();
        long baseCount = countChar(BASECTX,s);
        long added = 0;
        final int pendingCharsCount = Long.valueOf(n - s.length()*iterations).intValue();
        if(pendingCharsCount>0) {

            final String pendingChars = s.substring(0,pendingCharsCount);
            added = countChar(BASECTX,pendingChars);
        }
        return baseCount*iterations + added;
    }

    private static long countChar(String ctx, String str) {
        int count = 0;
        int idx   = str.indexOf(ctx);
        while(idx != -1) {

            count = count + 1;
            idx = str.indexOf(ctx,idx+1);
        }
        return count;
    }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            long n = in.nextLong();
            long result = repeatedString(s, n);
            System.out.println(result);
            in.close();
        }
}
