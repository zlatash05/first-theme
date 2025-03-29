import java.util.*;

public class ShortestPath {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        int start = scanner.nextInt() - 1;
        int end = scanner.nextInt() - 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        dist[start] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < n; v++) {
                if (adjMatrix[u][v] == 1 && dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    prev[v] = u;
                    queue.add(v);
                }
            }
        }

        if (dist[end] == -1) {
            System.out.println("-1");
        } else {
            System.out.println(dist[end]);

            if (dist[end] > 0) {
                List<Integer> path = new ArrayList<>();
                int current = end;
                while (current != -1) {
                    path.add(current + 1);
                    current = prev[current];
                }
                Collections.reverse(path);

                for (int i = 0; i < path.size(); i++) {
                    System.out.print(path.get(i) + (i == path.size() - 1 ? "" : " "));
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }

        scanner.close();
    }
}

