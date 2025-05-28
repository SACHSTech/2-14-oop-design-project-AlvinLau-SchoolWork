import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Product p1 = new Product("0001", "Apple", 10);
        Product p2 = new Product("0002", "Orange", 15);
        Product p3 = new Product("0003", "Banana", 15);
        Product p4 = new Product("0004", "Chocolate", 20);
        Product p5 = new Product("0005", "Beer", 20);

        Stock stock = new Stock();
        stock.setQuantity(p1, 20);
        stock.setQuantity(p2, 10);
        stock.setQuantity(p3, 30);
        stock.setQuantity(p4, 15);
        stock.setQuantity(p5, 25);

        System.out.print("Are you an admin? (y/n):");
        String role = input.nextLine();
        User currentUser;

        if (role.equalsIgnoreCase("y")) {
            System.out.print("Enter password: ");
            String password = input.nextLine().trim();
            if (password.equals("SACHS")) {
                currentUser = new Admin("Admin01", "Admin1");
                System.out.println("Welcome Admin");

                boolean adminLoop = true;
                while (adminLoop) {
                    System.out.println("\n=== Admin Menu ===");
                    System.out.println("1. View Stock");
                    System.out.println("2. Add Stock");
                    System.out.println("3. Remove Stock");
                    System.out.println("0. Exit");
                    System.out.print("Choose an option: ");

                    String choice = input.nextLine().trim();
                    Admin admin = (Admin) currentUser;

                    switch (choice) {
                        case "1":
                            stock.displayStock();
                            break;
                        case "2":
                            System.out.println("Enter product ID to add stock: ");
                            String addId = input.nextLine();
                            Product addProduct = stock.findProductById(addId);
                            if (addProduct != null) {
                                System.out.print("Quantity to add: ");
                                int addQuantity = input.nextInt();
                                admin.addProductStock(stock, addProduct, addQuantity);
                            } else {
                                System.out.println("Product not found");
                            }
                            break;
                        case "3":
                            System.out.println("Enter product ID to remove stock: ");
                            String removeId = input.nextLine();
                            Product removeProduct = stock.findProductById(removeId);
                            if (removeProduct != null) {
                                System.out.print("Quantity to remove: ");
                                int removeQuantity = input.nextInt();
                                if (!admin.removeProductStock(stock, removeProduct, removeQuantity)) {
                                    System.out.println("Not enough stock");
                                }
                            } else {
                                System.out.println("Product not found");
                            }
                            break;
                        case "0":
                            adminLoop = false;
                            System.out.println("Logged out");
                            break;
                    }
                    input.close();
                }
                return;
            } else {
                System.out.println("Incorrect password. Switching to customer mode.");
            }
        }

        Customer customer = new Customer("C-001", "Alvin");
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
                    stock.displayStock();
                    break;
                case "2":
                    System.out.println("Your cart:");
                    if (cart.getSize() == 0) {
                        System.out.println("Your cart is empty");
                    } else {
                        System.out.println("Sort by:");
                        System.out.println("1. Id");
                        System.out.println("2. Price");
                        String sortChoice = input.nextLine().trim();

                        if (sortChoice.equals("1")) {
                            cart.sortById();
                        } else if (sortChoice.equals("2")) {
                            cart.sortByPrice();
                        }

                        for (CartItem item : cart.getItems()) {
                            System.out.printf("%s x%d = $%.2f%n", item.getProduct().getName(), item.getQuantity(),
                                    item.getLineTotal());
                        }
                        System.out.printf("%s $%.2f%n", "Your Total(Pre-tax):", cart.getTotal());
                    }
                    break;
                case "3":
                    System.out.println("Enter product ID to add: ");
                    String addId = input.nextLine();
                    Product productToAdd = stock.findProductById(addId);
                    if (productToAdd == null) {
                        System.out.println("Product doesn't exist");
                        break;
                    }
                    System.out.println("Enter quantity: ");
                    int quantity = input.nextInt();
                    int available = stock.getQuantity(productToAdd);
                    if (quantity > available) {
                        System.out.println("Only " + available + " is left in stock");
                    } else {
                        cart.addItem(productToAdd, quantity);
                        stock.removeQuantity(productToAdd, quantity);
                        System.out.println("Added to cart");
                    }
                    break;
                case "4":
                    System.out.println("Enter product ID to remove: ");
                    String removeId = input.nextLine();
                    CartItem toRemove = null;
                    for (CartItem item : cart.getItems()) {
                        if (item.getProduct().getId().equalsIgnoreCase(removeId)) {
                            toRemove = item;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        cart.getItems().remove(toRemove);
                        stock.increaseQuantity(toRemove.getProduct(), toRemove.getQuantity());
                        System.out.println("Item successfully removed");
                    } else {
                        System.out.println("Item not found in cart");
                    }
                    break;
                case "0":
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invaild Choice");
            }
        }
        input.close();
    }
}