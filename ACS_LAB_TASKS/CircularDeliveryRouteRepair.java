import java.util.*;

public class CircularDeliveryRouteRepair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of locations: ");
        int n = sc.nextInt();

        int[] route = new int[n];
        System.out.println("Enter route location IDs:");
        for (int i = 0; i < n; i++) {
            route[i] = sc.nextInt();
        }

        // Find a break in the circular route where the sequence decreases.
        int breakIndex = -1;
        for (int i = 0; i < n; i++) {
            int next = route[(i + 1) % n];
            if (route[i] > next) {
                if (breakIndex != -1) {
                    System.out.println("Route cannot be repaired as one sorted circular route.");
                    return;
                }
                breakIndex = i;
            }
        }

        if (breakIndex == -1) {
            System.out.println("Route is already circularly sorted.");
        } else {
            System.out.println("Repair by starting the route at index "
                    + ((breakIndex + 1) % n) + ".");
            System.out.println("Repaired route:");

            for (int i = 1; i <= n; i++) {
                System.out.print(route[(breakIndex + i) % n] + " ");
            }
            System.out.println();
        }
    }
}
