import java.util.Scanner;

public class SquareRoom {

    static int n;
    static char[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();

        maze = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            maze[i] = scanner.nextLine().toCharArray();
        }

        int startRow = scanner.nextInt() - 1;
        int startCol = scanner.nextInt() - 1;

        if (maze[startRow][startCol] == '*') {
            System.out.println(0);
        } else {
            int roomSize = dfs(startRow, startCol);
            System.out.println(roomSize);
        }
        scanner.close();
    }

    static int dfs(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n || maze[row][col] == '*' || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int size = 1;
        size += dfs(row + 1, col);
        size += dfs(row - 1, col);
        size += dfs(row, col + 1);
        size += dfs(row, col - 1);
        return size;
    }
}

