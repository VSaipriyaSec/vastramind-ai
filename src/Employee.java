public class Employee {
    private String employeeId;
    private String name;
    private String role;  // "OWNER" or "STAFF"
    private String contactNumber;

    public Employee(String employeeId, String name, String role, String contactNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters
    public String getEmployeeId() { return employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    // Check if this employee has admin/owner permissions
    public boolean isOwner() {
        return role.equalsIgnoreCase("OWNER");
    }

    public void printEmployeeDetails() {
        System.out.println("----- EMPLOYEE: " + name + " -----");
        System.out.println("ID: " + employeeId);
        System.out.println("Role: " + role);
        System.out.println("Contact: " + contactNumber);
    }
}