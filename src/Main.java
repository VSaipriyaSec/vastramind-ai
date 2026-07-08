public class Main {
    public static void main(String[] args) {
        Product saree = new Product("P001", "Red Silk Saree", "SAR-RED-001", 
            "Saree", "Free Size", "Red", 2500.0, 10);

        Bill bill1 = new Bill("B001", "Priya", "9876543210");
        bill1.addItem(saree, 2);
        bill1.printBill();
    }
}