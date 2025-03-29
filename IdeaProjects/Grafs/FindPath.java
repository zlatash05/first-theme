
import java.util.ArrayList;

public class FindPath
{
    public boolean validPath(int n, int[][] edges, int source, int destination)
    {
        var matrix = new ArrayList<ArrayList<Integer>>();
        for(var i = 0; i < n; i++)
            matrix.add(new ArrayList<Integer>());

        for(var edge : edges)
        {
            matrix.get(edge[0]).add(edge[1]);
            matrix.get(edge[1]).add(edge[0]);
        }
        var visited = new boolean[n];

        return DFS(source, destination, matrix, visited);
    }

    public boolean DFS(
            int current,
            int destination,
            ArrayList<ArrayList<Integer>> matrix,
            boolean[] visited)
    {
        if(current == destination)
            return true;

        visited[current] = true;

        for(var vertex : matrix.get(current))
            if(!visited[vertex])
                if(DFS(vertex, destination, matrix, visited))
                    return true;

        return false;
    }
}