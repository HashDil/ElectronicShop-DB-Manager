import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.loadProducts("products.csv");
        catalog.categorizeProducts();

        ManageShop manageShop = new ManageShop(catalog);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Shop Management Menu ===");
            System.out.println("1. Display Categories");
            System.out.println("2. Display Total Sales");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageShop.displayCategories();
                    break;
                case 2:
                    manageShop.displayTotalSales();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
