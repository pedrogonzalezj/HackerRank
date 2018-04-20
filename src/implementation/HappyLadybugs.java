package implementation;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HappyLadybugs {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String EMPTY_PLACE = "_";

    /*
     * Complete the happyLadybugs function below.
     */
    private static String happyLadybugs(String b) {

        String ladybugs = b.replaceAll(EMPTY_PLACE,"");
        boolean isThereAnEmptyCell = b.contains(EMPTY_PLACE);
        long freeLadybugs = ladybugs.chars()
                .mapToObj(c -> String.valueOf((char)c))
                .collect(Collectors.groupingBy(k->k,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .count();
        if(isThereAnEmptyCell && freeLadybugs == 0) {

            return "YES";
        }
        else {

            char[] board = b.toCharArray();
            return isAlreadyHappy(board[0],1,1,board) ? "YES" : "NO";
        }
    }

    private static boolean isAlreadyHappy(char prev, int idx, int count, char[] board) {

        if(board.length == 1) {

            return false;
        }
        if(idx == board.length) {

            return count>1;
        }
        if(prev != board[idx]) {

            return count != 1 && isAlreadyHappy(board[idx], idx + 1, 1, board);
        }
        else {

            count = count + 1;
            return isAlreadyHappy(board[idx],idx+1,count+1, board);
        }
    }
    
    public static void main(String[] args) throws IOException {

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            System.out.println(result);
        }
    }
}
