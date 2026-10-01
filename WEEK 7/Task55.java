import java.util.*;

public class Task55 {
    public static void main(String[] args) {
        // Example 1
        int n1 = 2;
        int[][] trust1 = {{1,2}};
        System.out.println(findJudge(n1, trust1)); // Output: 2

        // Example 2
        int n2 = 3;
        int[][] trust2 = {{1,3},{2,3}};
        System.out.println(findJudge(n2, trust2)); // Output: 3

        // Example 3
        int n3 = 3;
        int[][] trust3 = {{1,3},{2,3},{3,1}};
        System.out.println(findJudge(n3, trust3)); // Output: -1
    }

    public static int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];

        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];
            outDegree[a]++;
            inDegree[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n-1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
