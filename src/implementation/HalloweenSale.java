package implementation;

import java.util.Scanner;

public class HalloweenSale {

    private static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        return s>=p?1+buyGame(p,d,m,s-p):0;
    }

    private static int buyGame(int previousPrice, int discount, int minimum, int cash) {

        int gamesBought = 0;
        int checkPrice = previousPrice-discount;
        int cost = checkPrice>minimum?checkPrice:minimum;
        if(cost<=cash) {

            gamesBought = 1 + gamesBought + buyGame(cost,discount,minimum,cash-cost);
        }
        return gamesBought;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int d = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int answer = howManyGames(p, d, m, s);
        System.out.println(answer);
        in.close();
    }
}
