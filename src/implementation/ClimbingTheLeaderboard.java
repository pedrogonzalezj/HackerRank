package implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbingTheLeaderboard {

    private static final Scanner scanner = new Scanner(System.in);

    private static int[] climbingLeaderboard(int[] scores, int[] alice) {
        /*
         * Write your code here.
         */
        int j = alice.length-1;
        int[] aliceRanks = new int[alice.length];
        int[] filteredScores = Arrays.stream(scores).distinct().toArray();
        for(int i = 0;i<filteredScores.length;i++) {

            for(;j>=0;j--) {

                if(alice[j]>=filteredScores[i]) {

                    aliceRanks[j] = i+1;
                }
                else if(alice[j]<filteredScores[i]) {

                    break;
                }
            }
        }
        if(j>=0) {

            for(; j>=0; j--) {

                aliceRanks[j] = filteredScores.length+1;
            }
        }
        return aliceRanks;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = Integer.parseInt(scanner.nextLine().trim());

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");

        for (int scoresItr = 0; scoresItr < scoresCount; scoresItr++) {
            int scoresItem = Integer.parseInt(scoresItems[scoresItr].trim());
            scores[scoresItr] = scoresItem;
        }

        int aliceCount = Integer.parseInt(scanner.nextLine().trim());

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");

        for (int aliceItr = 0; aliceItr < aliceCount; aliceItr++) {
            int aliceItem = Integer.parseInt(aliceItems[aliceItr].trim());
            alice[aliceItr] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {

            System.out.println(result[resultItr]);
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

