package implementation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ElectronicsShop {

    private static int getMoneySpent(Integer[] keyboards, Integer[] drives, int s){
        // Complete this function
        int actualCost = -1;
        Arrays.sort(keyboards);
        Arrays.sort(drives, Collections.reverseOrder());
        for(int i = 0, j = 0; i < drives.length; i ++) {
            for(; j < keyboards.length; j++) {

                int cost = keyboards[j] + drives[i];
                if(cost > s) {
                    break;
                }
                if(cost <= s && cost > actualCost) {

                    actualCost = cost;
                }

            }
        }
        return actualCost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        Integer[] keyboards = new Integer[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        Integer[] drives = new Integer[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}
