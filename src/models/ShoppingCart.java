package models;

import java.util.*;

/**
 * Represents a customer's shopping cart, containing multiple CartItem entries.
 * Provides methods to add, remove, sort items, and checkout.
 */
public class ShoppingCart {
    private List<CartItem> items;

    /**
     * Constructs an empty ShoppingCart with no items.
     */
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    /**
     * Returns the list of items currently in the cart.
     * 
     * @return list of CartItem objects
     */
    public List<CartItem> getItems() {
        return items;
    }

    /**
     * Adds a specified quantity of a product to the cart. If the product
     * already exists, increases its quantity.
     * 
     * @param product  the product to add
     * @param quantity the number of units to add
     */
    public void addItem(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    /**
     * Removes a specified quantity of a product from the cart by product ID.
     * If the removal quantity is greater than or equal to the current quantity,
     * the item is removed entirely.
     * 
     * @param id       the product ID to remove
     * @param quantity the number of units to remove
     */
    public void removeItem(String id, int quantity) {
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            if (item.getProduct().getId().equals(id)) {
                int currentQuantity = item.getQuantity();
                if (quantity >= currentQuantity) {
                    items.remove(i);
                } else {
                    item.setQuantity(currentQuantity - quantity);
                }
                return;
            }
        }
    }

    /**
     * Calculates the total cost of all items in the cart.
     * 
     * @return the sum of line totals for each CartItem
     */
    public double getTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getLineTotal();
        }
        return total;
    }

    /**
     * Returns the number of distinct CartItem entries in the cart.
     * 
     * @return count of items
     */
    public int getSize() {
        return items.size();
    }

    /**
     * Sorts the cart items in ascending order by product price using selection
     * sort.
     */
    public void sortByPrice() {
        for (int i = 0; i < items.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(j).getProduct().getPrice() < items.get(minIndex).getProduct().getPrice()) {
                    minIndex = j;
                }
            }

            CartItem temp = items.get(i);
            items.set(i, items.get(minIndex));
            items.set(minIndex, temp);
        }
    }

    /**
     * Sorts the cart items in ascending order by product ID using selection sort.
     */
    public void sortById() {
        for (int i = 0; i < items.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < items.size(); j++) {
                String id1 = items.get(j).getProduct().getId();
                String id2 = items.get(minIndex).getProduct().getId();
                if (id1.compareToIgnoreCase(id2) < 0) {
                    minIndex = j;
                }
            }

            CartItem temp = items.get(i);
            items.set(i, items.get(minIndex));
            items.set(minIndex, temp);
        }
    }

    /**
     * Prints all items and their costs, calculates subtotal, tax (13%), and total,
     * then clears the cart.
     */
    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\n=== Checkout ===");
        for (CartItem item : items) {
            System.out.printf("%s x%d = $%.2f%n",
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getLineTotal());
        }

        double subtotal = getTotal();
        double tax = subtotal * 0.13;
        double total = subtotal + tax;

        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Tax (13%%): $%.2f%n", tax);
        System.out.printf("Total (with tax): $%.2f%n", total);
        System.out.println("Thank you for your purchase!");

        items.clear();
    }
}