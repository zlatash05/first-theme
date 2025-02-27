
import java.util.*;

public class Goblins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine().trim();
            if (line.startsWith("+")) {
                int id = Integer.parseInt(line.substring(1).trim());
                queue.addLast(id);
            } else if (line.startsWith("*")) {
                int id = Integer.parseInt(line.substring(1).trim());
                int middle = queue.size() / 2;
                queue.add(middle, id);
            } else if (line.equals("-")) {
                System.out.println(queue.removeFirst());
            }
        }
    }
}

