package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BiggerIsGreater {

    private static String biggerIsGreater(String w) {
        // Complete this function
        char[] word = w.toCharArray();
        int i = word.length-1;
        for(; i>0; i--) {

            if(word[i]>word[i-1]) {

                break;
            }
        }
        if(i>0) {
            
            char pivot = word[i - 1];
            //
            char[] suffix = Arrays.copyOfRange(word, i, word.length);
            int j = suffix.length - 1;
            for (; j >= 0; j--) {

                if (suffix[j] > pivot) {

                    break;
                }
            }
            word[i - 1] = word[i+j];
            word[i+j] = pivot;
            Arrays.sort(word,i,word.length);
        }
        else {

            return "no answer";
        }
        return String.valueOf(word);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            String w = in.next();
            String result = biggerIsGreater(w);
            System.out.println(result);
        }
        in.close();
    }
}
