package implementation;

import java.util.Scanner;

public class LisaWorkbook {

    private static int workbook(int k, int[] arr) {
        // Complete this function
        int specialProblemsCount = 0;
        int page = 0;
        for (final int anArr : arr) {

            int chapterFullPages = (int) Math.floor(anArr / k);
            int lastIndex = 0;
            for (int j = 0; j < chapterFullPages; j++) {

                page = page + 1;
                if (isPageNumberBetweenIndexes(lastIndex+1, lastIndex+k, page)) {

                    specialProblemsCount = specialProblemsCount + 1;
                }
                lastIndex = lastIndex+k;
            }
            int lastPageProblems = anArr % k;
            if (lastPageProblems > 0) {

                page = page+1;

                if (isPageNumberBetweenIndexes(lastIndex+1, lastIndex + lastPageProblems, page)) {

                    specialProblemsCount = specialProblemsCount + 1;
                }

            }
        }
        return specialProblemsCount;
    }

    private static boolean isPageNumberBetweenIndexes(int startIdx, int endIdx, int page) {

        return page >= startIdx && page <= endIdx;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = workbook(k, arr);
        System.out.println(result);
        in.close();
    }
}
