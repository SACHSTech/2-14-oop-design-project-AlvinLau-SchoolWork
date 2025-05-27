public class Customer {
    private String id;
    private String name;
    private ShoppingCart cart;

    public Customer(String id, String name, ShoppingCart cart) {
        this.id = id;
        this.name = name;
        this.cart = cart;
    }
}
