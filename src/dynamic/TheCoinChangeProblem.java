package dynamic;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheCoinChangeProblem {

    private static Map<CoinChangeCacheKey,Long> WAYS_CACHE = new HashMap<>();

    private static long getWays(long amount, Long[] c) {

        long ways = 0;
        if(amount == 0) {

            return 1;
        }
        if(c.length == 0) {

            return 0;
        }
        else if(c.length == 1) {

            return amount%c[0]==0?1:0;
        }
        else {

            final long coin = c[0];
            final Long[] restOfCoins = Arrays.copyOfRange(c, 1, c.length);
            for (int i = 0; i <= amount / coin; i++) {

                final long newAmount = amount - i * coin;
                final CoinChangeCacheKey key = CoinChangeCacheKey.of(newAmount,restOfCoins);
                final long toAdd = WAYS_CACHE.computeIfAbsent(key,k-> getWays(newAmount, restOfCoins));
                ways = ways + toAdd;
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Long[] c = new Long[m];
        for(int c_i=0; c_i < m; c_i++) {
            c[c_i] = in.nextLong();
        }
        //sort descending order
        Arrays.sort(c,Collections.reverseOrder());
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}

class CoinChangeCacheKey {

    private long amount;

    private Long[] coins;

    private CoinChangeCacheKey(long amount, Long[] coins) {

        this.amount = amount;
        this.coins = coins;
    }

    static CoinChangeCacheKey of(long amount, Long[] coins) {

        return new CoinChangeCacheKey(amount,coins);
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CoinChangeCacheKey)) {
            return false;
        }
        CoinChangeCacheKey other = (CoinChangeCacheKey) obj;
        return amount == other.amount && Arrays.equals(coins,other.coins);
    }

    @Override
    public int hashCode() {
        return (int)amount + Arrays.hashCode(coins);
    }
}
