import java.util.*;
import java.io.*;

public class Catalog {
    private List<Product> products;
    private Map<String, List<Product>> categorizedProducts;

    public Catalog() {
        products = new ArrayList<>();
        categorizedProducts = new HashMap<>();
        initializeCategories();
    }

    private void initializeCategories() {
        categorizedProducts.put("Gaming Accessories", new ArrayList<>());
        categorizedProducts.put("Communication Devices", new ArrayList<>());
        categorizedProducts.put("Computer Accessories", new ArrayList<>());
        categorizedProducts.put("Uncategorized", new ArrayList<>());
    }

    public void loadProducts(String fileName) {
        String line;
        String splitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] productDetails = line.split(splitBy);
                products.add(new Product(
                        productDetails[0],
                        productDetails[1],
                        Double.parseDouble(productDetails[2]),
                        Integer.parseInt(productDetails[3])
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void categorizeProducts() {
        for (Product product : products) {
            String productName = product.getProductName().toLowerCase();

            if (productName.contains("keyboard") || productName.contains("mouse") || productName.contains("headset")) {
                categorizedProducts.get("Gaming Accessories").add(product);
            } else if (productName.contains("phone") || productName.contains("tablet") || productName.contains("router")) {
                categorizedProducts.get("Communication Devices").add(product);
            } else if (productName.contains("monitor") || productName.contains("printer") || productName.contains("usb")) {
                categorizedProducts.get("Computer Accessories").add(product);
            } else {
                categorizedProducts.get("Uncategorized").add(product);
            }
        }
    }

    public Map<String, List<Product>> getCategorizedProducts() {
        return categorizedProducts;
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
