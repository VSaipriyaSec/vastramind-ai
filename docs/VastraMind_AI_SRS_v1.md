# Software Requirements Specification (SRS) — Version 1
## VastraMind AI

**Tagline:** The AI Brain Behind Every Fashion Business
**Document Version:** 1.0
**Date:** July 2026
**Status:** Week 1 Draft

---

## 1. Introduction

### 1.1 Purpose
This document defines the functional and non-functional requirements for **VastraMind AI**, a business operating system for fashion retailers. Version 1 focuses on the **core, buildable features** (Billing, Inventory, CRM basics) since these form the data foundation needed for any future AI features.

### 1.2 Scope (Version 1 — Realistic Week 1–4 Target)
This version covers:
- Billing system
- Inventory management
- Basic customer records (CRM lite)

This version does **NOT** cover (moved to future SRS versions):
- AI recommendations, forecasting, trend analysis
- Marketing automation
- Digital closet / loyalty programs

> Reasoning: AI features need real transaction data to work. Building billing + inventory first gives the AI something to learn from later.

### 1.3 Intended Audience
- Developer (you) — as build reference
- Future collaborators / mentors reviewing the project
- Potential early boutique users for feedback

---

## 2. Overall Description

### 2.1 Product Perspective
A standalone web application (later expandable to SaaS) used by boutique/store owners to manage daily billing and inventory, replacing manual registers or spreadsheets.

### 2.2 User Classes
| User Type | Description |
|---|---|
| Store Owner/Admin | Full access — billing, inventory, reports |
| Staff/Cashier | Billing access only |
| (Future) Customer | Views own purchase history via WhatsApp/portal |

### 2.3 Operating Environment
- Backend: Spring Boot (Java)
- Database: MySQL/PostgreSQL
- Frontend: React (web) — Flutter later for mobile

---

## 3. Functional Requirements

### 3.1 Billing Module
- FR1: System shall allow creating a new bill with multiple products
- FR2: System shall calculate total, tax, and discount automatically
- FR3: System shall generate a printable/downloadable invoice
- FR4: System shall store every bill linked to a customer (if provided)

### 3.2 Inventory Module
- FR5: System shall allow adding new products (name, SKU, category, size, color, price, stock quantity)
- FR6: System shall auto-reduce stock quantity when a bill is created
- FR7: System shall alert when stock falls below a set threshold
- FR8: System shall allow updating/editing product details

### 3.3 Customer Module (CRM Lite)
- FR9: System shall store customer name, phone number, and purchase history
- FR10: System shall allow searching customer by phone number
- FR11: System shall show total purchases made by a customer

### 3.4 Supplier & Employee (Basic)
- FR12: System shall store supplier name and contact for restocking reference
- FR13: System shall store employee name and role (for future access control)

---

## 4. Non-Functional Requirements

| Type | Requirement |
|---|---|
| Performance | Bill generation should complete in under 2 seconds |
| Usability | UI should be simple enough for non-technical shop staff |
| Reliability | No data loss on bill creation (DB transactions used) |
| Scalability | Schema designed to support multi-branch stores later |
| Security | Passwords stored hashed; role-based access (owner vs staff) |

---

## 5. Database Entities (High-Level, detailed schema next)

- **Product** (id, name, SKU, category, size, color, price, stock_qty)
- **Customer** (id, name, phone, total_purchases)
- **Bill** (id, customer_id, date, total_amount, items)
- **BillItem** (id, bill_id, product_id, quantity, price)
- **Supplier** (id, name, contact, products_supplied)
- **Employee** (id, name, role, contact)

---

## 6. Future Scope (SRS v2+)

- AI Recommendation Engine (based on purchase history)
- Demand Forecasting (based on seasonal sales data)
- AI Marketing Assistant (auto WhatsApp offers)
- Digital Stamp Card / Loyalty system
- Multi-branch analytics dashboard

---

## 7. Assumptions & Constraints

- Assumes single-branch store for V1 (multi-branch is future scope)
- Assumes internet connectivity for cloud-hosted version
- Built by a solo developer learning as they build — timeline is flexible, quality over speed

---

*Next document: Database Schema (ER Diagram) based on entities above.*
