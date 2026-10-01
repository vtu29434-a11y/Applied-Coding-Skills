import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(Arrays.asList(1));
        rooms1.add(Arrays.asList(2));
        rooms1.add(Arrays.asList(3));
        rooms1.add(Arrays.asList());
        System.out.println(canVisitAllRooms(rooms1)); // Output: true

        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1,3));
        rooms2.add(Arrays.asList(3,0,1));
        rooms2.add(Arrays.asList(2));
        rooms2.add(Arrays.asList(0));
        System.out.println(canVisitAllRooms(rooms2)); // Output: false
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private static void dfs(List<List<Integer>> rooms, boolean[] visited, int room) {
        if (visited[room]) return;
        visited[room] = true;

        for (int key : rooms.get(room)) {
            dfs(rooms, visited, key);
        }
    }
}
