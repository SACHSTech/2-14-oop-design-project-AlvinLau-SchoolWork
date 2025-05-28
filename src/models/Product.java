package models;

/**
 * Represents a product in the online store with an ID, name, and price.
 */
public class Product {
    private String id;
    private String name;
    private double price;

    /**
     * Constructs a new Product with the specified ID, name, and price.
     *
     * @param id    the unique identifier for the product
     * @param name  the display name of the product
     * @param price the price of the product
     */
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the unique identifier of this product.
     *
     * @return the product ID
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the display name of this product.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the display name of this product.
     *
     * @param name the new name for the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of this product.
     *
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of this product.
     *
     * @param price the new price for the product
     */
    public void setPrice(double price) {
        this.price = price;
    }
}