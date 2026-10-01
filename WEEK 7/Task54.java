import java.util.*;

public class Task54 {
    public static void main(String[] args) {
        // Example 1
        int n1 = 3;
        int[][] edges1 = {{0,1},{1,2},{2,0}};
        int source1 = 0, destination1 = 2;
        System.out.println(validPath(n1, edges1, source1, destination1)); // true

        // Example 2
        int n2 = 6;
        int[][] edges2 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int source2 = 0, destination2 = 5;
        System.out.println(validPath(n2, edges2, source2, destination2)); // false
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // BFS traversal
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) return true;

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
