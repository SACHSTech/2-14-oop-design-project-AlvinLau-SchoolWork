public class Admin extends User {
    public Admin(String id, String name) {
        super(id, name);
    }

    public int getQuantity(Stock stock, Product p) {
        return stock.getQuantity(p);
    }

    public void setProductStock(Stock stock, Product p, int quantity) {
        stock.setQuantity(p, quantity);
    }

    public void addProductStock(Stock stock, Product p, int quantity) {
        stock.increaseQuantity(p, quantity);
    }

    public boolean removeProductStock(Stock stock, Product p, int quantity) {
        return stock.removeQuantity(p, quantity);
    }

    @Override
    public void displayRole() {
        System.out.println("Admin");
    }
}