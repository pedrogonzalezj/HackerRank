package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BonApetit {

    private static int amountToRefund(int[] itemsPrices, int[] declinedItems, int sharedAmount) {
        //set to 0 all the declinedItems
        for(Integer item: declinedItems) {

            itemsPrices[item] = 0;
        }
        return sharedAmount - Arrays.stream(itemsPrices).sum()/2;
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        final Scanner in = new Scanner(System.in);
        String[] firstLine = in.nextLine().split(" ");
        final int[] declinedItems = parseDeclinedItems(firstLine);
        final int[] itemsPrices = parseItemsPrices(in.nextLine().split(" "));
        final Integer sharedAmount = Integer.valueOf(in.nextLine());
        final int toRefund = amountToRefund(itemsPrices,declinedItems,sharedAmount);
        System.out.println(toRefund > 0 ? toRefund : "Bon Appetit");
    }

    private static int[] parseDeclinedItems(String[] line) {

        String[] tmp = Arrays.copyOfRange(line,1,line.length);
        return tmp.length>0 ? Arrays.stream(tmp).mapToInt(Integer::valueOf).toArray() : new int[]{};
    }

    private static int[] parseItemsPrices(String[] line) {

        return Arrays.stream(line).mapToInt(Integer::valueOf).toArray();
    }
}
