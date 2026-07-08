# Database Schema — VastraMind AI (Version 1)

**Database:** MySQL / PostgreSQL
**Status:** V1 Draft — matches current Java classes (Product, Bill, BillItem, Supplier) + planned Customer, Employee

---

## 1. Entity Relationship Overview

```
Supplier ──< Product ──< BillItem >── Bill >── Customer
                                        Bill >── Employee (billed by)
```

**In simple words:**
- One **Supplier** supplies many **Products**
- One **Product** can appear in many **BillItems** (across different bills)
- One **Bill** has many **BillItems** (multiple products in one bill)
- One **Customer** can have many **Bills** (purchase history)
- One **Employee** can create many **Bills** (who billed the sale)

---

## 2. Table Definitions

### 2.1 `products`
Maps to your `Product.java` class.

```sql
CREATE TABLE products (
    product_id      VARCHAR(20) PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    sku             VARCHAR(50) UNIQUE NOT NULL,
    category        VARCHAR(50),
    size            VARCHAR(20),
    color           VARCHAR(30),
    price           DECIMAL(10,2) NOT NULL,
    stock_quantity  INT NOT NULL DEFAULT 0,
    supplier_id     VARCHAR(20),
    low_stock_alert INT DEFAULT 5,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id)
);
```

### 2.2 `suppliers`
Maps to your `Supplier.java` class.

```sql
CREATE TABLE suppliers (
    supplier_id     VARCHAR(20) PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    contact_number  VARCHAR(15),
    email           VARCHAR(100),
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 2.3 `customers`
Planned — your teammate's `Customer.java` class will map here.

```sql
CREATE TABLE customers (
    customer_id     VARCHAR(20) PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    phone           VARCHAR(15) UNIQUE NOT NULL,
    email           VARCHAR(100),
    total_purchases DECIMAL(10,2) DEFAULT 0,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 2.4 `bills`
Maps to your `Bill.java` class.

```sql
CREATE TABLE bills (
    bill_id         VARCHAR(20) PRIMARY KEY,
    customer_id     VARCHAR(20),
    employee_id     VARCHAR(20),
    bill_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount    DECIMAL(10,2) NOT NULL,
    discount_percent DECIMAL(5,2) DEFAULT 0,
    final_amount    DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);
```

### 2.5 `bill_items`
Maps to your `BillItem.java` class. This is the "join table" connecting bills and products.

```sql
CREATE TABLE bill_items (
    bill_item_id    INT AUTO_INCREMENT PRIMARY KEY,
    bill_id         VARCHAR(20) NOT NULL,
    product_id      VARCHAR(20) NOT NULL,
    quantity        INT NOT NULL,
    subtotal        DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (bill_id) REFERENCES bills(bill_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
```

### 2.6 `employees`
Planned — for role-based access (Owner vs Staff), as discussed earlier.

```sql
CREATE TABLE employees (
    employee_id     VARCHAR(20) PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    role            ENUM('OWNER', 'STAFF') NOT NULL,
    contact_number  VARCHAR(15),
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## 3. Why `bill_items` is a separate table (important concept)

A single bill usually has **multiple products** (e.g., 1 saree + 2 shirts in one bill). If we tried to store all products directly inside the `bills` table, we'd need unlimited columns — not possible.

Instead, `bill_items` stores **one row per product per bill**, linking back to both `bills` and `products` using foreign keys. This is called a **many-to-many relationship**, resolved with a **junction table**.

Example: Bill `B001` with 2 products creates 2 rows in `bill_items`:

| bill_item_id | bill_id | product_id | quantity | subtotal |
|---|---|---|---|---|
| 1 | B001 | P001 | 2 | 5000.00 |
| 2 | B001 | P002 | 1 | 1200.00 |

---

## 4. How This Maps to Your Java Code

| Java Class | Database Table |
|---|---|
| `Product.java` | `products` |
| `Supplier.java` | `suppliers` |
| `Bill.java` | `bills` |
| `BillItem.java` | `bill_items` |
| `Customer.java` (teammate) | `customers` |
| (planned) `Employee.java` | `employees` |

When you reach the Spring Boot stage (Week 4), each Java class becomes an **Entity** using `@Entity` annotation, and Spring Boot connects it directly to these tables — the mapping you see above becomes literal code.

---

## 5. Next Steps

- [ ] Review this schema with your teammate before finalizing `Customer` table fields
- [ ] Confirm `employee_id` is needed now or can be added later (role-based access is a V1 stretch goal)
- [ ] Once SQL is learned (Week 3 per roadmap), actually create this database and test with sample data
