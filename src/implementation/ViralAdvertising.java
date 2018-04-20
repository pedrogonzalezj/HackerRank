package implementation;

import java.util.Scanner;

public class ViralAdvertising {

    private static int viralAdvertising(int n) {
        // Complete this function
        int people = 5;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            people = (int) Math.floor(people/2);
            sum = sum + people;
            people = 3*people;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = viralAdvertising(n);
        System.out.println(result);
        in.close();
    }
}
