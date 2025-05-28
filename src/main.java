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
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    for (Product p : catalog) {
                        System.out.printf("s, s", p.getName() + p.getPrice());
                    }
                    break;
                case "5":
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invaild Choice");
            }
        }
    }
}