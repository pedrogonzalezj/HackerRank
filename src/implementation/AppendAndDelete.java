package implementation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AppendAndDelete {

    private static String appendAndDelete(String s, String t, int k) {
        // Complete this function
        if(s.equals(t)) {

            return "Yes";
        }
        else if(k - s.length() - t.length()>=0) {

            return "Yes";
        }
        else if(t.length()>=s.length()) {

            return canGrow(s,t,k);
        }
        else {

            return canReduce(s,t,k);
        }
    }

    private static String canGrow(String s, String t, int k) {

        int removals;
        int r = (int)Math.floor(k/2);
        int minLenght = s.length() - r > 0 ? s.length() - r : 0;
        for (int i = minLenght; i <= s.length(); i++) {

            String test = s.substring(0, i);
            removals = s.length()-test.length();
            Pattern pattern = Pattern.compile("^" + test + ".*");
            if (pattern.matcher(t).matches()
                    &&
                    k>=removals
                    &&
                    k-removals==t.length()-test.length()) {

                return "Yes";
            }
        }
        return "No";
    }

    private static String canReduce(String s, String t, int k) {

        int removals;
        for (int i = 0; i <= s.length(); i++) {

            String test = s.substring(0, i);
            removals = s.length() - test.length();
            Pattern pattern = Pattern.compile("^" + test + ".*");
            if (pattern.matcher(t).matches() &&
                    k >= removals &&
                    k - removals >= t.length() - test.length()) {

                return "Yes";
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        String result = appendAndDelete(s, t, k);
        System.out.println(result);
        in.close();
    }
}
