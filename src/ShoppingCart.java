import java.util.*;

public class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getId().equals(id)) {
                items.remove(i);
            }
        }
    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getLineTotal();
        }
        return total;
    }

    public int getSize() {
        return items.size();
    }

    public void sortByPrice() {
        for (int i = 0; i < items.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < items.size(); i++) {
                if (items.get(j).getProduct().getPrice() < items.get(minIndex).getProduct().getPrice()) {
                    minIndex = j;
                }
            }

            CartItem temp = items.get(j);
            items.set(i, items.get(minIndex));
            items.set(minIndex, temp);
        }
    }
}