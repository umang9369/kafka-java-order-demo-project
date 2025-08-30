# Kafka Java Order Demo Project

A simple **Java Kafka project** demonstrating a **producer** and multiple **consumers**.  
The project allows sending orders manually through the producer and observing real-time consumption by two consumers: `InventoryConsumer` and `BillingConsumer`.

---

## ✨ Features

- **Manual input producer** – Type orders in the console and send them to Kafka.  
- **Multiple consumers** – Inventory and Billing consumers receive the same messages in real-time.  
- **Extensible** – Easily add more consumers or producers.  
- **Maven project** – Simple build and dependency management.  

---

## 🔧 Prerequisites

- **Java JDK 17** or later  
- **Maven 3.8+**  
- **Apache Kafka 3.9.1** with Zookeeper  
- Windows OS (commands below are Windows-specific)  

---

## 📐 Architecture Overview

```text
       ┌─────────────┐
       │ OrderProducer│
       └─────┬───────┘
             │ Sends orders
             ▼
       ┌─────────────┐
       │   Kafka     │
       │   Topic:    │
       │   "orders"  │
       └─────┬───────┘
  Receives │          │ Receives
         ▼            ▼
┌─────────────────┐ ┌─────────────────┐
│ InventoryConsumer│ │ BillingConsumer │
└─────────────────┘ └─────────────────┘

