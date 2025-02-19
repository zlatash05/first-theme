import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static int findMedian(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int[][] sequences = new int[n][l];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                sequences[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int[] combined = new int[2 * l];
            System.arraycopy(sequences[i], 0, combined, 0, l);
            System.arraycopy(sequences[i + 1], 0, combined, l, l);
            System.out.println(findMedian(combined));
        }
        scanner.close();
    }
}