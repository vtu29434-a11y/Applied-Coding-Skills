import java.util.*;

public class FactoryTemperatureMonitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of readings: ");
        int n = sc.nextInt();

        double min = Double.MAX_VALUE;
        double max = -Double.MAX_VALUE;
        double sum = 0;

        System.out.println("Enter temperature readings:");
        for (int i = 0; i < n; i++) {
            double temperature = sc.nextDouble();
            min = Math.min(min, temperature);
            max = Math.max(max, temperature);
            sum += temperature;
        }

        double average = sum / n;

        System.out.printf("Minimum: %.2f%n", min);
        System.out.printf("Maximum: %.2f%n", max);
        System.out.printf("Average: %.2f%n", average);
    }
}
