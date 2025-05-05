import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> customerPurchases = new TreeMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            if (parts.length != 3) {
                continue;
            }

            String customer = parts[0];
            String product = parts[1];
            long quantity;

            try {
                quantity = Long.parseLong(parts[2]);
            } catch (NumberFormatException e) {
                continue;
            }

            customerPurchases.putIfAbsent(customer, new TreeMap<>());
            Map<String, Long> products = customerPurchases.get(customer);
            products.merge(product, quantity, Long::sum);
        }

        for (Map.Entry<String, Map<String, Long>> entry : customerPurchases.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, Long> product : entry.getValue().entrySet()) {
                System.out.println(product.getKey() + " " + product.getValue());
            }
        }
    }
}