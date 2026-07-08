public class Main {
    public static void main(String[] args) {
        Product saree = new Product("P001", "Red Silk Saree", "SAR-RED-001",
            "Saree", "Free Size", "Red", 2500.0, 10);

        Customer priya = new Customer("C001", "Priya", "9876543210");

        Bill bill1 = new Bill("B001", priya.getName(), priya.getPhoneNumber());
        bill1.addItem(saree, 2);
        bill1.printBill();

        priya.addPurchase(bill1);

        System.out.println("Total spent: ₹" + priya.getTotalSpent());
        System.out.println("Loyalty points: " + priya.getLoyaltyPoints());
    }
}