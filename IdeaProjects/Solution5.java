import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] n = s.nextLine().split(" ");
        int[] a = new int[n.length];
        if (n.length < 3) {
            System.out.println("Недостаточно чисел");
            return;
        }

        for (int i = 0; i < n.length; i++) a[i] = Integer.parseInt(n[i]);
        Arrays.sort(a);
        long p1 = (long) a[a.length - 1] * a[a.length - 2] * a[a.length - 3];
        long p2 = (long) a[0] * a[1] * a[a.length - 1];
        if (p1 > p2) {
            System.out.println(a[a.length - 1] + " " + a[a.length - 2] + " " + a[a.length - 3]);
        } else {
            System.out.println(a[0] + " " + a[1] + " " + a[a.length - 1]);
        }
    }
}

