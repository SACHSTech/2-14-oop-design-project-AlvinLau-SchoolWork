import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Product p1 = new Product("0001", "Apple", 10);
        Product p2 = new Product("0002", "Oranges", 15);
        Product p3 = new Product("0003", "Bananas", 15);
        Product p4 = new Product("0004", "Chocolate", 20);
        Product p5 = new Product("0005", "Beer", 20);

        List<Product> catalog = Arrays.asList(p1, p2, p3);

        Customer customer = new Customer("C001", "Alice");
        ShoppingCart cart = customer.getCart();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Shopping Menu ===");
            System.out.println("1. View Catalog");
            System.out.println("2. View Cart");
            System.out.println("3. Add Item to Cart");
            System.out.println("4. Remove Item from Cart");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    for (Product p : catalog) {
                        System.out.printf("%s - %s ($%.2f)%n", p.getId(), p.getName(), p.getPrice());
                    }
                    break;
                case "2":
                    System.out.println("Your cart:");
                    if (cart.getSize() == 0) {
                        System.out.println("Your cart is empty");
                    } else {
                        for (CartItem item : cart.getItems()) {
                            System.out.printf("%s x%d = $%.2f%n", item.getProduct().getName(), item.getQuantity(),
                                    item.getLineTotal());
                        }
                    }
                    break;
                case "3":
                    System.out.println("Enter product ID to add");
                    String addId = input.nextLine();
                    Product toAdd = findProductById(catalog, addId);

                    break;
                case "0":
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invaild Choice");
            }
        }
    }

    public static Product findProductbyId(List<Product> catalog, String id) {
        for (Product p : catalog) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}