package implementation;

import java.util.Scanner;
import java.util.Vector;

public class AlmostSorted {

    private static String almostSorted(int[] arr) {
        // Complete this function
        Vector<Integer> faulties;
        if(arr.length == 1) {

            return "yes";
        }
        try {

            faulties = findBadElements(arr);
        }
        catch (UnsolvableArrayException unarrex) {

            return "no";
        }
        if(faulties.size() == 0) {

            return "yes";
        }
        else if(faulties.size() == 1) {

            return "no";
        }
        else {

            return canBeReversedOrSwapped(arr,faulties);
        }
    }

    private static String canBeReversedOrSwapped(int[] arr, Vector<Integer> wrongElements) {

        final int firstIdx    = wrongElements.firstElement();
        final int secondIdx   = wrongElements.lastElement();
        final int firstIdxFormatted = firstIdx+1;
        final int secondIdxFormatted = secondIdx+1;
        final boolean swapSecondValue = (firstIdx >0 && arr[secondIdx] > arr[firstIdx-1]) || firstIdx == 0;
        final boolean swapFirstValue = (secondIdx <arr.length-1 && arr[firstIdx] < arr[secondIdx+1]) || secondIdx == arr.length-1;
        if(swapSecondValue && swapFirstValue && wrongElements.size() <=3) {

            return "yes\nswap " + firstIdxFormatted + " " + secondIdxFormatted;
        }
        else if(wrongElements.size() > 2 && swapSecondValue && swapFirstValue) {


            return "yes\nreverse " + firstIdxFormatted + " " + secondIdxFormatted;
        }
        return "no";
    }

    private static Vector<Integer> findBadElements(int[] arr) throws UnsolvableArrayException {

        final Vector<Integer> faulties = new Vector<>();
        for(int i = 0; i<arr.length; i++) {
            if(faulties.size()==0 && i<=arr.length-2 && arr[i]>arr[i+1]) {

                faulties.add(i);
            }
            else if(faulties.size()>0 &&
                    arr[i]<arr[i-1] &&
                    (i == arr.length-1 || arr[i]>arr[i+1] || arr[faulties.firstElement()] < arr[i+1])) {

                if(canBeAddedToVectorOfFaulties(faulties,arr,i)) {

                    faulties.add(i);
                }
                else {

                    throw new UnsolvableArrayException();
                }
            }
        }
        return faulties;
    }

    private static boolean canBeAddedToVectorOfFaulties(Vector<Integer> faulties, int[] arr, int idx) {

        if(faulties.size()>1) {

            return arr[faulties.lastElement()]>arr[idx] && faulties.lastElement() == idx-1;
        }
        else {

            return arr[faulties.lastElement()]>arr[idx];
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++) {

            arr[arr_i] = in.nextInt();
        }
        System.out.println(almostSorted(arr));
        in.close();
    }
}

class UnsolvableArrayException extends RuntimeException  {}
