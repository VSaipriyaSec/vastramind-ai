import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private String supplierId;
    private String name;
    private String contactNumber;
    private String email;
    private List<String> productsSupplied;

    // Constructor
    public Supplier(String supplierId, String name, String contactNumber, String email) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.productsSupplied = new ArrayList<>();
    }

    // Getters and Setters
    public String getSupplierId() { return supplierId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Add a product this supplier provides
    public void addProduct(String productName) {
        productsSupplied.add(productName);
        System.out.println(productName + " added to " + name + "'s supply list.");
    }

    // Display supplier info
    public void printSupplierDetails() {
        System.out.println("----- SUPPLIER: " + name + " -----");
        System.out.println("ID: " + supplierId);
        System.out.println("Contact: " + contactNumber);
        System.out.println("Email: " + email);
        System.out.println("Products Supplied: " + productsSupplied);
    }
}