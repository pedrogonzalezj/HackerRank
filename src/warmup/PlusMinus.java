package warmup;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class PlusMinus {

    private static void plusMinus(int[] arr) {
        // Complete this function
        final BigDecimal denom = BigDecimal.valueOf(arr.length);
        System.out.println(BigDecimal.valueOf(Arrays.stream(arr).filter(n -> n > 0).count()).divide(denom, new MathContext(6, RoundingMode.HALF_EVEN)));
        System.out.println(BigDecimal.valueOf(Arrays.stream(arr).filter(n -> n < 0).count()).divide(denom, new MathContext(6, RoundingMode.HALF_EVEN)));
        System.out.println(BigDecimal.valueOf(Arrays.stream(arr).filter(n -> n == 0).count()).divide(denom, new MathContext(6, RoundingMode.HALF_EVEN)));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}
