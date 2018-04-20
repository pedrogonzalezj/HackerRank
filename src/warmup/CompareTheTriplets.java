package warmup;

import java.util.Scanner;

public class CompareTheTriplets {

    public static void main(String[] args) {

        try(Scanner in = new Scanner(System.in)) {
            int a0 = in.nextInt();
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            int b0 = in.nextInt();
            int b1 = in.nextInt();
            int b2 = in.nextInt();
            Rating aRating = new Rating(a0,a1,a2);
            Rating bRating = new Rating(b0,b1,b2);
            int[] ratings  = aRating.compare(bRating);
            System.out.println(ratings[0] + " " + ratings[1]);
        }
    }
}

class Rating {

    private int a0;
    private int a1;
    private int a2;

    Rating(int a0, int a1, int a2) {

        this.a0 = a0;
        this.a1 = a1;
        this.a2 = a2;
    }

    int[] compare(Rating b) {

        int[] scores = new int[2];
        if (a0 > b.getA0()) {

            scores[0] = scores[0] + 1;
        } else if (b.getA0() > a0) {

            scores[1] = scores[1] + 1;
        }
        if (a1 > b.getA1()) {

            scores[0] = scores[0] + 1;
        } else if (b.getA1() > a1) {

            scores[1] = scores[1] + 1;
        }
        if (a2 > b.getA2()) {

            scores[0] = scores[0] + 1;
        } else if (b.getA2() > a2) {

            scores[1] = scores[1] + 1;
        }
        return scores;
    }

    public int getA0() {

        return a0;
    }

    private int getA1() {

        return a1;
    }

    private int getA2() {

        return a2;
    }
}



