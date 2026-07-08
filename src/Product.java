public class Product {
    private String id;
    private String name;
    private String sku;
    private String category;
    private String size;
    private String color;
    private double price;
    private int stockQuantity;

    // Constructor
    public Product(String id, String name, String sku, String category, 
                   String size, String color, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.category = category;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    // Simple method — reduce stock after a sale
    public void reduceStock(int quantityToReduce) {
        if (quantityToReduce > this.stockQuantity) {
            System.out.println("Not enough stock!");
        } else {
            this.stockQuantity -= quantityToReduce;
        }
    }
}