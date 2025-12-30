# 🛍️ E-commerce Microservices Application

A **high-performance, scalable, and modular E-commerce platform** built using **Spring Boot** and **Microservices Architecture**, designed to support modern, distributed e-commerce systems with ease and reliability.

---

## 📌 Project Overview

The **E-commerce Microservices Application** addresses real-world challenges faced by online businesses—such as product management, order handling, payment processing, and customer notifications—by breaking the system into **independently deployable microservices**.

### 🔑 Key Features

- 🛒 **Product Management**
  - Create, update, and manage products with unique identifiers and inventory tracking.
- 📦 **Order Processing**
  - Complete order lifecycle from placement to fulfillment.
- 💳 **Payment Handling**
  - Payment validation, processing, and status notifications.
- 📧 **Email Notifications**
  - Automated emails for payment success and failure events.
- 📈 **Scalable Design**
  - Loosely coupled services enabling easy scaling and future enhancements.

---

## 🧱 System Architecture

The application follows a **containerized microservices architecture**, orchestrated using **Docker Compose**, ensuring consistency across environments.

### 🔹 Core Microservices

| Service | Responsibility |
|------|--------------|
| **Product Service** | Manages product catalog and inventory |
| **Customer Service** | Handles customer profiles and addresses |
| **Order Service** | Processes and tracks customer orders |
| **Payment Service** | Manages payments and triggers notifications |

### 📊 Architecture Diagrams

- 🔁 **Microservices Interaction Flow**  
  👉 https://github.com/rohithkodipaka/ecommerce-app/blob/main/diagrams/microservices-flow.drawio

- 🧩 **Entity Relationship Diagram (ERD)**  
  👉 https://github.com/rohithkodipaka/ecommerce-app/blob/main/diagrams/entity-relationship.drawio

---

## 🛠️ Tech Stack

### 🚀 Backend & Frameworks
- **Java (Spring Boot)**
  - Spring Data JPA & MongoDB
  - Spring Security
  - Spring Cloud (Microservices)

### 🗄️ Databases
- **PostgreSQL** – Relational data (customers, orders)
- **MongoDB** – Non-relational & transactional data

### ⚙️ Infrastructure & Messaging
- **Docker & Docker Compose**
- **Apache Kafka** – Event-driven communication
- **Zookeeper** – Distributed coordination
- **Zipkin** – Distributed tracing

### 🧪 Testing
- **JUnit**
- **MockMvc**
- Mocked integration tests

---

## 🚀 Deployment & Setup

### ✅ Prerequisites
- Docker
- Docker Compose

### ▶️ Run Locally

```bash
git clone https://github.com/rohithkodipaka/ecommerce-app.git
cd ecommerce-app
docker-compose up
````

### 🌐 Service Access

| Service                 | URL               |
| ----------------------- | ----------------- |
| PostgreSQL              | `localhost:5432`  |
| MongoDB                 | `localhost:27017` |
| Kafka Broker            | `localhost:9092`  |
| Zipkin UI               | `localhost:9411`  |
| MailDev (Email Testing) | `localhost:1080`  |
| PgAdmin                 | `localhost:5050`  |

---

## 🧩 Docker Services Overview

* 🐘 **PostgreSQL** – Relational database
* 🍃 **MongoDB** – NoSQL storage
* 📨 **Apache Kafka** – Message broker
* 🧭 **Zookeeper** – Kafka coordination
* 🧪 **MailDev** – Email testing interface
* 📊 **Zipkin** – Distributed tracing
* 🧑‍💻 **PgAdmin** – PostgreSQL UI

---

## 📁 Repository Structure

```plaintext
ecommerce-app
├── diagrams
│   ├── microservices-flow.drawio
│   ├── entity-relationship.drawio
├── docker-compose.yml
├── services
│   ├── product-service
│   ├── customer-service
│   ├── order-service
│   ├── payment-service
└── README.md
```

---

## 🔮 Future Enhancements

* 💳 Stripe / PayPal payment gateway integration
* 📜 Event sourcing for audit trails
* ☸️ Kubernetes deployment support
* 🔁 CI/CD pipelines with GitHub Actions

---

## 👤 Author & Contact

**Rohith Kodipaka**
🔗 GitHub: [https://github.com/rohithkodipaka](https://github.com/rohithkodipaka)

Contributions, issues, and feature requests are welcome!
⭐ If you like this project, don’t forget to star the repo.
