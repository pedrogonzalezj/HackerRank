package implementation;


import java.util.Scanner;

public class DesignerPdfViewer {

    private static int designerPdfViewer(int[] h, String word) {
        // Complete this function
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int maxHeight = 0;
        for(int i = 0; i<word.length(); i++) {

            char letter = word.charAt(i);
            int pos = alphabet.indexOf(letter);
            int height = h[pos];
            if(height>maxHeight) {

                maxHeight = height;
            }
        }
        return word.length()*maxHeight;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i = 0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int result = designerPdfViewer(h, word);
        System.out.println(result);
        in.close();
    }
}
