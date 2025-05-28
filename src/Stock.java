import java.util.HashMap;
import java.util.Map;

public class Stock {
    private Map<String, Integer> stockMap;

    public Stock() {
        stockMap = new HashMap<>();
    }

    public int getQuantity(String productId) {
        return stockMap.getOrDefault(productId, 0);
    }

    public void setQuantity(String productId, int quantity) {
        stockMap.put(productId, quantity);
    }

    public void increaseQuantity(String productId, int quantity) {
        int current = getQuantity(productId);
        stockMap.put(productId, current + quantity);
    }

    public boolean removeQuantity(String productId, int quantity) {
        int current = getQuantity(productId);
        if (quantity > current) {
            return false;
        }
        stockMap.put(productId, current - quantity);
        return true;
    }

    public void displayStock() {
        System.out.println("Current Stock:");
        for (Map.Entry<String, Integer> entry : stockMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " units");
        }
    }

}
