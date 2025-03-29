import java.util.*;

public class SearchCycle {

    static int n;
    static int[][] adjMatrix;
    static boolean[] visited;
    static boolean[] recursionStack;
    static List<Integer> cycle;
    static int cycleStart = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        adjMatrix = new int[n][n];
        visited = new boolean[n];
        recursionStack = new boolean[n];
        cycle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, new ArrayList<>());
                if (cycleStart != -1) break; // Если цикл найден, прерываем поиск
            }
        }

        if (cycleStart == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(cycle.size());
            for (int i = 0; i < cycle.size(); i++) {
                System.out.print(cycle.get(i) + (i == cycle.size() - 1 ? "" : " "));
            }
            System.out.println();
        }

        scanner.close();
    }

    static boolean dfs(int u, int parent, List<Integer> path) {
        visited[u] = true;
        recursionStack[u] = true;
        path.add(u + 1);

        for (int v = 0; v < n; v++) {
            if (adjMatrix[u][v] == 1) {
                if (!visited[v]) {
                    if (dfs(v, u, path)) return true;
                } else if (v != parent && recursionStack[v]) {
                    cycleStart = v;
                    int index = path.indexOf(v + 1);
                    cycle.addAll(path.subList(index, path.size()));

                    return true;
                }
            }
        }

        recursionStack[u] = false;
        path.remove(path.size() - 1);
        return false;
    }
}


