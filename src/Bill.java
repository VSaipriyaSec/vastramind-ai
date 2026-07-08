import java.util.ArrayList;
import java.util.List;

public class Bill {
    private String billId;
    private String customerName;
    private String customerPhone;
    private List<BillItem> items;
    private double totalAmount;

    public Bill(String billId, String customerName, String customerPhone) {
        this.billId = billId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    // Add a product to this bill
    public void addItem(Product product, int quantity) {
        if (quantity > product.getStockQuantity()) {
            System.out.println("Not enough stock for " + product.getName());
            return;
        }

        BillItem item = new BillItem(product, quantity);
        items.add(item);

        // Reduce stock automatically (connects to Product class)
        product.reduceStock(quantity);

        // Update total
        totalAmount += product.getPrice() * quantity;
    }

    public void printBill() {
        System.out.println("----- BILL: " + billId + " -----");
        System.out.println("Customer: " + customerName + " (" + customerPhone + ")");
        for (BillItem item : items) {
            System.out.println(item.getProductName() + " x " + item.getQuantity() 
                + " = ₹" + item.getSubtotal());
        }
        System.out.println("TOTAL: ₹" + totalAmount);
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}