public class Customer extends User {
    private ShoppingCart cart;

    public Customer(String id, String name) {
        super(id, name);
        this.cart = new ShoppingCart();
    }

    @Override
    public void displayRole() {
        System.out.println("Customer");
    }

    public ShoppingCart getCart() {
        return cart;
    }
}
