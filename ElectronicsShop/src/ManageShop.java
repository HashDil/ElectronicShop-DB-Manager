import java.util.*;

public class ManageShop {
    private Catalog catalog;

    public ManageShop(Catalog catalog) {
        this.catalog = catalog;
    }

    public void displayCategories() {
        Map<String, List<Product>> categories = catalog.getCategorizedProducts();

        for (Map.Entry<String, List<Product>> entry : categories.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
            System.out.println();
        }
    }

    public void displayTotalSales() {
        double totalSales = 0;

        for (Product product : catalog.getAllProducts()) {
            totalSales += product.getSales();
        }

        System.out.println("Total Sales of All Products: " + totalSales);
    }
}
