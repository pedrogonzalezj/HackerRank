package implementation;

import java.util.Scanner;

public class ACMTeam {

    private static int[] acmTeam(String[] topics) {
        // Complete this function
        int[] winners = {0,0};
        for(int i = 0; i < topics.length; i++) {

            final String a = topics[i];
            for(int j = i+1;j<topics.length;j++) {

                final String b = topics[j];
                int max = maxTopics(a,b);
                if(max > winners[0]) {

                    winners[0] = max;
                    winners[1] = 1;
                }
                else if(max == winners[0]) {

                    winners[1] = winners[1] + 1;
                }
            }
        }
        return winners;
    }

    private static int maxTopics(String a, String b) {

        int sum = 0;
        for(int i = 0; i<a.length(); i++) {

            int knowTopicA = Character.getNumericValue(a.charAt(i));
            int knowTopicB = Character.getNumericValue(b.charAt(i));
            if(knowTopicA == 1 || knowTopicB == 1) {

                sum = sum + 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] topic = new String[n];
        for(int topic_i = 0; topic_i < n; topic_i++){
            topic[topic_i] = in.next();
        }
        int[] result = acmTeam(topic);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
