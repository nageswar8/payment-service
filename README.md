# 💳 Payment Service (Spring Boot + Razorpay)

A Spring Boot-based microservice that enables secure online payment processing using Razorpay API.

## 🚀 Tech Stack
- Java 17
- Spring Boot
- REST API
- Razorpay API
- Maven

## 🔧 Features
- Create Razorpay orders
- Generate dynamic payment links
- REST API design with standard HTTP codes
- Secure API with basic error handling
- Easy integration with frontends or other services

## 📦 API Endpoints

| Method | Endpoint               | Description                  |
|--------|------------------------|------------------------------|
| POST   | `/payment/createOrder` | Create new Razorpay order    |
| GET    | `/payment/status`      | Check payment status         |

> You can test these endpoints using Postman or Swagger (if enabled).

## 🧪 Sample Request

### Create Order
```json
POST /payment/createOrder
{
  "amount": 50000,
  "currency": "INR",
  "receipt": "order_rcptid_11"
}
**### Respose**
{
  "orderId": "order_QtPWOCX62DOl1k",
  "status": "created",
  "paymentStatus": "https://checkout.razorpay.com/v1/checkout.js"
}



