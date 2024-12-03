public class Product {
    private String productID;
    private String productName;
    private double price;
    private int sales;

    public Product(String productID, String productName, double price, int sales) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.sales = sales;
    }

    public String getProductName() {
        return productName;
    }

    public double getSales() {
		double totsales=sales*price;
        return totsales;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                '}';
    }
}
