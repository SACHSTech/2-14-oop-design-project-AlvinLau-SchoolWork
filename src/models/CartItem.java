package models;

/**
 * Represents an item in the shopping cart, holding a product and its quantity.
 */
public class CartItem {
    private Product product;
    private int quantity;

    /**
     * Constructs a CartItem for the given product and quantity.
     * 
     * @param product  the product being added to the cart
     * @param quantity the number of units of the product
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Returns the product associated with this cart item.
     * 
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the quantity of the product in the cart.
     * 
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity for this cart item.
     * 
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Calculates the total price for this cart item (product price * quantity).
     * 
     * @return the line total cost
     */
    public double getLineTotal() {
        return product.getPrice() * quantity;
    }
}
