import java.util.*;

public class ServerRequestValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of requests: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter requests in the format: METHOD PATH");
        System.out.println("Allowed methods: GET, POST, PUT, DELETE");

        Set<String> methods = new HashSet<>(
                Arrays.asList("GET", "POST", "PUT", "DELETE"));

        for (int i = 1; i <= n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");

            boolean valid = parts.length == 2
                    && methods.contains(parts[0])
                    && parts[1].startsWith("/")
                    && !parts[1].contains(" ");

            System.out.println("Request " + i + ": "
                    + (valid ? "VALID" : "INVALID"));
        }
    }
}
