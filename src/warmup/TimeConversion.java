package warmup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeConversion {

    private static String timeConversion(String s) {
        // Complete this function
        SimpleDateFormat inDf = new SimpleDateFormat("hh:mm:ssaa");
        SimpleDateFormat outDf = new SimpleDateFormat("HH:mm:ss");
        try {

            final Date date = inDf.parse(s);
            return outDf.format(date);
        }
        catch (ParseException pex) {

            return "";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
