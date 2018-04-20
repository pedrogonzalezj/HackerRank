package implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheTimeInWords {

    private static Map<Integer,String> numbers = new HashMap<>();

    static {
        numbers.put(0,"zero");
        numbers.put(1,"one");
        numbers.put(2,"two");
        numbers.put(3,"three");
        numbers.put(4,"four");
        numbers.put(5,"five");
        numbers.put(6,"six");
        numbers.put(7,"seven");
        numbers.put(8,"eight");
        numbers.put(9,"nine");
        numbers.put(10,"ten");
        numbers.put(11,"eleven");
        numbers.put(12,"twelve");
        numbers.put(13,"thirteen");
        numbers.put(14,"fourteen");
        numbers.put(15,"quarter");
        numbers.put(16,"sixteen");
        numbers.put(17,"seventeen");
        numbers.put(18,"eighteen");
        numbers.put(19,"nineteen");
        numbers.put(20,"twenty");
        numbers.put(21,"twenty one");
        numbers.put(22,"twenty two");
        numbers.put(23,"twenty three");
        numbers.put(24,"twenty four");
        numbers.put(25,"twenty five");
        numbers.put(26,"twenty six");
        numbers.put(27,"twenty seven");
        numbers.put(28,"twenty eight");
        numbers.put(29,"twenty nine");
        numbers.put(30,"half");
        numbers.put(45,"quarter");
    }
    private static String timeInWords(int h, int m) {
        // Complete this function
        String minutePart;
        if(m == 1) {

            minutePart = " minute";
        }
        else if(m%15==0) {

            minutePart = "";
        }
        else {

            minutePart = " minutes";
        }
        final String union = String.format("%s past ",minutePart);
        if(m == 0) {

            return numbers.get(h) + " o' clock";
        }
        else if(m <=30) {

            return numbers.get(m) + union + numbers.get(h);
        }
        else if(m==45) {

            return "quarter" + " to " + numbers.get(h+1);
        }
        else {

            return numbers.get(60-m) + " minutes to " + numbers.get(h+1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        String result = timeInWords(h, m);
        System.out.println(result);
        in.close();
    }

}
