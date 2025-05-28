package models;

public class Customer extends User {
    private ShoppingCart cart;

    /**
     * Constructs a Customer with the given ID and name, and initializes an empty
     * ShoppingCart.
     * 
     * @param id   the unique identifier for the customer
     * @param name the customer's name
     */
    public Customer(String id, String name) {
        super(id, name);
        this.cart = new ShoppingCart();
    }

    /**
     * Prints the role of this user (Customer) to the console.
     */
    @Override
    public void displayRole() {
        System.out.println("Customer");
    }

    /**
     * Returns the cart associated with this customer.
     * 
     * @return the cart
     */
    public ShoppingCart getCart() {
        return cart;
    }
}
