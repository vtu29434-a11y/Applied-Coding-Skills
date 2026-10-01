import java.util.*;

public class Task56 {
    public static void main(String[] args) {
        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid1)); 

        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(orangesRotting(grid2));

        int[][] grid3 = {{0,2}};
        System.out.println(orangesRotting(grid3)); 
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

              for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int minutes = -1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};


        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
