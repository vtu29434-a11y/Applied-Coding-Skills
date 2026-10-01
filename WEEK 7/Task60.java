import java.util.*;

public class Main {
    public static void main(String[] args) {
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        System.out.println(canFinish(numCourses1, prerequisites1)); 
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1,0},{0,1}};
        System.out.println(canFinish(numCourses2, prerequisites2));     }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) q.offer(next);
            }
        }

        return count == numCourses;
    }
}
