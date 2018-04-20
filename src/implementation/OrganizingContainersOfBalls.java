package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class OrganizingContainersOfBalls {

    private static String organizingContainers(int[][] containers) {
        // Complete this function
        int[] typeCount = new int[containers.length];
        int[] sizes = new int[containers.length];
        for (int i = 0; i< containers.length; i++) {

            for (int j = 0; j < containers[i].length; j++) {

                typeCount[j] = typeCount[j] + containers[i][j];
                sizes[i] = sizes[i] + containers[i][j];
            }
        }
        Arrays.sort(typeCount);
        Arrays.sort(sizes);
        for (int i = 0; i<typeCount.length; i++) {

            if (typeCount[i]!=sizes[i]) {

                return "Impossible";
            }
        }
        return "Possible";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] container = new int[n][n];
            for(int container_i = 0; container_i < n; container_i++){
                for(int container_j = 0; container_j < n; container_j++){
                    container[container_i][container_j] = in.nextInt();
                }
            }
            String result = organizingContainers(container);
            System.out.println(result);
        }
        in.close();
    }
}
