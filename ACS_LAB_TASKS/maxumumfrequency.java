import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int productId = scanner.nextInt();
            frequency.put(productId, frequency.getOrDefault(productId, 0) + 1);
        }

        int mostFrequentId = Integer.MAX_VALUE;
        int maximumFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int productId = entry.getKey();
            int count = entry.getValue();

            if (count > maximumFrequency
                    || (count == maximumFrequency && productId < mostFrequentId)) {
                maximumFrequency = count;
                mostFrequentId = productId;
            }
        }

        System.out.println(mostFrequentId + " " + maximumFrequency);
        scanner.close();
    }
}