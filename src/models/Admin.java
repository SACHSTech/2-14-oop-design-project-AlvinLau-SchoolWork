package models;

/**
 * Represents an administrator user who can view and manage product stock
 * levels.
 * Extends the abstract User class to provide admin-specific functionality.
 */
public class Admin extends User {

    /**
     * Constructs an Admin user with the specified identifier and name.
     *
     * @param id   the unique identifier for the admin
     * @param name the display name of the admin
     */
    public Admin(String id, String name) {
        super(id, name);
    }

    /**
     * Retrieves the current quantity of a specific product from the stock.
     *
     * @param stock the Stock instance to query
     * @param p     the Product whose quantity to retrieve
     * @return the available quantity of the specified product
     */
    public int getQuantity(Stock stock, Product p) {
        return stock.getQuantity(p);
    }

    /**
     * Sets the stock quantity for a specific product to an exact value.
     *
     * @param stock    the Stock instance to modify
     * @param p        the Product whose stock level is to be set
     * @param quantity the new stock quantity for the product
     */
    public void setProductStock(Stock stock, Product p, int quantity) {
        stock.setQuantity(p, quantity);
    }

    /**
     * Increases the stock quantity for a specific product by a given amount.
     *
     * @param stock    the Stock instance to modify
     * @param p        the Product whose stock level is to be increased
     * @param quantity the amount to add to the current stock level
     */
    public void addProductStock(Stock stock, Product p, int quantity) {
        stock.increaseQuantity(p, quantity);
    }

    /**
     * Decreases the stock quantity for a specific product by a given amount if
     * sufficient stock exists.
     *
     * @param stock    the Stock instance to modify
     * @param p        the Product whose stock level is to be reduced
     * @param quantity the amount to remove from the current stock level
     * @return true if the stock was successfully reduced, false if insufficient
     *         quantity
     */
    public boolean removeProductStock(Stock stock, Product p, int quantity) {
        return stock.removeQuantity(p, quantity);
    }

    /**
     * Prints the role of this user to the console. For Admin, prints "Admin".
     */
    @Override
    public void displayRole() {
        System.out.println("Admin");
    }
}