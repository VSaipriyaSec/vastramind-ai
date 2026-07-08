public class BillItem {
    private String productName;
    private int quantity;
    private double subtotal;

    public BillItem(Product product, int quantity) {
        this.productName = product.getName();
        this.quantity = quantity;
        this.subtotal = product.getPrice() * quantity;
    }

    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getSubtotal() { return subtotal; }
}