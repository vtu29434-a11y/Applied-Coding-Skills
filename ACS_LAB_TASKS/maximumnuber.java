import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] vehicles = new int[n];

        for (int i = 0; i < n; i++) {
            vehicles[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += vehicles[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < n; i++) {
            windowSum += vehicles[i] - vehicles[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println(maxSum);
        scanner.close();
    }
}