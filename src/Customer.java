import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String phoneNumber;
    private List<Bill> purchaseHistory;
    private int loyaltyPoints;

    public Customer(String customerId, String name, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.purchaseHistory = new ArrayList<>();
        this.loyaltyPoints = 0;
    }

    // Called whenever this customer completes a bill
    public void addPurchase(Bill bill) {
        purchaseHistory.add(bill);

        // Simple loyalty rule: 1 point per ₹100 spent
        int pointsEarned = (int) (bill.getTotalAmount() / 100);
        loyaltyPoints += pointsEarned;

        System.out.println(name + " earned " + pointsEarned + " loyalty points!");
    }

    public double getTotalSpent() {
        double total = 0;
        for (Bill bill : purchaseHistory) {
            total += bill.getTotalAmount();
        }
        return total;
    }

    public int getPurchaseCount() {
        return purchaseHistory.size();
    }

    // Getters
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getLoyaltyPoints() { return loyaltyPoints; }
}