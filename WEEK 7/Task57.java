import java.util.*;

public class Task57 {
    public static void main(String[] args) {
        int[][] isConnected1 = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected1)); // Output: 2

        int[][] isConnected2 = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected2)); // Output: 3
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
}
