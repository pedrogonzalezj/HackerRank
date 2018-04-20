package implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UtopianTree {

    private static Map<Integer,Integer> HEIGHTS = new HashMap<>();

    private static int utopianTree(int n) {
        // Complete this function
        if(HEIGHTS.get(n)!=null) {

            return HEIGHTS.get(n);
        }
        else {

            int maxStoredCycle = getMaxStoredCycle(n);
            int currentHeight = maxStoredCycle != 0 ? HEIGHTS.get(maxStoredCycle) : 1;
            for(int j = maxStoredCycle+1; j <=n;j++) {

                if(j%2!=0) {

                    currentHeight = 2*currentHeight;
                }
                else {

                    currentHeight = 1 + currentHeight;
                }
                HEIGHTS.put(j,currentHeight);
            }
            return currentHeight;
        }
    }

    private static int getMaxStoredCycle(int n) {

        for(int i = n; i >=0; i--) {

            if(HEIGHTS.get(i)!= null) {

                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = utopianTree(n);
            System.out.println(result);
        }
        in.close();
    }
}
