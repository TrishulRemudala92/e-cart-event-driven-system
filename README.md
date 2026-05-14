# E-Cart Event-Driven Microservices System

This is a simple microservices-based e-cart backend system built using Java and Spring Boot.

The project is designed to demonstrate how different backend services can work independently and communicate with each other using REST APIs and Kafka-based event-driven communication.

## Project Overview
The system contains four main microservices:

- Order Service
- Payment Service
- Product Service
- User Service

Each service has its own responsibility and database connection. The Order and Payment services use Kafka to communicate through events, while Product and User services provide REST APIs for managing product and user data.

## Microservices

### 1. Order Service
The Order Service is responsible for creating and managing customer orders.

Main responsibilities:

- Create a new order
- Fetch all orders
- Fetch an order by order number
- Publish order-created events to Kafka
- Listen for payment result events

## Service Ports

| Service | Port | Description |
|---|---:|---|
| Order Service | 8081 | Handles order creation and Kafka order events |
| Product Service | 8082 | Handles product management |
| Payment Service | 8083 | Handles payment processing and Kafka payment events |
| User Service | 8084 | Handles user management |
