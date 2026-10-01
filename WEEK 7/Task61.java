import java.util.*;

public class Task61 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        System.out.println(Arrays.toString(sol.findOrder(numCourses1, prerequisites1))); 
        // Output: [0,1]

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(sol.findOrder(numCourses2, prerequisites2))); 
        // Output: [0,1,2,3] or [0,2,1,3]

        int numCourses3 = 1;
        int[][] prerequisites3 = {};
        System.out.println(Arrays.toString(sol.findOrder(numCourses3, prerequisites3))); 
        // Output: [0]
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Build graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Queue for courses with no prerequisites
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            order[idx++] = cur;
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) q.offer(next);
            }
        }

        return idx == numCourses ? order : new int[0];
    }
}
