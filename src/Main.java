public class Main {
    public static void main(String[] args) {
        Product saree = new Product("P001", "Red Silk Saree", "SAR-RED-001",
            "Saree", "Free Size", "Red", 2500.0, 10);

        Customer priya = new Customer("C001", "Priya", "9876543210");

        Bill bill1 = new Bill("B001", priya.getName(), priya.getPhoneNumber());
        bill1.addItem(saree, 2);
        bill1.printBill();

        // Discount feature
        bill1.applyDiscount(10);
        bill1.printBill();

        // Link bill to customer (loyalty points)
        priya.addPurchase(bill1);
        System.out.println("Total spent: ₹" + priya.getTotalSpent());
        System.out.println("Loyalty points: " + priya.getLoyaltyPoints());

        // Supplier class demo
        Supplier supplier1 = new Supplier("SUP001", "Chennai Textiles", "9876500000", "chennai@textiles.com");
        supplier1.addProduct("Red Silk Saree");
        supplier1.addProduct("Blue Cotton Shirt");
        supplier1.printSupplierDetails();

        //employee
        Employee owner = new Employee("EMP001", "Saipriya", "OWNER", "9876543210");
        Employee staff = new Employee("EMP002", "Ramesh", "STAFF", "9876500001");

        saree.updatePrice(3000.0, owner);
        saree.updatePrice(3500.0, staff);
    }
}