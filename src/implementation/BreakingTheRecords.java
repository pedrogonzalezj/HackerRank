package implementation;

import java.util.Scanner;

public class BreakingTheRecords {

    private static int[] breakingRecords(int[] score) {
        // Complete this function
        int highestCount = 0;
        int lowestCount = 0;
        int minScore = score[0];
        int maxScore = score[0];
        for(int i = 1; i < score.length; i++) {

            int actualScore = score[i];
            if(actualScore<minScore){

                minScore = actualScore;
                lowestCount = lowestCount + 1;
            }
            if(actualScore>maxScore) {

                maxScore = actualScore;
                highestCount = highestCount + 1;
            }
        }
        return new int[]{highestCount,lowestCount};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i = 0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
