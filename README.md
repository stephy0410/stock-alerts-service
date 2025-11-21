
# 📈 Stock Market Alerts & Portfolio Intelligence Microservice

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3-brightgreen?style=flat-square)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square)
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=flat-square)
![Build Status](https://img.shields.io/badge/Build-Passing-success?style=flat-square)

> A backend microservice that monitors stock/ETF prices in real-time, evaluates user-defined alerts, tracks a personal investment portfolio, and provides basic market trend predictions.

Built to showcase **production-style backend engineering** using Spring Boot, real-world APIs, scheduled jobs, and containerization.

---

## Features

### 🔔 Real-Time Price Alerts
* **Custom Rules:** Create alert rules such as *"Notify me if AAPL < 160"*.
* **Automated Polling:** System polls market prices on a fixed schedule using `@Scheduled` tasks.
* **Multi-Channel Notifications:** Supports **Telegram** and **Email (SendGrid)**.
* **Spam Prevention:** Includes "cool-down" logic to avoid repeated alert spam.

### 💼 Portfolio Tracker
* **Position Management:** Add positions (symbol, shares, average price).
* **Real-Time Valuation:** Computes total value and Profit/Loss (P&L) using live market data.
* **Scalable Design:** Database schema supports multiple portfolios and asset categories.

### 📊 Market Trend Prediction
* **Algorithmic Analysis:** Simple moving-average–based predictor.
* **Trend Detection:** Returns `UPTREND` / `DOWNTREND` signals based on recent price history.
* **Extensible:** Designed as a modular service to easily swap in ML models later.

### ⚙️ Microservice Design
* **RESTful API:** Built with **Spring Web**.
* **Non-Blocking I/O:** External API integration using **Spring WebClient**.
* **Persistence:** Robust data layer with **Spring Data JPA** + **MySQL**.
* **Clean Architecture:** `Controller` → `Service` → `Repository` → `Database`.
* **DevOps Ready:** Containerized with **Docker** & **Docker Compose**.

---

##  Architecture Overview

The system follows a layered microservices architecture to ensure separation of concerns and scalability.

```text
 Client / Postman
        |
        v
+-------------------------+
| Spring Boot API Layer   |
| (Controllers)           |
+-------------------------+
        |
        v
+-------------------------+
| Services                |
|  - MarketService        |
|  - AlertEvaluation      |
|  - PortfolioService     |
|  - NotificationService  |
+-------------------------+
        |
        v
+-------------------------+
| Repositories (JPA)      |
| MySQL Database          |
+-------------------------+
````

-----

## Tech Stack

| Category | Technology |
| :--- | :--- |
| **Language** | Java 17 |
| **Framework** | Spring Boot 3+ (Web, Data JPA) |
| **HTTP Client** | Spring WebClient |
| **Database** | MySQL 8.0 |
| **DevOps** | Docker, Docker Compose |
| **Tools** | Maven, Git, Postman |
| **Integrations** | SendGrid (Email), Telegram Bot API |

-----

##  Setup & Installation

### 1\. Run MySQL with Docker

Use the included `docker-compose.yml` (or run manually) to start the database.

```bash
docker compose up -d
```

*This starts a MySQL container with:*

  * **Host:** `localhost`
  * **Port:** `3306`
  * **User:** `sa`
  * **Password:** `sapwd`
  * **Database:** `stockalerts`

### 2\. Configure the Application

Check `src/main/resources/application.yml` and update keys if necessary.

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/stockalerts
    username: sa
    password: sapwd
  jpa:
    hibernate:
      ddl-auto: update

app:
  polling:
    interval-seconds: 60
  notification:
    telegram:
      bot-token: YOUR_BOT_TOKEN
      chat-id: YOUR_CHAT_ID
```

### 3\. Run the Application

**Using Maven:**

```bash
mvn spring-boot:run
```

**Using JAR (Production Mode):**

```bash
mvn clean package
java -jar target/stock-alerts-service.jar
```

-----

## 📡 API Examples

### ➕ Create an Alert

**POST** `/alerts`

```json
{
  "userId": 1,
  "symbol": "AAPL",
  "condition": "LT",
  "threshold": 160
}
```

### 📊 Get Portfolio Value

**GET** `/portfolio/1/value`

### 📉 Trend Prediction

**GET** `/predict?symbol=AAPL&period=10`

-----

## 📬 Notifications

  * **Telegram Bot (Recommended for Beginners):**

    1.  Create a bot using `@BotFather`.
    2.  Add your token & chat ID to `application.yml`.
    3.  Alerts arrive instantly on your phone.

  * **SendGrid Email:**

      * Add API Key to configuration.
      * Great for demonstrating enterprise-grade notification systems.

-----

## 🛤️ Project Status

### MVP Completed

  - [ ] Alerts system engine
  - [ ] Market API ingestion
  - [ ] Portfolio tracking logic
  - [ ] Basic prediction endpoint
  - [ ] Docker + MySQL integration
  - [ ] REST API Architecture

### Phase 2 (Planned)

  - [ ] JWT Authentication & Security
  - [ ] Historical price storage (Time-Series)
  - [ ] Advanced technical indicators (RSI, MACD)
  - [ ] AWS Deployment (RDS + ECS/App Runner)
  - [ ] CI/CD Pipeline (GitHub Actions)

-----

## 📚 Learning Goals

This project was built to bridge the gap between university theory and industry application.

  * **Backend Mastery:** Deep dive into Spring Boot internals and REST API best practices.
  * **System Design:** Understanding scheduled tasks, background workers, and service decoupling.
  * **Database Modeling:** Designing relational schemas for financial data.
  * **DevOps Culture:** Moving from "works on my machine" to containerized Docker deployments.

-----

## 👤 Author

**Stephanie Borrego Arroyo**

  * Computer Systems Engineering Student @ ITESO
  * [GitHub Profile](https://github.com/stephy0410)
  * [LinkedIn Profile](https://www.linkedin.com/in/stephanie-borrego-arroyo/)

<!-- end list -->

```

