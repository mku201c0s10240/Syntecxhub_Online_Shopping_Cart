package online_shopping_cart;

import java.util.*;

public class Shopping_Cart {

    static ArrayList<String> products = new ArrayList<>();
    static HashMap<String, Double> priceMap = new HashMap<>();
    static HashMap<String, Integer> cart = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Add products
        products.add("laptop");
        products.add("mobile");
        products.add("headphones");
        products.add("keyboard");

        priceMap.put("laptop", 55000.0);
        priceMap.put("mobile", 25000.0);
        priceMap.put("headphones", 2000.0);
        priceMap.put("keyboard", 1500.0);

        int choice;

        do {
            System.out.println("\n===== ONLINE SHOPPING CART =====");
            System.out.println("1. View Products");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Calculate Total Price");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    calculateTotal();
                    break;
                case 5:
                    System.out.println("Thank you for shopping! 😊");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    // View available products
    static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (String product : products) {
            System.out.println(product + " - ₹" + priceMap.get(product));
        }
    }

    // Add item to cart
    static void addToCart() {
        sc.nextLine(); // clear buffer
        System.out.print("Enter product name: ");
        String item = sc.nextLine().toLowerCase();

        if (!products.contains(item)) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        cart.put(item, cart.getOrDefault(item, 0) + qty);
        System.out.println("Item added to cart successfully!");
    }

    // View cart items
    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        System.out.println("\nYour Cart:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(
                entry.getKey() + " | Qty: " + entry.getValue() +
                " | Price: ₹" + priceMap.get(entry.getKey())
            );
        }
    }

    // Calculate total price
    static void calculateTotal() {
        double total = 0;

        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += priceMap.get(entry.getKey()) * entry.getValue();
        }

        System.out.println("Total Amount: ₹" + total);
    }
    
   
    }

