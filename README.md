📈 Stock Market Alerts & Portfolio Intelligence Microservice

Java · Spring Boot · MySQL · WebClient · Docker

A backend microservice that monitors stock/ETF prices in real time, evaluates user-defined alerts, tracks a personal investment portfolio, and provides basic market trend predictions.
Built to showcase production-style backend engineering using Spring Boot, real-world APIs, scheduled jobs, and containerization.

🚀 Features
🔔 Real-Time Price Alerts

Create alert rules such as “Notify me if AAPL < 160”.

System polls market prices on a fixed schedule.

Sends notifications via Telegram or Email (SendGrid).

Includes cool-down logic to avoid repeated spam alerts.

💼 Portfolio Tracker

Add positions (symbol, shares, average price).

Computes real-time value and profit/loss using current market prices.

Designed for easy extension (multiple portfolios, categories, etc.).

📊 Market Trend Prediction

Simple moving-average–based predictor.

Returns uptrend / downtrend based on recent price history.

Lightweight and easy to extend with ML later.

⚙️ Microservice Design

REST API (Spring Web).

External API integration using Spring WebClient.

Persistence with Spring Data JPA + MySQL.

Scheduled jobs using @Scheduled.

Clean layered architecture:
Controller → Service → Repository → Database.

Containerized with Docker & optional Docker Compose.

🧱 Architecture Overview
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

🛠️ Tech Stack

Java 17

Spring Boot 3+

Spring Web / WebClient

Spring Data JPA (Hibernate)

MySQL

Scheduled Tasks

Docker / Docker Compose

SendGrid or Telegram Bot API

Maven

🐳 Setup: Run MySQL with Docker
docker compose up -d


This starts a MySQL container with:

host: localhost
port: 3306
user: sa
password: sapwd
database: stockalerts

▶️ Run the Application
With Maven
mvn spring-boot:run

Build JAR
mvn clean package
java -jar target/stock-alerts-service.jar

🔧 Configuration

Located in:
src/main/resources/application.yml

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


Replace keys/tokens as needed.

📡 API Examples
➕ Create an Alert
POST /alerts
{
  "userId": 1,
  "symbol": "AAPL",
  "condition": "LT",
  "threshold": 160
}

📊 Get Portfolio Value
GET /portfolio/1/value

📉 Trend Prediction
GET /predict?symbol=AAPL&period=10

📬 Notifications
Telegram Bot (recommended for beginners)

Create a bot using @BotFather

Add your token & chat ID to application.yml

Alerts arrive instantly

SendGrid Email (optional)

Add API key

Configure sender email

Great for production-style notifications

🧪 Testing

Run unit & integration tests:

mvn test

📦 Dockerizing the App
Build
docker build -t stock-alerts .

Run
docker run -p 8080:8080 stock-alerts

🛤️ Project Status
MVP Completed

✔ Alerts system
✔ Market API ingestion
✔ Portfolio tracking
✔ Basic prediction endpoint
✔ Docker + MySQL
✔ REST API architecture

Phase 2 (Planned)

JWT authentication

Historical price storage

Advanced technical indicators (RSI, MACD)

AWS deployment (RDS + ECS/App Runner)

CI/CD pipeline

ML-based prediction

📚 Learning Goals

This project helped develop skills in:

Backend & REST API development

Spring Boot fundamentals

External API consumption

Scheduled tasks & automation

Java OOP + layered architecture

SQL & database modeling

Docker containerization

Production-style design principles

👤 Author

Stephanie Borrego Arroyo
Computer Systems Engineering @ ITESO
GitHub: your link here
LinkedIn: your link here
