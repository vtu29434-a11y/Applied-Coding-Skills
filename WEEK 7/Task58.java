import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] grid1 = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid1)); // Output: 6

        int[][] grid2 = {{0,0,0,0,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid2)); // Output: 0
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length 
            || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        int area = 1;

        area += dfs(grid, visited, i+1, j);
        area += dfs(grid, visited, i-1, j);
        area += dfs(grid, visited, i, j+1);
        area += dfs(grid, visited, i, j-1);

        return area;
    }
}
