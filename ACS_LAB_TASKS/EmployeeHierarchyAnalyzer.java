import java.util.*;

public class EmployeeHierarchyAnalyzer {
    static class Employee {
        String name;
        List<Employee> children = new ArrayList<>();

        Employee(String name) {
            this.name = name;
        }
    }

    static int countEmployees(Employee root) {
        if (root == null) return 0;
        int count = 1;
        for (Employee child : root.children) {
            count += countEmployees(child);
        }
        return count;
    }

    static int maxDepth(Employee root) {
        if (root == null) return 0;
        int depth = 1;
        for (Employee child : root.children) {
            depth = Math.max(depth, 1 + maxDepth(child));
        }
        return depth;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, Employee> employees = new LinkedHashMap<>();
        Set<String> subordinates = new HashSet<>();

        System.out.println("Enter each employee as: employee manager");
        System.out.println("Use NONE for the top-level manager.");

        String[] managers = new String[n];
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            managers[i] = sc.next();
            employees.put(names[i], new Employee(names[i]));
        }

        Employee root = null;

        for (int i = 0; i < n; i++) {
            if (managers[i].equalsIgnoreCase("NONE")) {
                root = employees.get(names[i]);
            } else {
                Employee manager = employees.get(managers[i]);
                if (manager != null) {
                    manager.children.add(employees.get(names[i]));
                    subordinates.add(names[i]);
                }
            }
        }

        if (root == null) {
            System.out.println("No top-level manager found.");
            return;
        }

        System.out.println("Top-level manager: " + root.name);
        System.out.println("Total employees: " + countEmployees(root));
        System.out.println("Hierarchy depth: " + maxDepth(root));
    }
}
