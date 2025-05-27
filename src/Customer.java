public class Customer {
    private String id;
    private String name;
    private ShoppingCart cart;

    public Customer(String id, String name, ShoppingCart cart) {
        this.id = id;
        this.name = name;
        this.cart = cart;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingCart getCart() {
        return cart;
    }
}
