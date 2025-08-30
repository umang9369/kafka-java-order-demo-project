Of course. Here is the updated `README.md` file with the text and images you provided, formatted and integrated as requested.

-----

# Kafka Java Order Demo Project

A simple **Java Kafka project** demonstrating a **producer** and multiple **consumers**.
The project allows sending orders manually through the producer and observing real-time consumption by two consumers: `InventoryConsumer` and `BillingConsumer`.

-----

## ✨ Features

  - **Manual input producer** – Type orders in the console and send them to Kafka.
  - **Multiple consumers** – Inventory and Billing consumers receive the same messages in real-time.
  - **Extensible** – Easily add more consumers or producers.
  - **Maven project** – Simple build and dependency management.

-----

## 🔧 Prerequisites

  - **Java JDK 17** or later
  - **Maven 3.8+**
  - **Apache Kafka 3.9.1** with Zookeeper
  - Windows OS (commands below are Windows-specific)

-----

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
```

-----

## 📸 Project Screenshots

### 🔗 Kafka Integration
![Kafka Integration](https://github.com/umang9369/kafka-java-order-demo-project/blob/main/screenshots/kafka%20integration.png)

### 🖥️ Inventory Consumer & Order Producer (CLI Output)
![Order Producer & Inventory Consumer](https://github.com/umang9369/kafka-java-order-demo-project/blob/main/screenshots/Order%20Producer%20%26%20Inventory%20Consumer.png)

### 💳 Billing Consumer (CLI Output)
![Billing Consumer](https://github.com/umang9369/kafka-java-order-demo-project/blob/main/screenshots/Billing%20Consumer.png)
-----

## 🚀 Getting Started

Follow the steps below to set up the environment and run the project.

### Step 1 — Install Java

1.  Download OpenJDK 17: [Adoptium OpenJDK 17](https://adoptium.net/temurin/releases/?version=17)
2.  Install it (default settings).
3.  Verify installation:
    ```bash
    java -version
    ```

### Step 2 — Install Maven

1.  Download [Apache Maven](https://maven.apache.org/download.cgi).
2.  Extract to `C:\apache-maven`.
3.  Add `C:\apache-maven\bin` to your system's PATH.
4.  Verify installation:
    ```bash
    mvn -v
    ```

### Step 3 — Install Kafka

1.  Download [Kafka 3.9.1](https://kafka.apache.org/downloads).
2.  Extract to `C:\kafka\kafka_2.13-3.9.1`.
3.  **Start Zookeeper** (in a new terminal):
    ```bash
    cd C:\kafka\kafka_2.13-3.9.1
    .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
    ```
4.  **Start Kafka broker** (in another new terminal):
    ```bash
    cd C:\kafka\kafka_2.13-3.9.1
    .\bin\windows\kafka-server-start.bat .\config\server.properties
    ```

### Step 4 — Clone and Build Project

```bash
git clone https://github.com/umang9369/kafka-java-order-demo-project.git
cd kafka-java-order-demo-project
mvn clean install
```

### Step 5 — Run the Producer

Open a new terminal in the project directory and run:

```bash
mvn exec:java -Dexec.mainClass="com.example.kafka.producer.OrderProducer"
```

### Step 6 — Run the Consumers

Open two separate terminals in the project directory.

  - **InventoryConsumer**:
    ```bash
    mvn exec:java -Dexec.mainClass="com.example.kafka.consumer.InventoryConsumer"
    ```
  - **BillingConsumer**:
    ```bash
    mvn exec:java -Dexec.mainClass="com.example.kafka.consumer.BillingConsumer"
    ```
