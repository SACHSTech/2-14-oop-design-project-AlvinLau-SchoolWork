package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages the inventory of products in the store.
 * Uses a map to track the available quantity for each Product.
 */
public class Stock {
    private Map<Product, Integer> stockMap;

    /**
     * Initializes an empty stock inventory.
     */
    public Stock() {
        stockMap = new HashMap<>();
    }

    /**
     * Retrieves the current stock quantity for the specified product.
     * 
     * @param product the product to query
     * @return available quantity (0 if not present)
     */
    public int getQuantity(Product product) {
        return stockMap.getOrDefault(product, 0);
    }

    /**
     * Sets the stock quantity for a given product.
     * 
     * @param product  the product to update
     * @param quantity new stock level to set
     */
    public void setQuantity(Product product, int quantity) {
        stockMap.put(product, quantity);
    }

    /**
     * Increases the stock quantity for the specified product by the given amount.
     * 
     * @param product  the product to update
     * @param quantity amount to add to current stock
     */
    public void increaseQuantity(Product product, int quantity) {
        int current = getQuantity(product);
        stockMap.put(product, current + quantity);
    }

    /**
     * Attempts to reduce the stock quantity for a product by the specified amount.
     * 
     * @param product  the product to update
     * @param quantity amount to subtract from current stock
     * @return true if the stock was successfully reduced; false if insufficient
     *         quantity
     */
    public boolean removeQuantity(Product product, int quantity) {
        int current = getQuantity(product);
        if (quantity > current) {
            return false;
        }
        stockMap.put(product, current - quantity);
        return true;
    }

    /**
     * Displays all products and their current quantities, sorted by product ID.
     */
    public void displayStock() {
        List<Map.Entry<Product, Integer>> entries = new ArrayList<>(stockMap.entrySet());
        entries.sort(Comparator.comparing(e -> e.getKey().getId()));
        System.out.println("Current Stock:");
        for (Map.Entry<Product, Integer> entry : entries) {
            Product p = entry.getKey();
            System.out.printf("%s - %s ($%.2f) | Quantity: %d%n",
                    p.getId(), p.getName(), p.getPrice(), entry.getValue());
        }
    }

    /**
     * Searches for a product in stock by its ID.
     * 
     * @param id the product ID to search for (case-insensitive)
     * @return the Product if found; otherwise null
     */
    public Product findProductById(String id) {
        for (Product p : stockMap.keySet()) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}