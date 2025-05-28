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
        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

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
}