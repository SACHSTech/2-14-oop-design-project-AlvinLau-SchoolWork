import java.util.HashMap;
import java.util.Map;

public class Stock {
    private Map<Product, Integer> stockMap;

    public Stock() {
        stockMap = new HashMap<>();
    }

    public int getQuantity(Product product) {
        return stockMap.getOrDefault(product, 0);
    }

    public void setQuantity(Product product, int quantity) {
        stockMap.put(product, quantity);
    }

    public void increaseQuantity(Product product, int quantity) {
        int current = getQuantity(product);
        stockMap.put(product, current + quantity);
    }

    public boolean removeQuantity(Product product, int quantity) {
        int current = getQuantity(product);
        if (quantity > current) {
            return false;
        }
        stockMap.put(product, current - quantity);
        return true;
    }

    public void displayStock() {
        System.out.println("Current Stock:");
        for (Map.Entry<Product, Integer> entry : stockMap.entrySet()) {
            Product p = entry.getKey();
            System.out.printf("%s - %s ($%.2f)%n", p.getId(), p.getName(), p.getPrice());
        }
    }
}