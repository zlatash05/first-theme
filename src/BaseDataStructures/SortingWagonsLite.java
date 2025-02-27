import java.util.*;

public class Wagons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] wagons = new int[N];
        for (int i = 0; i < N; i++) {
            wagons[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int expected = 1;
        boolean possible = true;

        for (int wagon : wagons) {
            stack.push(wagon);
            while (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}